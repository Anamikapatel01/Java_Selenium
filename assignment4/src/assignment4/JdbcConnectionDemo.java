package assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionDemo {

    public static void main(String[] args) {

        // 1. Database URL, username, password
        String url = "jdbc:mysql://localhost:3306/simple_school"; 
        String username = "root";   
        String password = "root123";   

        Connection con = null;

        try {
            // 2. Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3. Establish connection
            con = DriverManager.getConnection(url, username, password);

            // 4. Check connection
            if (con != null) {
                System.out.println("Connection Successful");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found");
        } catch (SQLException e) {
            System.out.println("Unable to connect");
        } finally {
            try {
                // 5. Close connection
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

