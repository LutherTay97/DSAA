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
import java.util.Scanner;
public class AssPartB {

    /**
     * @param args the command line arguments
     */
    
    private static Scanner sc = new Scanner(System.in);
    private static DeliveryManInterface deliveryMan = new DeliveryMan();
    static StoredListkedList<DeliveryManInterface> deliveryManList = new StoredListkedList<DeliveryManInterface>();
    
    
    
    public static void main(String[] args) {
        System.out.println("\t\t ____________________________________"); 
        System.out.println("\t\t|                                    |");
        System.out.println("\t\t|    Maintain Delivery man module    |");
        System.out.println("\t\t|____________________________________|\n");
        mainMenu(); //call main menu 
    
}
    public static void mainMenu() {
        int MainMenuOption;
        char cont = 'Y';
        
        do{
            System.out.println("\n << Maintain Delivery Man Module >>");
            System.out.println("1. Add New Delivery Man ");
            System.out.println("2. Update Delivery Man Details ");
            System.out.print("\n   Enter a choice : ");
            MainMenuOption = sc.nextInt(); 
            
            if(MainMenuOption == 1) {
                do{
                    AddDeliveryMan();
                  
                    //System.out.println(deliveryManList.toString());
                    System.out.println("\nAny other operation need to do? Y=Yes N=No");
                    System.out.println("    Y = Direct to Add Menu\n    N = Direct to Main Menu");
                    System.out.print("\n Enter a choice : ");
                    cont = sc.next().charAt(0);
                    if(cont == 'N' || cont == 'n')
                        {
                            mainMenu();
                        }
                     }while(cont == 'Y' || cont == 'y');
                }
            else if(MainMenuOption == 2){
                
                do{
                UpdateDeliveryMan();
                System.out.print("Need to Update another Information <Y = Yes / N = No>: ");
                       cont = sc.next().charAt(0);
                       if(cont == 'N' || cont == 'n')
                        {
                            mainMenu();
                        }
                        
               }while(cont == 'y' || cont == 'Y');
            }
            
        }while(cont == 'Y' || cont == 'y');
    }
    
