package InventoryManagement;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InventoryManagementModelTest {

    InventoryManagementModel instance;

    public InventoryManagementModelTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.out.println("getting instance...");
        instance = InventoryManagementModel.getInstance();
        //make sure connection is available for testing
        instance.establishConnection();
        //using example tables to test
        instance.createExampleTables();
    }

    @After
    public void tearDown() {
        instance.closeConnections();
    }

    /**
     * Test of getInstance method, of class InventoryManagementModel.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");

        InventoryManagementModel result = InventoryManagementModel.getInstance();

        assertTrue(result != null);
    }

    /**
     * Test of establishConnection method, of class InventoryManagementModel.
     */
    @Test
    public void testEstablishConnection() {
        System.out.println("establishConnection");

//        instance.establishConnection(); //called in instance creation
        Connection result = instance.getConnection();

        assertTrue(result != null);
    }

    /**
     * Test of getItemNames method, of class InventoryManagementModel.
     */
    @Test
    public void testGetItemNames() {
        System.out.println("getItemNames");

        String table = "FOOD";
        String[] result = instance.getItemNames(table);
        String firstIndex = result[0];

        assertNotNull(result); //array exists
        assertNotNull(firstIndex); //array is filled
    }

    /**
     * Test of getItem method, of class InventoryManagementModel.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");

        String table = "COSMETIC";
        String itemName = "lipstick"; //only works if using initial example tables

        Item result = instance.getItem(table, itemName);

        String resultName = result.getName();
        String expectedName = "lipstick";

        assertNotNull(result); //item exists
        assertTrue(result instanceof CosmeticItem); //correct item type
        assertEquals(resultName, expectedName); //correct item created
    }

    /**
     * Test of getTable method, of class InventoryManagementModel.
     */
    @Test
    public void testGetTable() {
        System.out.println("getTable");

        String table = "CLEANING";
        String[] result = instance.getItemNames(table);
        String firstIndex = result[0];

        assertNotNull(result); //array exists
        assertNotNull(firstIndex); //array is filled
    }
}
