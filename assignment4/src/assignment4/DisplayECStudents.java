package assignment4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayECStudents {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/simple_school";
        String username = "root";
        String password = "root123"; 

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            con = DriverManager.getConnection(url, username, password);

            // 3. Create Statement
            stmt = con.createStatement();

            // 4. SQL Query
            String selectSQL =
                    "SELECT * FROM Students WHERE semester = 7 AND branch = 'EC'";

            // 5. Execute Query
            rs = stmt.executeQuery(selectSQL);

            System.out.println("Students of Semester 7 (EC Branch):");
            System.out.println("------------------------------------");

            // 6. Display Records
            while (rs.next()) {
                System.out.println(
                        "Student ID: " + rs.getInt("student_id") +
                        ", Name: " + rs.getString("name") +
                        ", Branch: " + rs.getString("branch") +
                        ", Semester: " + rs.getInt("semester") +
                        ", Percentage: " + rs.getFloat("percentage") +
                        ", Year: " + rs.getInt("year_of_passing")
                );
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
