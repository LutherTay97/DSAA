/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderEstimateTime;

import java.io.Serializable;

public class Customer implements Serializable{
    
    private String customerId;
    private String phoneNo;
    private String name;
    private String areaCode;
    private static int id = 1000;
    
    public Customer() {
        
    }

    public Customer(String phoneNo, String name, String areaCode) {
        this.customerId = "C" + id;
        this.phoneNo = phoneNo;
        this.name = name;
        this.areaCode = areaCode;
        id++;
    }

    public String getId() {
        return customerId;
    }

    public void setId(String id) {
        this.customerId = id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public String toString() {
        return "Customer{" + "phoneNo=" + phoneNo + ", name=" + name + ", areaCode=" + areaCode + '}';
    }
    
}
