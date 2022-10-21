package InventoryManagement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CategoriesTest {

    Categories instance;
    InventoryManagementController controllerInstance;

    public CategoriesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Categories();
        controllerInstance = new InventoryManagementController();

        //set category to test (COSMETIC)
        controllerInstance.changeLocation(InventoryManagementController.Location.CATEGORY_COSMETIC);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCurrentCategory method, of class Categories.
     */
    @Test
    public void getCurrentLocation() {
        System.out.println("categories.getCurrentCategory");

        //set results
        String currentCategory = instance.getCurrentCategory(controllerInstance);
        String expectedCategory = "COSMETIC";

        assertEquals(currentCategory, expectedCategory);
    }

    /**
     * Test of changeLocationToCategory method, of class Categories.
     */
    @Test
    public void testChangeLocationToCategory1() {
        System.out.println("changeLocationToCategory");

        //unavailable category (Pets)
        instance.changeLocationToCategory(controllerInstance, "Pets");

        String currentCategory = instance.getCurrentCategory(controllerInstance);
        String expectedCategory = "unknown";

        assertEquals(currentCategory, expectedCategory);
    }

    @Test
    public void testChangeLocationToCategory2() {
        System.out.println("changeLocationToCategory");

        instance.changeLocationToCategory(controllerInstance, "Food");

        String currentCategory = instance.getCurrentCategory(controllerInstance);
        String expectedCategory = "FOOD";

        assertEquals(currentCategory, expectedCategory);
    }
}
