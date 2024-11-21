package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuDAO {
    public void addDish(String name, double price) {
        String sql = "INSERT INTO Menu (name, price) VALUES (?, ?)";
        try (Connection conn = RestaurantDatabase.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.executeUpdate();
            System.out.println("Dish added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getDishById(int id) {
        String sql = "SELECT * FROM Menu WHERE id = ?";
        try (Connection conn = RestaurantDatabase.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Price: " + rs.getDouble("price"));
            } else {
                System.out.println("Dish not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDish(int id, String newName, double newPrice) {
        String sql = "UPDATE Menu SET name = ?, price = ? WHERE id = ?";
        try (Connection conn = RestaurantDatabase.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setDouble(2, newPrice);
            pstmt.setInt(3, id);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Dish updated successfully.");
            } else {
                System.out.println("Dish not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDish(int id) {
        String sql = "DELETE FROM Menu WHERE id = ?";
        try (Connection conn = RestaurantDatabase.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Dish deleted successfully.");
            } else {
                System.out.println("Dish not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}