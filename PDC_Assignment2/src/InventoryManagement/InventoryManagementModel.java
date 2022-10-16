package InventoryManagement;

//derby database handling
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
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void createExampleTables() {
        exampleTables = new DBTables();
        exampleTables.createTables();
    }

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

    public Item getItem(String table, String itemName) {
        Item item = null;

        try {
            this.statement = conn.createStatement();
            ResultSet rs = this.statement.executeQuery("SELECT * FROM " + table + " WHERE ITEM_NAME = " + itemName);
            rs.next();

            ItemFactory factory = new ItemFactory();
            item = factory.createItem(table, rs.getString(1), rs.getDouble(2), rs.getInt(3), rs.getString(4));

            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryManagementModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return item;
    }
}
