package com.isaka.dineview.models;

public class Favorite {
    private int id;
    private String restaurantName;
    private String restaurantAddress;

    // Constructor
    public Favorite(int id, String restaurantName, String restaurantAddress) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    // toString method (optional)
    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                '}';
    }
}
