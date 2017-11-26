/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daneil;

/**
 *
 * @author User
 */
public class DeliveryMan {
    
    String deliveryUserName;
    int deliveryManID;
    int status;

    public DeliveryMan(int deliveryManID, int status) {
        this.deliveryManID = deliveryManID;
        this.status = status;
    }

    public DeliveryMan(String deliveryUserName, int deliveryManID) {
        this.deliveryUserName = deliveryUserName;
        this.deliveryManID = deliveryManID;
    }

    public int getDeliveryManID() {
        return deliveryManID;
    }

    

    public DeliveryMan(String deliveryUserName) {
        this.deliveryUserName = deliveryUserName;
    }

    public String getDeliveryUserName() {
        return deliveryUserName;
    }

    public int getStatus() {
        return status;
    }

    public void setDeliveryUserName(String deliveryUserName) {
        this.deliveryUserName = deliveryUserName;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDeliveryManID(int deliveryManID) {
        this.deliveryManID = deliveryManID;
    }

    @Override
    public String toString() {
        return String.format(deliveryUserName, "\n");
    }
    
    
    
    
   
    
    
}
