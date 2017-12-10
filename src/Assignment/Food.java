/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

public class Food {
    
    private int id;
    private int number;
    private String food;
    private double price;

    public Food(int id) {
        this.id = id;
    }

    public Food(int id, int number, String food, double price) {
        this.id = id;
        this.number = number;
        this.food = food;
        this.price = price;
    }

    public Food(String food, double price) {
        this.food = food;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + id + ", food=" + food + ", price=" + price + '}';
    }
    
    
}
