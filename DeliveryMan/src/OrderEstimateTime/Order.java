/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderEstimateTime;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
    
    private String orderId;
    private Customer customer;
    private String orderStatus;
    private Date orderDate;
    private Date estimateArrivalTime;

    public Date getEstimateArrivalTime() {
        return estimateArrivalTime;
    }

    public void setEstimateArrivalTime(Date estimateArrivalTime) {
        this.estimateArrivalTime = estimateArrivalTime;
    }
    private double totalPrice;
    
    private static int id = 1000;    

    public Order(Customer customer, String orderStatus, Date orderDate) {
        this.orderId = "O" + id;
        this.customer = customer;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        id++;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderTime(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
