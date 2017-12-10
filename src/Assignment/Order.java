/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.util.Date;

public class Order {
    
    private int id;
    private String name;
    private int quantity;
    private String paymentStatus;
    private Date orderTime;
    private double price;

    public Order() {
    }

    public Order(int id) {
        this.id = id;
    }

    public Order(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public Order(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Order(int id, String name, int quantity, String paymentStatus, Date orderTime, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.paymentStatus = paymentStatus;
        this.orderTime = orderTime;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", name=" + name + ", quantity=" + quantity + ", paymentStatus=" + paymentStatus + ", orderTime=" + orderTime + ", price=" + price + "}\n";
    }
    
    public static double countEachPrice(int quantity, double price) {
        return quantity * price;
    }
    
}
