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
import java.util.ArrayList;
import java.util.List;
public class PartBAddDeliveryMan {

   
    private static List<String> arrayList = new ArrayList<>();
    private static Scanner sc = new Scanner (System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here 
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
                    System.out.print("Enter New DeliveryMan Details\n");
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
                        System.out.print("\nNew Delivery Phone No:"+arrayList.get(4));
                   
                  
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
            else if(MainMenuOption == 3){
                //assign
            }
        }while(cont == 'Y' || cont == 'y');
    }
}
