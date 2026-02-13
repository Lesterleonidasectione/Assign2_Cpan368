package dao;

import java.sql.*;

public class RegisterDAO {
    // These match your MySQL Workbench screenshots
    private String dbURL = "jdbc:mysql://localhost:3306/cpan368";
    private String dbUser = "cpan368_lesterleonida";
    private String dbPass = "Pass123";

    // Method 1: Inserting Data
    public int registerUser(String fname, String lname, String email, String uname, String pass) {
        String INSERT_SQL = "INSERT INTO users (firstname, lastname, email, username, password) VALUES (?, ?, ?, ?, ?);";
        int result = 0;

        try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, email);
            ps.setString(4, uname);
            ps.setString(5, pass);

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Method 2: Selecting Data
    public void selectUser(String uname) {
        String SELECT_SQL = "SELECT * FROM users WHERE username = ?;";

        try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
             PreparedStatement ps = conn.prepareStatement(SELECT_SQL)) {
            
            ps.setString(1, uname);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("User Found: " + rs.getString("firstname") + " " + rs.getString("lastname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}