/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint3;

/**
 *
 * @author User
 */
public class Schedule2 {
    
    String restaurantName;
    int date;
    int month;
    int year;
    String foodName;
    int FoodQuantity;
    String address;
    int status;



    public Schedule2(String restaurantName, int date, int month, int year, String foodName, int FoodQuantity, String address, int status) {
        this.restaurantName = restaurantName;
        this.date = date;
        this.month = month;
        this.year = year;
        this.foodName = foodName;
        this.FoodQuantity = FoodQuantity;
        this.address = address;
        this.status = status;
    }


    public int getStatus() {
        return status;
    }


    public String getRestaurantName() {
        return restaurantName;
    }

    public int getDate() {
        return date;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getFoodQuantity() {
        return FoodQuantity;
    }

    public String getAddress() {
        return address;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setDate(int date) {
        this.date = date;
    }


    public void setStatus(int status) {
        this.status = status;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodQuantity(int FoodQuantity) {
        this.FoodQuantity = FoodQuantity;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("Restaurant Name: %s\n  Food Name: %s\n  Date: %d.%d.%d\n  Food Quantity: %d", restaurantName, foodName, date, month, year, FoodQuantity); 
    }
    
    
    
}
