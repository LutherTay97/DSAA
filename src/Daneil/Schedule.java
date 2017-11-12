/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daneil;

/**
 *
 * @author User
 */
public class Schedule {
    
    String restaurantName;
    String fullDate;
    String foodName;
    String FoodQuantity;

    public Schedule(String restaurantName, String fullDate, String foodName, String FoodQuantity) {
        this.restaurantName = restaurantName;
        this.fullDate = fullDate;
        this.foodName = foodName;
        this.FoodQuantity = FoodQuantity;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getFullDate() {
        return fullDate;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodQuantity() {
        return FoodQuantity;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setFullDate(String fullDate) {
        this.fullDate = fullDate;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodQuantity(String FoodQuantity) {
        this.FoodQuantity = FoodQuantity;
    }
    
    
}
