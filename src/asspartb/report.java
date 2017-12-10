/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asspartb;

/**
 *
 * @author A555LD
 */
public class report implements reportInterface{
     private String deliveryManId;
    private String deliveryManName;
    private String deliveryManComplete;
    private String deliveryManDiatance;
    
    
    public report() {
        
    }
    public report(String autoNumber, String deliveryManName, String deliveryManComplete,String deliveryManDiatance){
        this.deliveryManId = "D" + autoNumber;
        this.deliveryManName = deliveryManName;
        this.deliveryManComplete = deliveryManComplete;
        this.deliveryManDiatance = deliveryManDiatance;
       
        
    }

    public String getDeliveryManId() {
        return deliveryManId;
    }

    public void setDeliveryManId(String deliveryManId) {
        this.deliveryManId = deliveryManId;
    }

    public String getDeliveryManName() {
        return deliveryManName;
    }

    public void setDeliveryManName(String deliveryManName) {
        this.deliveryManName = deliveryManName;
    }

    public String getDeliveryManComplete() {
        return deliveryManComplete;
    }

    public void setDeliveryManComplete(String deliveryManComplete) {
        this.deliveryManComplete = deliveryManComplete;
    }

    public String getDeliveryManDiatance() {
        return deliveryManDiatance;
    }

    public void setDeliveryManDiatance(String deliveryManDiatance) {
        this.deliveryManDiatance = deliveryManDiatance;
    }


   
    
    public String toString() {
        return String.format("%-20s%8s%20s\n",getDeliveryManName(),getDeliveryManComplete(),getDeliveryManDiatance());
                   
   }
}
