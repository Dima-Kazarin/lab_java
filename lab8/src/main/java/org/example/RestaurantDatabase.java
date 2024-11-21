package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RestaurantDatabase {
    private static final String URL = "jdbc:sqlite:Restaurant.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}