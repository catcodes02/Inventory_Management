package InventoryManagement;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBTables {

    private InventoryManagementModel model;
    private Connection conn;
    private Statement statement;

    public DBTables() {
        this.model = InventoryManagementModel.getInstance();
        this.conn = this.model.getConnection();
        try {
            this.statement = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBTables.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createTables() {
        //food items table
        foodTable();
        //cleaning supplies items table
        cleaningTable();
        //cosmetic items table
        cosmeticTable();
    }

//category tables
    private void foodTable() {
        if (!checkTableExists("Food")) { //creates table if doesn't yet exist
            System.out.println("Creating table Food");
            try {
                this.statement = conn.createStatement();
                this.statement.addBatch("CREATE TABLE Food (item_name VARCHAR(50), quantity INT, price DOUBLE, shelf_life INT)");
                this.statement.addBatch("INSERT INTO Food VALUES "
                        + "('banana', 228, 3.3, 13), \n"
                        + "('eggs', 49, 7.79, 21), \n"
                        + "('chicken', 37, 15.0, 5), \n"
                        + "('shrimp', 23, 19.0, 2), \n"
                        + "('corn flakes', 52, 3.9, 150), \n"
                        + "('blueberry jam', 9, 4.2, 365), \n"
                        + "('cucumber', 49, 3.99, 14), \n"
                        + "('noodles', 17, 12.1, 548), \n"
                        + "('milk', 68, 29.43, 7), \n"
                        + "('rice', 20, 3.5, -1), \n"
                        + "('muffin', 17, 1.99, 5)"
                );

                this.statement.executeBatch();
            } catch (SQLException ex) {
                Logger.getLogger(DBTables.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void cleaningTable() {
        if (!checkTableExists("Cleaning")) { //creates table if doesn't yet exist
            System.out.println("Creating table Cleaning");
            try {
                this.statement = conn.createStatement();
                this.statement.addBatch("CREATE TABLE Cleaning (item_name VARCHAR(50), quantity INT, price DOUBLE, usage VARCHAR(50))");
                this.statement.addBatch("INSERT INTO Cleaning VALUES "
                        + "('detergent', 68, 4.5, 'laundry'), \n"
                        + "('drain cleaner', 22, 14.35, 'sinks/drains'), \n"
                        + "('bleach', 71, 3.2, 'general')"
                );

                this.statement.executeBatch();
            } catch (SQLException ex) {
                Logger.getLogger(DBTables.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void cosmeticTable() {
        if (!checkTableExists("Cosmetic")) { //creates table if doesn't yet exist
            System.out.println("Creating table Cosmetic");
            try {
                this.statement = conn.createStatement();
                this.statement.addBatch("CREATE TABLE Cosmetic (item_name VARCHAR(50), quantity INT, price DOUBLE, application VARCHAR(50))");
                this.statement.addBatch("INSERT INTO Cosmetic VALUES "
                        + "('eyeshadow', 12, 5.18, 'eyelids'), \n"
                        + "('lipstick', 63, 4.13, 'lips'), \n"
                        + "('mascara', 78, 37.95, 'eyelashes'), \n"
                        + "('nail polish', 140, 22.99, 'nails')"
                );

                this.statement.executeBatch();
            } catch (SQLException ex) {
                Logger.getLogger(DBTables.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private boolean checkTableExists(String name) {
        boolean result = false;

        try {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types = {"TABLE"};
            statement = this.conn.createStatement();
            ResultSet rs = dbmd.getTables(null, null, null, types);

            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");

                if (table_name.equalsIgnoreCase(name)) {
                    System.out.println("Table " + name + " exists");
                    result = true;
                    break;
                }
            }

            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBTables.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
}
