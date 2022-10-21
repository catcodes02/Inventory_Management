package InventoryManagement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemFactoryTest {

    private ItemFactory instance;
    private String name;
    private int quantity;
    private double price;

    public ItemFactoryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new ItemFactory();

        name = "testItem";
        quantity = 2;
        price = 5.85;
    }

    @After
    public void tearDown() {
    }

    /**
     * Tests of createItem method, of class ItemFactory.
     *
     * One test per item type, (FoodItem, CleaningItem, CosmeticItem).
     */
    @Test
    public void testCreateItem1() {
        System.out.println("createItem -> FoodItem");

        String category = "food";
        String other = "10";
        Item result = instance.createItem(category, name, quantity, price, other);

        assertTrue(result instanceof FoodItem);
    }

    @Test
    public void testCreateItem2() {
        System.out.println("createItem -> CleaningItem");

        String category = "cleaning";
        String other = "Window";
        Item result = instance.createItem(category, name, quantity, price, other);

        assertTrue(result instanceof CleaningItem);
    }

    @Test
    public void testCreateItem3() {
        System.out.println("createItem -> CosmeticItem");

        String category = "cosmetic";
        String other = "eyebrows";
        Item result = instance.createItem(category, name, quantity, price, other);

        assertTrue(result instanceof CosmeticItem);
    }
}
