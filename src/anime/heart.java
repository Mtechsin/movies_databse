/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anime;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mtech
 */
public class heart {

    public static String name;

    public void open(JFrame own) {
        own.setLocationRelativeTo(null);
        own.setVisible(true);
    }

    public void go_to_login(JFrame current) {
        current.dispose();
        login l = new login();
        open(l);
    }

    public void go_to_main(JFrame current) {
        current.dispose();
        movieview l = new movieview();
        open(l);
    }

    public void go_to_admin(JFrame current) {
        current.dispose();
        admin l = new admin();
        open(l);
    }

    public void go_to_signup(JFrame current) {
        current.dispose();
        signup l = new signup();
        open(l);
    }

    public void go_to_anime(JFrame current) {
        current.dispose();
        anime_view l = new anime_view();
        open(l);
    }

    public void getusers(JTable table) {
        // Database connection details
        final String url = "jdbc:mysql://localhost:3306/movies";
        final String user = "root";
        final String dbPassword = "";
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // SQL query to check if user and password are in the database
        String sql = "SELECT * FROM users";

        try (java.sql.Connection conn = DriverManager.getConnection(url, user, dbPassword); java.sql.Statement statement = conn.createStatement();) {

            // Set query parameter
            // Execute the query
            java.sql.ResultSet resultSet = statement.executeQuery(sql);

            // Check if any rows are returned
            while (resultSet.next()) {
                model.addRow(new Object[]{
                    resultSet.getInt("userid"),
                    resultSet.getString("name"),
                    resultSet.getString("username"),
                    resultSet.getBoolean("is_admin")
                });
            }
            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User and password not found in the database
    }

    public String getuser(String username, JTable table) {
        // Database connection details
        final String url = "jdbc:mysql://localhost:3306/movies";
        final String user = "root";
        final String dbPassword = "";
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // SQL query to check if user and password are in the database
        String sql = "SELECT * FROM users where username = " + String.valueOf(username);

        try (java.sql.Connection conn = DriverManager.getConnection(url, user, dbPassword); java.sql.Statement statement = conn.createStatement();) {

            // Set query parameter
            // Execute the query
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString("name");
            }

            // Check if any rows are returned
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User and password not found in the database
        return null;
    }
    /*
    public static void staticgotomain(JFrame current) {
        current.dispose();
        m = new mainview();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
    }
     */
}
