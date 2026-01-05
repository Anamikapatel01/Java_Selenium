package assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateCSEPercentage {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/simple_school"; // your DB
        String username = "root";
        String password = "root123"; 
        Connection con = null;
        Statement stmt = null;

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            con = DriverManager.getConnection(url, username, password);

            // 3. Create Statement
            stmt = con.createStatement();

            // 4. Update percentage by 5% for CSE students
            String updateSQL = "UPDATE Students "
                             + "SET percentage = percentage * 1.05 "
                             + "WHERE branch = 'CSE'";

            int rowsUpdated = stmt.executeUpdate(updateSQL);
            System.out.println(rowsUpdated + " record(s) updated successfully.");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