    public static void AddDeliveryMan() {
        
        
        
        System.out.print("Enter New Delivery Man details\n");
        System.out.print("------------------------------\n");
        System.out.print("User Name : ");
        String deliveryManName = sc.nextLine();
        deliveryManName = sc.nextLine();
        
        while (deliveryMan.validateDeliveryManName(deliveryManName) == false){//make sure the user is not eneter the digit
                      System.out.print(" >>> Invalid name ! Re-enter name : ");
                      deliveryManName = sc.nextLine();
        }
        
        
        deliveryMan.setDeliveryManName(deliveryManName);
        
        System.out.print("IC number [eg: xxxxxx-xx-xxxx] : "); 
        String deliveryManIC = sc.nextLine();
        
        while(deliveryMan.validateDeliveryManIC(deliveryManIC) == false){
            System.out.print(" >>> Invalid IC number ! Re-enter IC number : ");
            deliveryManIC = sc.nextLine();
        }
        deliveryMan.setDeliveryManIC(deliveryManIC);
   
        
        System.out.print("Enter Password [Must more than 6 chracter include 1 uppercase 1 lowercase and 1 digit]:");
        String deliverManPassword = sc.nextLine();
        while(deliveryMan.validateDeliveryManPassword(deliverManPassword) == false) {
            System.out.print(" >>> Invalid Password Format ! Re-enter Password Format : ");
            deliverManPassword = sc.nextLine();
        }
        
        
        System.out.print("Enter Home Address :");
        String deliverManAddress = sc.nextLine();
        /**while(deliveryMan.validateDeliveryManAddress(deliverManAddress) == false){
            System.out.print(" >>> Invalid Address ! Re-enter Address : ");
            deliverManAddress = sc.nextLine();
        }**/
        
        System.out.print("Enter Phone No [e.g.XXX-XXXXXXX]:");
        String deliverManPhoneNo = sc.nextLine();
        
        while(deliveryMan.validateDeliveryManPhoneNo(deliverManPhoneNo) == false) {
            System.out.print(" >>> Invalid Phone No Format ! Re-enter Phone No : ");
            deliverManPhoneNo = sc.nextLine();
        }
        
        
        System.out.print("Enter Emergency Contact Phone No [e.g.XXX-XXXXXXX]:");
        String deliverManEmergencyContact = sc.nextLine();
        
        while(deliveryMan.validateDeliveryManPhoneNo(deliverManEmergencyContact) == false) {
            System.out.print(" >>> Invalid Phone No Format ! Re-enter Phone No : ");
            deliverManEmergencyContact = sc.nextLine();
        }
        
        
        System.out.print("Enter Working Area :");
        String deliverManWorkArea = sc.nextLine();
        
        
        String deliverManPersonalStatus = "Work";
        //address
        //Phone No
        if(deliveryManList.isEmpty() == true) {//If  list empty add list
            deliveryManList.add(new DeliveryMan(deliveryManName,deliveryManIC,deliverManPassword,deliverManAddress,deliverManPhoneNo,deliverManEmergencyContact,deliverManWorkArea,deliverManPersonalStatus));
            System.out.println("\n\n@@@@@@@@@@@@@@@@@@ Successful Add the Delivery Man @@@@@@@@@@@@@@@@\n"+"DeliveryMan Name: " + deliveryManName+"\n"+ "DeliveryMan IC No: " +deliveryManIC+"\n"+"DeliveryMan Address: "+deliverManAddress+"\n"+"DeliveryMan Phone No: "+deliverManPhoneNo+"\n"+"DeliveryMan emergency contact:"+deliverManEmergencyContact+"\n"+"DeliveryMan Working Area:"+deliverManWorkArea+"\n"+"DeliveryMan Status:"+deliverManPersonalStatus+"\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\n");
        }
        else{
           //System.out.println("\n\n\nSuccessful Add the Delivery Man\n"+"DeliveryMan Name: " + deliveryManName+"\n"+ "DeliveryMan IC No: " +deliveryManIC+"\n"+"DeliveryMan Address: "+deliverManAddress+"\n"+"DeliveryMan Phone No: "+deliverManPhoneNo+"\n"+"DeliveryMan emergency contact:"+deliverManEmergencyContact+"\n"+"DeliveryMan Working Area:"+deliverManWorkArea);
           /**for(int i = 0 ;  i < deliveryManList.getLength() ; i ++)
           {
               if(deliveryManList.getEntry(i).getDeliveryManName().equals(deliveryManName) == true)
               {
                   System.out.println("\n----- Duplicated Delivery Man ! ----- \n");
                   AddDeliveryMan();
               }
               if(deliveryManList.getEntry(i).getDeliveryManIC().equals(deliveryManIC) == true)
               {
                    
                    System.out.println("\n----- Duplicated IC Number ! ----- \n");
                    AddDeliveryMan();
               }                
           
           }**/
          deliveryManList.add(new DeliveryMan(deliveryManName,deliveryManIC,deliverManPassword,deliverManAddress,deliverManPhoneNo,deliverManEmergencyContact,deliverManWorkArea,deliverManPersonalStatus));
          System.out.println("\n\n@@@@@@@@@@@@@@@@@@ Successful Add the Delivery Man @@@@@@@@@@@@@@@@\n"+"DeliveryMan Name: " + deliveryManName+"\n"+ "DeliveryMan IC No: " +deliveryManIC+"\n"+"DeliveryMan Address: "+deliverManAddress+"\n"+"DeliveryMan Phone No: "+deliverManPhoneNo+"\n"+"DeliveryMan emergency contact:"+deliverManEmergencyContact+"\n"+"DeliveryMan Working Area:"+deliverManWorkArea+"\n"+"DeliveryMan Status:"+deliverManPersonalStatus+"\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\n");
            
        }
        
        
          
 }
    
