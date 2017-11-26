/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaClass;

import java.io.Serializable;

/**
 *
 * @author Win-8
 */
public class DeliveryMan implements Serializable{
    String deliveryManId;
    String name;
    String phoneNumber;
    String email;
    String deliveryStatus;
    
    private static int id = 1000;

    public DeliveryMan(String deliveryManId) {
        this.deliveryManId = deliveryManId;
    }

    public DeliveryMan(String name, String phoneNumber, String email) {
        this.deliveryManId = "D" + id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        id++;
    }
    
    public String getDeliveryManId() {
        return deliveryManId;
    }

    public void setDeliveryManId(String deliveryManId) {
        this.deliveryManId = deliveryManId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return deliveryStatus;
    }

    public void setStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
