package assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStudentsTable {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/simple_school";
        String username = "root";
        String password = "root123";

        Connection con = null;
        Statement stmt = null;

        try {
            // 1. Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            con = DriverManager.getConnection(url, username, password);

            // 3. Create statement
            stmt = con.createStatement();

            // 4. Create Students table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Students ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "name VARCHAR(50) NOT NULL, "
                    + "age INT NOT NULL"
                    + ")";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'Students' created successfully.");

            // 5. Insert records
            String insertSQL1 = "INSERT INTO Students (name, age,class,branch,semester,percentage,year_of_passing) VALUES ('kamala trpathi', 20,12,'Science',7,82.3,2026)";
            String insertSQL2 = "INSERT INTO Students (name, age,class,branch,semester,percentage,year_of_passing) VALUES ('gurpreet kuar', 22,11,'AI',7,93.3,2026)";
            String insertSQL3 = "INSERT INTO Students (name, age,class,branch,semester,percentage,year_of_passing) VALUES ('utkarsh singh', 19,12,'Civil',7,99.9,2026)";

            stmt.executeUpdate(insertSQL1);
            stmt.executeUpdate(insertSQL2);
            stmt.executeUpdate(insertSQL3);

            System.out.println("Records inserted successfully.");

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
