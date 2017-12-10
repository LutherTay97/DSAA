/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asspartb;
import java.io.Serializable;
/**
 *
 * @author A555LD
 */
public class DeliveryMan implements Serializable,DeliveryManInterface{
    private String deliveryManId;
    private String deliveryManName;
    private String deliveryManIC;
    private String deliveryManPassword;
    private String deliveryManAddress;
    private String deliveryManPhoneNo;
    private String deliveryManEmergencyContact;//New
    private String deliveryManWorkArea;//new
    private String deliveryManStatus;//new
    private String deliveryManPersonalStatus;//new 
    
    
    
    
    //private static int autoNumber = 1000;
    
    public DeliveryMan() {
        
    }
    
    public DeliveryMan(int autoNumber, String deliveryManName, String deliveryManIC,String deliveryManPassword,String deliveryManAddress, String deliveryManPhoneNo,String deliveryManEmergencyContact,String deliveryManWorkArea,String deliveryManStatus, String deliveryManPersonalStatus){
        this.deliveryManId = "D" + autoNumber;
        this.deliveryManName = deliveryManName;
        this.deliveryManIC = deliveryManIC;
        this.deliveryManPassword = deliveryManPassword;
        this.deliveryManAddress = deliveryManAddress;
        this.deliveryManPhoneNo = deliveryManPhoneNo;
        this.deliveryManEmergencyContact = deliveryManEmergencyContact;
        this.deliveryManWorkArea = deliveryManWorkArea;
        this.deliveryManStatus = deliveryManStatus;
        this.deliveryManPersonalStatus = deliveryManPersonalStatus;
        
    }

    public String getDeliveryManEmergencyContact() {
        return deliveryManEmergencyContact;
    }

    public String getDeliveryManStatus() {
        return deliveryManStatus;
    }

    public void setDeliveryManStatus(String deliveryManStatus) {
        this.deliveryManStatus = deliveryManStatus;
    }

    public String getDeliveryManPersonalStatus() {
        return deliveryManPersonalStatus;
    }

    public void setDeliveryManPersonalStatus(String deliveryManPersonalStatus) {
        this.deliveryManPersonalStatus = deliveryManPersonalStatus;
    }

    public void setDeliveryManEmergencyContact(String deliveryManEmergencyContact) {
        this.deliveryManEmergencyContact = deliveryManEmergencyContact;
    }

    public String getDeliveryManWorkArea() {
        return deliveryManWorkArea;
    }

    public void setDeliveryManWorkArea(String deliveryManWorkArea) {
        this.deliveryManWorkArea = deliveryManWorkArea;
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

    public String getDeliveryManIC() {
        return deliveryManIC;
    }

    public void setDeliveryManIC(String deliveryManIC) {
        this.deliveryManIC = deliveryManIC;
    }

    public String getDeliveryManPassword() {
        return deliveryManPassword;
    }

    public void setDeliveryManPassword(String deliveryManPassword) {
        this.deliveryManPassword = deliveryManPassword;
    }

    public String getDeliveryManAddress() {
        return deliveryManAddress;
    }

    public void setDeliveryManAddress(String deliveryManAddress) {
        this.deliveryManAddress = deliveryManAddress;
    }

    public String getDeliveryManPhoneNo() {
        return deliveryManPhoneNo;
    }

    public void setDeliveryManPhoneNo(String deliveryManPhoneNo) {
        this.deliveryManPhoneNo = deliveryManPhoneNo;
    }

    public boolean validateDeliveryManName(String deliveryName) {
        boolean isValid = false;
        
            if (deliveryName.matches("[a-zA-Z ]+"))
            {
                isValid = true;
            }
        
        return isValid;
    }
    
    
    public boolean validateDeliveryManIC(String deliveryManIC) {
        boolean isValid = false;
        
        if (deliveryManIC.matches("([0-9][0-9])((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))-([0-9][0-9])-([0-9][0-9][0-9][0-9])"))
        {
            isValid = true;
        }
        
        return isValid;
    }
    
     public boolean validateDeliveryManAddress(String DeliveryManAddress) {
        boolean isValid = false;
        
        if (DeliveryManAddress.matches( "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)")) 
        {
            isValid = true;
        }
        
        return isValid;
    }
  
  public boolean validateDeliveryManPassword(String DeliveryManPassword) {
        boolean isValid = false;

    
        if (DeliveryManPassword.matches( "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})")) 
        {
            isValid = true;
        }
        
        return isValid;
    }
  
  public boolean validateDeliveryManPhoneNo(String DeliveryManPhoneNo) {
        boolean isValid = false;

    
        if (DeliveryManPhoneNo.matches("\\d{3}-\\d{7}")) 
        {
            isValid = true;
        }
        
        return isValid;
    }
  
  
  
  public boolean validateDeliveryManEmergencyContact(String deliveryManEmergencyContact) {
        boolean isValid = false;
        
        if (deliveryManEmergencyContact.matches("\\d{3}-\\d{7}"))
        {
            isValid = true;
        }
        
        return isValid;
    }
  
   public boolean validateDeliveryManWorkArea(String deliveryManWorkArea) {
        boolean isValid = false;
        
        if (deliveryManWorkArea.matches("\\d{3}-\\d{7}"))
        {
            isValid = true;
        }
        
        return isValid;
    }
  
  public boolean validateDeliveryPersonalStatus(String DeliveryManPersonalStatus) {
        boolean isValid = false;
        DeliveryManPersonalStatus.toLowerCase();
        if (DeliveryManPersonalStatus.matches("retired") || DeliveryManPersonalStatus.matches("resigned") ) 
        {
            isValid = true;
        }
        
        return isValid;
    }
  
    
    public int compareTo(DeliveryManInterface other) {
        return this.getDeliveryManName().compareTo(other.getDeliveryManName());
    }
    
    
    
    
}
