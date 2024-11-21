package org.example;

public class RestaurantApp {
    public static void main(String[] args) {
        MenuDAO menuDAO = new MenuDAO();

        menuDAO.addDish("Borscht", 120.50);
        menuDAO.addDish("Caesar Salad", 150.00);

        menuDAO.getDishById(1);

        menuDAO.updateDish(1, "Borscht with Sour Cream", 130.00);

        menuDAO.deleteDish(2);
    }
}