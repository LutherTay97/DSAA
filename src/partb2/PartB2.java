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
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class PartB2 {

    /**
     * @param args the command line arguments
     */
    
    private static List<DeliveryMan> arrayList = new ArrayList<>();
    private static DeliveryManInterface deliveryMan = new DeliveryMan();
    private static Scanner sc = new Scanner (System.in);
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<DeliveryMan> personList = new ArrayList<DeliveryMan>();
        System.out.println("\t\t____________________________________"); 
        System.out.println("\t\t|                                    |");
        System.out.println("\t\t|    Maintain Delivery man module    |");
        System.out.println("\t\t|____________________________________|\n\n");
        mainMenu(); //call main menu 
    }
    public static void mainMenu() {
        int MainMenuOption ;
        char cont = 'Y';
        do{
            System.out.println("\n << Maintain Delivery Man Module >>");
            System.out.println("1. Add New Delivery Man ");
            System.out.println("2. Update Delivery Man Details ");
            System.out.print("\n   Enter a choice : ");
            MainMenuOption = sc.nextInt();
            
            if(MainMenuOption == 1) {
                do{
                    /**System.out.print("Enter New DeliveryMan Details\n");
                    System.out.print("Enter New DeliveryMan Name:");
                    String DeliveryManName = sc.next();
                    
                    System.out.print("\nEnter New DeliveryMan Ic No:");
                    String DeliveryManIC = sc.nextLine();
                    
                    System.out.print("\nEnter New DeliveryMan Password:");
                    String DeliveryManPassword = sc.nextLine();
                    
                    System.out.print("\nEnter New DeliveryMan Address:");
                    String DeliveryManAddress = sc.nextLine();
                    
                    System.out.print("\nEnter  New DeliveryMan Phone No:");
                    String DeliveryManPhonNo = sc.nextLine();
                    
                    
                    arrayList.add(DeliveryManName);
                    arrayList.add(DeliveryManIC);
                    arrayList.add(DeliveryManPassword);
                    arrayList.add(DeliveryManAddress);
                    arrayList.add(DeliveryManPhonNo);
                    
                    
                        System.out.print("New Delivery Man Name:"+arrayList.get(0));
                        System.out.print("\nNew Delivery Man IC:"+arrayList.get(1));
                        System.out.print("\nNew Delivery Man Password:"+arrayList.get(2));
                        System.out.print("\nNew Delivery Man Address:"+arrayList.get(3));
                        System.out.print("\nNew Delivery Phone No:"+arrayList.get(4));**/
                   
                  
                    //System.out.println(deliveryManList.toString());
                    AddDeliveryMan();
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
            else if(MainMenuOption == 3){
                //assign
            }
        }while(cont == 'Y' || cont == 'y');
    }
    
    
     public static void AddDeliveryMan() {
        System.out.print("Enter New Delivery Man details\n");
        System.out.print("User Name : ");
        
        String deliveryManName = sc.nextLine();
        deliveryManName = sc.nextLine();
        
        while (deliveryMan.validateDeliveryManName(deliveryManName) == false){//make sure the user is not eneter the digit
                      System.out.print(" >>> Invalid name ! Re-enter name : ");
                      deliveryManName = sc.nextLine();
        }
        //deliveryMan.setDeliveryManName(deliveryManName);
        
        System.out.print("IC number [eg: xxxxxx-xx-xxxx] : "); 
        String deliveryManIC = sc.nextLine();
        
        while(deliveryMan.validateDeliveryManIC(deliveryManIC) == false){
            System.out.print(" >>> Invalid IC number ! Re-enter IC number : ");
            deliveryManIC = sc.nextLine();
        }
        //deliveryMan.setDeliveryManIC(deliveryManName);
        
        System.out.print("Enter Password [Must more than 6 chracter include 1 uppercase 1 lowercase and 1 digit]:");
        String deliverManPassword = sc.nextLine();
        
        while(deliveryMan.validateDeliveryManPassword(deliverManPassword) == false) {
            System.out.print(" >>> Invalid Password Format ! Re-enter Password Format : ");
            deliverManPassword = sc.nextLine();
        }
        //[level -> ? - ? <- no. eg:25-11]
        System.out.print("Enter Your Address : :");
        String deliverManAddress = sc.nextLine();
        
        /**while(deliveryMan.validateDeliveryManAddress(deliverManAddress) == false){
            System.out.print(" >>> Invalid Address ! Re-enter Address : ");
            deliverManAddress = sc.nextLine();
        }**/
        
        System.out.print("Enter Your Phone No [e.g.XXX-XXXXXXX]:");
        String deliverManPhoneNo = sc.nextLine();
        
        while(deliveryMan.validateDeliveryManPhoneNo(deliverManPhoneNo) == false) {
            System.out.print(" >>> Invalid Phone No Format ! Re-enter Phone No : ");
            deliverManPhoneNo = sc.nextLine();
        }
                    
                   arrayList.add(new DeliveryMan(deliveryManName,deliveryManIC,deliverManPassword,deliverManAddress,deliverManPhoneNo));
                   
                   /**for(int  i=0 ; i < arrayList.size();i++){
                       System.out.print(arrayList.get(i));
                   }**/
                    
                  System.out.println("\n\n\n@@@@@@@@@@@@@@@@@@  Successful Add the Delivery Man  @@@@@@@@@@@@@@@@\n"+"DeliveryMan Name: " + deliveryManName+"\n"+ "DeliveryMan IC No: " +deliveryManIC+"\n"+"DeliveryMan Address: "+deliverManAddress+"\n"+"DeliveryMan Phone No: "+deliverManPhoneNo + "\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
     }
     
}
