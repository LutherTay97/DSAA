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
public interface DeliveryManInterface extends Comparable<DeliveryManInterface>{
    //getter
    public String getDeliveryManId(); 
    public String getDeliveryManName();
    public String getDeliveryManIC();
    public String getDeliveryManPassword();
    public String getDeliveryManAddress();
    public String getDeliveryManPhoneNo();
    public String getDeliveryManEmergencyContact();
    public String getDeliveryManWorkArea();
    public String getDeliveryManStatus();
    public String getDeliveryManPersonalStatus();
   
   

    
    //setter
    public void setDeliveryManId(String deliveryManId);
    public void setDeliveryManName(String deliveryManName);
    public void setDeliveryManIC(String deliveryManIC);
    public void setDeliveryManPassword(String deliveryManPassword);
    public void setDeliveryManAddress(String deliveryManAddress);
    public void setDeliveryManPhoneNo(String deliveryManPhoneNo);
    public void setDeliveryManEmergencyContact(String deliveryManEmergencyContact);
    public void setDeliveryManWorkArea(String deliveryManWorkArea);
    
    public void setDeliveryManStatus(String deliveryManStatus);
    public void setDeliveryManPersonalStatus(String deliveryManPersonalStatus);
    
    
    public boolean validateDeliveryManName(String deliveryName);
    public boolean validateDeliveryManIC(String deliveryManIC);
    
    public boolean validateDeliveryManAddress(String deDeliveryManAddress);
    public boolean validateDeliveryManPassword(String DeliveryManPassword);
    public boolean validateDeliveryManPhoneNo(String DeliveryManPhoneNo);
    public boolean validateDeliveryManEmergencyContact(String DeliveryManEmergencyContact);
    public boolean validateDeliveryPersonalStatus(String DeliveryManPersonalStatus);
}