    public static void UpdateDeliveryMan() {
        //add = if the list is empty then goback main 
       
       int count  = 0; 
      // String deliveryManTempName = null;
       
       //for display the list of delivery man
        System.out.print("\n\n");  
        System.out.print("------- Delivery Man List -------\n");
       for(int a=1; a<=deliveryManList.getLength(); a++){
            System.out.print( ++count +" - "+ deliveryManList.getEntry(a).getDeliveryManName()+"\n");    
       }
       
       System.out.print("Key-in the delivery man name you  want to update: ");
       String selectedDeliveryman = sc.nextLine();
       selectedDeliveryman = sc.nextLine();
       
       
      /** for(int a=1; a<=deliveryManList.getLength(); a++){
           if(selectedDeliveryman.equals(deliveryManList.getEntry(a).getDeliveryManName().trim()))   {
               deliveryManTempName  = deliveryManList.getEntry(a).getDeliveryManName();
           }
       }**/ 
      boolean check = false;
      int index = 0;
        for(int i=1; i<=deliveryManList.getLength(); i++) {
          // if(selectedDeliveryman.equals(deliveryManList.getEntry(i).getDeliveryManName())){
          if(deliveryManList.getEntry(i).getDeliveryManName().equals(selectedDeliveryman)){//cannot loop second time
             check = true;
             index=i;
             break;
          }
        }
        if(check == true){
              System.out.printf("\n\t----- Update " + selectedDeliveryman.toUpperCase()+ " Info -----\n");

                System.out.println("Choose a user field to update : ");
                System.out.println("1. User Name");
                System.out.println("2. Password");
                System.out.println("3. Home Address");
                System.out.println("4. Phone No");
                System.out.println("5. Emergency Contacte No");
                System.out.println("6. Working Area");
                System.out.println("7. Personal Status:");
                System.out.print("\n Enter the field that you want to update : ");
                int field = sc.nextInt();
                do{
                if(field == 1) {
                    System.out.print("Enter Your New User Name : ");
                        String deliveryManNewName = sc.nextLine();
                        deliveryManNewName = sc.nextLine();
                        while (deliveryMan.validateDeliveryManName(deliveryManNewName) == false)
                        {
                            System.out.print(" >>> Invalid name format ! Re-enter name : ");
                            deliveryManNewName = sc.nextLine();
                        }
                        
     
                        deliveryManList.getEntry(index).setDeliveryManName(deliveryManNewName);
                        
                         System.out.printf("\n%-20s\n","Success Updated Personal Info");
                        System.out.printf("%-20s\n", "-----------------------------");
                       System.out.printf("User Name:               " + deliveryManList.getEntry(index).getDeliveryManName().toString()+ "\n"
                                          +"Password:                "+deliveryManList.getEntry(index).getDeliveryManPassword()+"\n"
                                          +"Home Address:            "+deliveryManList.getEntry(index).getDeliveryManAddress() +"\n"
                                          +"Phone No:                "+deliveryManList.getEntry(index).getDeliveryManPhoneNo()+"\n"
                                          +"Emergency Contacte No:   "+deliveryManList.getEntry(index).getDeliveryManEmergencyContact()+"\n"
                                          +"Working Area:            "+deliveryManList.getEntry(index).getDeliveryManWorkArea()+"\n"
                                          +"Status:                  " + deliveryManList.getEntry(index).getDeliveryManPersonalStatus()+"\n");
                        
                        /**System.out.print("Need to Update another fuction <y = Yes / n = No>: ");
                        String continueOption = sc.nextLine();
                        if(continueOption.trim() == "Y" || continueOption.trim() == "y"){
                            UpdateDeliveryMan();
                        }**/
                        
                        
                }else if(field == 2) {
                    
                    System.out.print("Enter Your New Password [Must more than 6 chracter include 1 uppercase 1 lowercase and 1 digit]");
                    String deliveryManNewPassword = sc.nextLine();
                    deliveryManNewPassword = sc.nextLine();
                    while(deliveryMan.validateDeliveryManPassword(deliveryManNewPassword)== false){
                        System.out.print(" >>> Invalid Password Format ! Re-enter Password Format : ");
                         deliveryManNewPassword = sc.nextLine();
                    }
                    deliveryManList.getEntry(index).setDeliveryManPassword(deliveryManNewPassword);
                     System.out.printf("\n%-20s\n","Success Updated Personal Info");
                        System.out.printf("%-20s\n", "-----------------------------");
                     System.out.printf("User Name:               " + deliveryManList.getEntry(index).getDeliveryManName().toString()+ "\n"
                                          +"Password:                "+deliveryManList.getEntry(index).getDeliveryManPassword()+"\n"
                                          +"Home Address:            "+deliveryManList.getEntry(index).getDeliveryManAddress() +"\n"
                                          +"Phone No:                "+deliveryManList.getEntry(index).getDeliveryManPhoneNo()+"\n"
                                          +"Emergency Contacte No:   "+deliveryManList.getEntry(index).getDeliveryManEmergencyContact()+"\n"
                                          +"Working Area:            "+deliveryManList.getEntry(index).getDeliveryManWorkArea()+"\n"
                                          +"Status:                  " + deliveryManList.getEntry(index).getDeliveryManPersonalStatus()+"\n");
                }else if(field == 3){
                    
                     System.out.print("Enter Your New Home Address :");
                     String deliverManNewAddress = sc.nextLine();
                     deliverManNewAddress = sc.nextLine();
                     deliveryManList.getEntry(index).setDeliveryManAddress(deliverManNewAddress);
                     
                     System.out.printf("\n%-20s\n","Success Updated Personal Info");
                        System.out.printf("%-20s\n", "-----------------------------");
               System.out.printf("User Name:               " + deliveryManList.getEntry(index).getDeliveryManName().toString()+ "\n"
                                          +"Password:                "+deliveryManList.getEntry(index).getDeliveryManPassword()+"\n"
                                          +"Home Address:            "+deliveryManList.getEntry(index).getDeliveryManAddress() +"\n"
                                          +"Phone No:                "+deliveryManList.getEntry(index).getDeliveryManPhoneNo()+"\n"
                                          +"Emergency Contacte No:   "+deliveryManList.getEntry(index).getDeliveryManEmergencyContact()+"\n"
                                          +"Working Area:            "+deliveryManList.getEntry(index).getDeliveryManWorkArea()+"\n"
                                          +"Status:                  " + deliveryManList.getEntry(index).getDeliveryManPersonalStatus()+"\n");
                     break;
                     
                }else if(field == 4){
                    System.out.print("Enter Your New Phone No [e.g.XXX-XXXXXXX]:");
                    String deliverManNewPhoneNo = sc.nextLine();
                    deliverManNewPhoneNo = sc.nextLine();
        
                    while(deliveryMan.validateDeliveryManPhoneNo(deliverManNewPhoneNo) == false) {
                      System.out.print(" >>> Invalid Phone No Format ! Re-enter Phone No : ");
                      deliverManNewPhoneNo = sc.nextLine();
                     }
                    deliveryManList.getEntry(index).setDeliveryManPhoneNo(deliverManNewPhoneNo);
                    
                    System.out.printf("\n%-20s\n","Success Updated Personal Info");
                        System.out.printf("%-20s\n", "-----------------------------");
                   System.out.printf("User Name:               " + deliveryManList.getEntry(index).getDeliveryManName().toString()+ "\n"
                                          +"Password:                "+deliveryManList.getEntry(index).getDeliveryManPassword()+"\n"
                                          +"Home Address:            "+deliveryManList.getEntry(index).getDeliveryManAddress() +"\n"
                                          +"Phone No:                "+deliveryManList.getEntry(index).getDeliveryManPhoneNo()+"\n"
                                          +"Emergency Contacte No:   "+deliveryManList.getEntry(index).getDeliveryManEmergencyContact()+"\n"
                                          +"Working Area:            "+deliveryManList.getEntry(index).getDeliveryManWorkArea()+"\n"
                                          +"Status:                  " + deliveryManList.getEntry(index).getDeliveryManPersonalStatus()+"\n");
                    break;
                }else if(field == 5){
                    System.out.print("Enter Your New Emergency Contact Phone No [e.g.XXX-XXXXXXX]:");
                        String deliverManEmergencyContact = sc.nextLine();
                        deliverManEmergencyContact = sc.nextLine();
        
                    while(deliveryMan.validateDeliveryManPhoneNo(deliverManEmergencyContact) == false) {
                      System.out.print(" >>> Invalid Phone No Format ! Re-enter Phone No : ");
                     deliverManEmergencyContact = sc.nextLine();
                    }
                     deliveryManList.getEntry(index).setDeliveryManEmergencyContact(deliverManEmergencyContact);
                     
                     System.out.printf("\n%-20s\n","Success Updated Personal Info");
                        System.out.printf("%-20s\n", "-----------------------------");;
                   System.out.printf("User Name:               " + deliveryManList.getEntry(index).getDeliveryManName().toString()+ "\n"
                                          +"Password:                "+deliveryManList.getEntry(index).getDeliveryManPassword()+"\n"
                                          +"Home Address:            "+deliveryManList.getEntry(index).getDeliveryManAddress() +"\n"
                                          +"Phone No:                "+deliveryManList.getEntry(index).getDeliveryManPhoneNo()+"\n"
                                          +"Emergency Contacte No:   "+deliveryManList.getEntry(index).getDeliveryManEmergencyContact()+"\n"
                                          +"Working Area:            "+deliveryManList.getEntry(index).getDeliveryManWorkArea()+"\n"
                                          +"Status:                  " + deliveryManList.getEntry(index).getDeliveryManPersonalStatus()+"\n");
                      
                      break;
                }else if(field == 6){
                     System.out.print("Enter Your New Working Area :");
                     String deliverManWorkArea = sc.nextLine();
                     deliverManWorkArea = sc.nextLine();
                     deliveryManList.getEntry(index).setDeliveryManWorkArea(deliverManWorkArea);
                     System.out.printf("\n%-20s\n","Success Updated Personal Info");
                        System.out.printf("%-20s\n", "-----------------------------");
                    System.out.printf("User Name:               " + deliveryManList.getEntry(index).getDeliveryManName().toString()+ "\n"
                                          +"Password:                "+deliveryManList.getEntry(index).getDeliveryManPassword()+"\n"
                                          +"Home Address:            "+deliveryManList.getEntry(index).getDeliveryManAddress() +"\n"
                                          +"Phone No:                "+deliveryManList.getEntry(index).getDeliveryManPhoneNo()+"\n"
                                          +"Emergency Contacte No:   "+deliveryManList.getEntry(index).getDeliveryManEmergencyContact()+"\n"
                                          +"Working Area:            "+deliveryManList.getEntry(index).getDeliveryManWorkArea()+"\n"
                                          +"Status:                  " + deliveryManList.getEntry(index).getDeliveryManPersonalStatus()+"\n");
                      break;
                }else if(field == 7){
                    System.out.print("Enter Your New Personal Status[only can enter Retired or Resigned]:");
                    String deliverManPersonalStatus = sc.nextLine();
                     deliverManPersonalStatus = sc.nextLine();
                     while(deliveryMan.validateDeliveryPersonalStatus(deliverManPersonalStatus) == false) {
                      System.out.print(" >>> Invalid Status - Please re-enter[Retired or Resigned]: ");
                     deliverManPersonalStatus = sc.nextLine();
                    }
                     System.out.printf("\n%-20s\n","Success Updated Personal Info");
                        System.out.printf("%-20s\n", "-----------------------------");
                     deliveryManList.getEntry(index).setDeliveryManPersonalStatus(deliverManPersonalStatus);
                     System.out.printf("User Name:               " + deliveryManList.getEntry(index).getDeliveryManName().toString()+ "\n"
                                          +"Password:                "+deliveryManList.getEntry(index).getDeliveryManPassword()+"\n"
                                          +"Home Address:            "+deliveryManList.getEntry(index).getDeliveryManAddress() +"\n"
                                          +"Phone No:                "+deliveryManList.getEntry(index).getDeliveryManPhoneNo()+"\n"
                                          +"Emergency Contacte No:   "+deliveryManList.getEntry(index).getDeliveryManEmergencyContact()+"\n"
                                          +"Working Area:            "+deliveryManList.getEntry(index).getDeliveryManWorkArea()+"\n"
                                          +"Status:                  " + deliveryManList.getEntry(index).getDeliveryManPersonalStatus()+"\n");
                     break;
                }

                
               }while(!(field >=1 && field <=7));
               
        }
               
        
          else{
               System.out.print("\n\n----------------------Invalid delivery man NAME[Try Again]!!--------------------------\n\n");
               mainMenu();
          }
    }
    }

