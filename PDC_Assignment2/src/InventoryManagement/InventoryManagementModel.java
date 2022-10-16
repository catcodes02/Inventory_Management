package InventoryManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InventoryManagementModel {

    private static InventoryManagementModel instance;
    private DBTables exampleTables;

    private static final String USER_NAME = "pdc"; //your DB username
    private static final String PASSWORD = "pdc"; //your DB password
    private static final String URL = "jdbc:derby:InventoryManagement_EDB;create=true"; //url of the DB host

    Connection conn;
    private Statement statement;

    private InventoryManagementModel() {
        //connect to db
        this.establishConnection();
    }

    //singleton pattern
    public static InventoryManagementModel getInstance() {
        if (instance == null) {
            instance = new InventoryManagementModel();
        }
        return instance;
    }

    public Connection getConnection() {
        return this.conn;
    }

    //Establish connection
    public void establishConnection() {
        //Establish a connection to Database
        try {
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println(URL + " connected...");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("closed connection.");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    //create and write (fill) example tables
    public void createExampleTables() {
        exampleTables = new DBTables();
        exampleTables.createTables();
    }

//reading
    public String[] getItemNames(String table) {
        ArrayList<String> itemNames = new ArrayList();

        try {
            this.statement = conn.createStatement();
            ResultSet rs = this.statement.executeQuery("SELECT ITEM_NAME FROM " + table);

            while (rs.next()) {
                itemNames.add(rs.getString(1));
            }

            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryManagementModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[] returnArray = new String[itemNames.size()];
        return itemNames.toArray(returnArray);
    }

    public int getItemQuantity(String table, String itemName) {
        int quantity = 0;

        try {
            this.statement = conn.createStatement();
            ResultSet rs = this.statement.executeQuery("SELECT QUANTITY FROM " + table + " WHERE ITEM_NAME = '" + itemName + "'");
            rs.next();
            quantity = rs.getInt(1);

            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryManagementModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return quantity;
    }

    public Item getItem(String table, String itemName) {
        Item item = null;

        try {
            this.statement = conn.createStatement();
            ResultSet rs = this.statement.executeQuery("SELECT * FROM " + table + " WHERE ITEM_NAME = '" + itemName + "'");
            rs.next();

            ItemFactory factory = new ItemFactory();
            item = factory.createItem(table, rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getString(4));

            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryManagementModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return item;
    }

    public Item[] getTable(String table) {
        String[] itemNames = this.getItemNames(table);
        Item[] items = new Item[itemNames.length];

        for (int i = 0; i < itemNames.length; i++) {
            items[i] = this.getItem(table, itemNames[i]);
        }

        return items;
    }

//writting
    public void updateItemQuantity(String table, String itemName, int amount) {
        try {
            this.statement = conn.createStatement();
            ResultSet rs = this.statement.executeQuery("SELECT QUANTITY FROM " + table + " WHERE ITEM_NAME = '" + itemName + "'");
            rs.next();
            amount += rs.getInt(1);
            this.statement.execute("UPDATE " + table + " SET QUANTITY = " + amount + " WHERE ITEM_NAME = '" + itemName + "'");

            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryManagementModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addItem(String table, Item item) {
        try {
            this.statement = conn.createStatement();
            this.statement.execute("INSERT INTO " + table + " VALUES " + item.getSQLString());

        } catch (SQLException ex) {
            Logger.getLogger(InventoryManagementModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeItem(String table, String itemName) {
        try {
            this.statement = conn.createStatement();
            this.statement.execute("DELETE FROM " + table + " WHERE ITEM_NAME = '" + itemName + "'");

        } catch (SQLException ex) {
            Logger.getLogger(InventoryManagementModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
