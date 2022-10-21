package InventoryManagement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InventoryManagementControllerTest {

    InventoryManagementController instance;

    public InventoryManagementControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new InventoryManagementController();
    }

    @After
    public void tearDown() {
        //endProgram()
        instance.model.closeConnections();
//        controllerInstance.view.dispose();
    }

    /**
     * Test of changeLocation method, of class InventoryManagementController.
     */
    @Test
    public void testChangeLocation() {
        System.out.println("changeLocation");

        InventoryManagementController.Location location = InventoryManagementController.Location.HOME;
        instance.changeLocation(location);

        assertEquals(location, instance.currentLocation);
    }
}
