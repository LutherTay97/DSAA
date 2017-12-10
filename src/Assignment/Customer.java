/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

public class Customer {
    
    private int id;
    private String phoneNo;
    private String name;
    private String areaCode;
    
    public Customer() {
        
    }

    public Customer(int id) {
        this.id = id;
    }

    public Customer(String phoneNo, String name, String areaCode) {
        this.phoneNo = phoneNo;
        this.name = name;
        this.areaCode = areaCode;
    }

    public Customer(int id, String phoneNo, String name, String areaCode) {
        this.id = id;
        this.phoneNo = phoneNo;
        this.name = name;
        this.areaCode = areaCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
