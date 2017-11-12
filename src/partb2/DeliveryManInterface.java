/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partb2;

/**
 *
 * @author A555LD
 */
public interface DeliveryManInterface{
     //getter
    
    public String getDeliveryManName();
    public String getDeliveryManIC();
    public String getDeliveryManPassword();
    public String getDeliveryManAddress();
    public String getDeliveryManPhoneNo();
   
    //setter
   
    public void setDeliveryManName(String deliveryManName);
    public void setDeliveryManIC(String deliveryManIC);
    public void setDeliveryManPassword(String deliveryManPassword);
    public void setDeliveryManAddress(String deliveryManAddress);
    public void setDeliveryManPhoneNo(String deliveryManPhoneNo);
    
    public boolean validateDeliveryManName(String deliveryName);
    public boolean validateDeliveryManIC(String deliveryManIC);
    public boolean validateDeliveryManAddress(String deDeliveryManAddress);
    public boolean validateDeliveryManPassword(String DeliveryManPassword);
    public boolean validateDeliveryManPhoneNo(String DeliveryManPhoneNo);
}
