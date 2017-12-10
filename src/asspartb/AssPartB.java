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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//-----------------------------cannot use
import java.util.ArrayList;
import java.util.List;

public class AssPartB {

    /**
     * @param args the command line arguments
     */
    private static Scanner sc = new Scanner(System.in);
    private static DeliveryManInterface deliveryMan = new DeliveryMan();
    static StoredListkedList<DeliveryManInterface> deliveryManList = new StoredListkedList<DeliveryManInterface>();

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
    public static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    //----------------------------------------------------------------------------------------cannot use
    private static reportInterface deliveryManReport = new report();
    //private static List<String> arraylist   = new ArrayList<String>();
    private static List<report> arrayList = new ArrayList<>();
    public static report report1 = new report();

    public static void main(String[] args) {

        System.out.println("\t\t ____________________________________");
        System.out.println("\t\t|                                    |");
        System.out.println("\t\t|    Maintain Delivery man module    |");
        System.out.println("\t\t|____________________________________|\n");
        mainMenu(); //call main menu 

    }

    public static StoredListInterface<DeliveryManInterface> readDeliveryManFile() {
        StoredListInterface<DeliveryManInterface> deliveryManListReadFromFile = new StoredListkedList<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("deliveryMan.dat"));
            deliveryManListReadFromFile = (StoredListInterface) oiStream.readObject();
            oiStream.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot read from delivery man file", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return deliveryManListReadFromFile;
    }

    public static void writeDeliveryManFile(StoredListInterface<DeliveryManInterface> deliveryManList) {
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("deliveryMan.dat"));
            ooStream.writeObject(deliveryManList);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot save to file", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void mainMenu() {
        int MainMenuOption;
        char cont = 'Y';
        char zz = 'b';
        do {
            System.out.println("\n << Maintain Delivery Man Module >>");
            System.out.println("1. Add New Delivery Man ");
            System.out.println("2. Update Delivery Man Details ");
            System.out.println("3. View Report");
            System.out.println("4. Retrieve Pending Delivery Man");
            System.out.print("\n   Enter a choice : ");
            MainMenuOption = sc.nextInt();

            if (MainMenuOption == 1) {
                do {
                    AddDeliveryMan();

                    //System.out.println(deliveryManList.toString());
                    System.out.println("\nAny other operation need to do? Y=Yes N=No");
                    System.out.println("    Y = Direct to Add Menu\n    N = Direct to Main Menu");
                    System.out.print("\n Enter a choice : ");
                    cont = sc.next().charAt(0);
                    if (cont == 'N' || cont == 'n') {
                        mainMenu();
                    }
                } while (cont == 'Y' || cont == 'y');
            } else if (MainMenuOption == 2) {

                do {
                    UpdateDeliveryMan();
                    System.out.print("Need to Update another Information <Y = Yes / N = No>: ");
                    cont = sc.next().charAt(0);
                    if (cont == 'N' || cont == 'n') {
                        mainMenu();
                    }

                } while (cont == 'y' || cont == 'Y');
            } else if (MainMenuOption == 3) {
                do {
                    ViewReport();
                    System.out.print("Need to View another Report <Y = Yes / N = No>: ");
                    cont = sc.next().charAt(0);
                    if (cont == 'N' || cont == 'n') {
                        mainMenu();
                    }

                } while (cont == 'y' || cont == 'Y');
            } else if (MainMenuOption == 4) {
                do {

                    RetrievePendingDeliveryMan();
                    System.out.print("\nGo back to Main Page <Y = Yes>: ");
                    cont = sc.next().charAt(0);
                    if (cont == 'Y' || cont == 'y') {
                        mainMenu();
                    } else {
                        zz = 'a';
                        System.out.print("\n--------------------Invalid input re-enter again----------------------\n");
                    }

                } while (zz == 'a');
            }

        } while (cont == 'Y' || cont == 'y');
    }

    public static void AddDeliveryMan() {

        System.out.print("Enter New Delivery Man details\n");
        System.out.print("------------------------------\n");
        System.out.print("User Name : ");
        String deliveryManName = sc.nextLine();
        deliveryManName = sc.nextLine();

        while (deliveryMan.validateDeliveryManName(deliveryManName) == false) {//make sure the user is not eneter the digit
            System.out.print(" >>> Invalid name ! Re-enter name : ");
            deliveryManName = sc.nextLine();
        }

        deliveryMan.setDeliveryManName(deliveryManName);

        System.out.print("IC number [eg: xxxxxx-xx-xxxx] : ");
        String deliveryManIC = sc.nextLine();

        while (deliveryMan.validateDeliveryManIC(deliveryManIC) == false) {
            System.out.print(" >>> Invalid IC number ! Re-enter IC number : ");
            deliveryManIC = sc.nextLine();
        }
        deliveryMan.setDeliveryManIC(deliveryManIC);

        System.out.print("Enter Password [Must more than 6 chracter include 1 uppercase 1 lowercase and 1 digit]:");
        String deliverManPassword = sc.nextLine();
        while (deliveryMan.validateDeliveryManPassword(deliverManPassword) == false) {
            System.out.print(" >>> Invalid Password Format ! Re-enter Password Format : ");
            deliverManPassword = sc.nextLine();
        }

        System.out.print("Enter Home Address :");
        String deliverManAddress = sc.nextLine();
        /**
         * while(deliveryMan.validateDeliveryManAddress(deliverManAddress) ==
         * false){ System.out.print(" >>> Invalid Address ! Re-enter Address :
         * "); deliverManAddress = sc.nextLine();
        }*
         */

        System.out.print("Enter Phone No [e.g.XXX-XXXXXXX]:");
        String deliverManPhoneNo = sc.nextLine();

        while (deliveryMan.validateDeliveryManPhoneNo(deliverManPhoneNo) == false) {
            System.out.print(" >>> Invalid Phone No Format ! Re-enter Phone No : ");
            deliverManPhoneNo = sc.nextLine();
        }

        System.out.print("Enter Emergency Contact Phone No [e.g.XXX-XXXXXXX]:");
        String deliverManEmergencyContact = sc.nextLine();

        while (deliveryMan.validateDeliveryManPhoneNo(deliverManEmergencyContact) == false) {
            System.out.print(" >>> Invalid Phone No Format ! Re-enter Phone No : ");
            deliverManEmergencyContact = sc.nextLine();
        }

        System.out.print("Enter Working Area :");
        String deliverManWorkArea = sc.nextLine();

        String deliverManPersonalStatus = "Work";
        String deliverManStatus = "Pending";
        
        //Read the record from file
        StoredListInterface<DeliveryManInterface> deliveryManListReadFromFile = new StoredListkedList<>();
        deliveryManListReadFromFile = readDeliveryManFile();
        
        //find the highest ID
        int highest = Integer.parseInt(deliveryManListReadFromFile.getEntry(1).getDeliveryManId().substring(1, 5));

        for (int i = 1; i <= deliveryManListReadFromFile.getLength(); i++) {
            //System.out.println(deliveryManListReadFromFile.getEntry(i).getDeliveryManId()+"      "+deliveryManListReadFromFile.getEntry(i).getDeliveryManName());

            if (Integer.parseInt(deliveryManListReadFromFile.getEntry(i).getDeliveryManId().substring(1, 5)) > highest) {
                highest = Integer.parseInt(deliveryManListReadFromFile.getEntry(i).getDeliveryManId().substring(1, 5));
            }
        }

        if (deliveryManListReadFromFile.isEmpty() == true) {//If  list empty add list
            //----------------file write in------------------------
            DeliveryManInterface newDeliveryMan = new DeliveryMan(highest += 1, deliveryManName, deliveryManIC, deliverManPassword, deliverManAddress, deliverManPhoneNo, deliverManEmergencyContact, deliverManWorkArea, deliverManStatus, deliverManPersonalStatus);
            deliveryManListReadFromFile.add(newDeliveryMan);
            
            System.out.println("\n\n@@@@@@@@@@@@@@@@@@ Successful Add the Delivery Man @@@@@@@@@@@@@@@@\n" + "DeliveryMan Name: " + deliveryManName + "\n" + "DeliveryMan IC No: " + deliveryManIC + "\n" + "DeliveryMan Address: " + deliverManAddress + "\n" + "DeliveryMan Phone No: " + deliverManPhoneNo + "\n" + "DeliveryMan emergency contact:" + deliverManEmergencyContact + "\n" + "DeliveryMan Working Area:" + deliverManWorkArea + "\n" + "DeliveryMan Status:" + deliverManPersonalStatus + "\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\n");
            System.out.println(newDeliveryMan.getDeliveryManId());
            writeDeliveryManFile(deliveryManListReadFromFile);
        } else {
            //System.out.println("\n\n\nSuccessful Add the Delivery Man\n"+"DeliveryMan Name: " + deliveryManName+"\n"+ "DeliveryMan IC No: " +deliveryManIC+"\n"+"DeliveryMan Address: "+deliverManAddress+"\n"+"DeliveryMan Phone No: "+deliverManPhoneNo+"\n"+"DeliveryMan emergency contact:"+deliverManEmergencyContact+"\n"+"DeliveryMan Working Area:"+deliverManWorkArea);
            /**
             * for(int i = 0 ; i < deliveryManList.getLength() ; i ++) {
             * if(deliveryManList.getEntry(i).getDeliveryManName().equals(deliveryManName)
             * == true) { System.out.println("\n----- Duplicated Delivery Man !
             * ----- \n"); AddDeliveryMan(); }
             * if(deliveryManList.getEntry(i).getDeliveryManIC().equals(deliveryManIC)
             * == true) {
             *
             * System.out.println("\n----- Duplicated IC Number ! ----- \n");
             * AddDeliveryMan(); }              *
             * }*
             */
            //FILE------------------------------------------------------------------------------------
            DeliveryManInterface newDeliveryMan = new DeliveryMan(highest += 1, deliveryManName, deliveryManIC, deliverManPassword, deliverManAddress, deliverManPhoneNo, deliverManEmergencyContact, deliverManWorkArea, deliverManStatus, deliverManPersonalStatus);
            deliveryManListReadFromFile.add(newDeliveryMan);
            System.out.println("\n\n@@@@@@@@@@@@@@@@@@ Successful Add the Delivery Man @@@@@@@@@@@@@@@@\n" + "DeliveryMan Name: " + deliveryManName + "\n" + "DeliveryMan IC No: " + deliveryManIC + "\n" + "DeliveryMan Address: " + deliverManAddress + "\n" + "DeliveryMan Phone No: " + deliverManPhoneNo + "\n" + "DeliveryMan emergency contact:" + deliverManEmergencyContact + "\n" + "DeliveryMan Working Area:" + deliverManWorkArea + "\n" + "DeliveryMan Status:" + deliverManPersonalStatus + "\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\n");
            System.out.println(newDeliveryMan.getDeliveryManId());
            writeDeliveryManFile(deliveryManListReadFromFile);
        }

    }

    public static void UpdateDeliveryMan() {
        //add = if the list is empty then goback main 

        int count = 0;
        // String deliveryManTempName = null;
        
        
        StoredListInterface<DeliveryManInterface> deliveryManListReadFromFile = new StoredListkedList<>();
        deliveryManListReadFromFile = readDeliveryManFile();
        
        //for display the list of delivery man
        System.out.print("\n\n");
        System.out.print("------- Delivery Man List -------\n");
        for (int a = 1; a <= deliveryManListReadFromFile.getLength(); a++) {
            System.out.print(++count + " - " + deliveryManListReadFromFile.getEntry(a).getDeliveryManName() + "\n");
        }

        System.out.print("Key-in the delivery man name you  want to update: ");
        String selectedDeliveryman = sc.nextLine();
        selectedDeliveryman = sc.nextLine();

        /**
         * for(int a=1; a<=deliveryManList.getLength(); a++){
         * if(selectedDeliveryman.equals(deliveryManList.getEntry(a).getDeliveryManName().trim()))
         * { deliveryManTempName =
         * deliveryManList.getEntry(a).getDeliveryManName(); }
       }*
         */
        boolean check = false;
        int index = 0;
        for (int i = 1; i <= deliveryManListReadFromFile.getLength(); i++) {
            // if(selectedDeliveryman.equals(deliveryManList.getEntry(i).getDeliveryManName())){
            if (deliveryManListReadFromFile.getEntry(i).getDeliveryManName().equals(selectedDeliveryman)) {//cannot loop second time
                check = true;
                index = i;
                break;
            }
        }
        if (check == true) {
            System.out.printf("\n\t----- Update " + selectedDeliveryman.toUpperCase() + " Info -----\n");

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
            do {
                if (field == 1) {

                    System.out.print("Enter Your New User Name : ");
                    String deliveryManNewName = sc.nextLine();
                    deliveryManNewName = sc.nextLine();
                    while (deliveryMan.validateDeliveryManName(deliveryManNewName) == false) {
                        System.out.print(" >>> Invalid name format ! Re-enter name : ");
                        deliveryManNewName = sc.nextLine();
                    }

                    //-----------------------------------------------------------------------------------------------
                    //StoredListInterface<DeliveryManInterface> deliveryManListReadFromFile = new StoredListkedList<>();
                    //deliveryManListReadFromFile = readDeliveryManFile();
                    
                    //----------------write file-------------------------
                    deliveryManListReadFromFile.getEntry(index).setDeliveryManName(deliveryManNewName);
                    writeDeliveryManFile(deliveryManListReadFromFile);
                    
                    System.out.printf("\n%-20s\n", "Success Updated Personal Info");
                    System.out.printf("%-20s\n", "-----------------------------");
                    System.out.printf("User Name:               " + deliveryManListReadFromFile.getEntry(index).getDeliveryManName().toString() + "\n"
                            + "Password:                " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPassword() + "\n"
                            + "Home Address:            " + deliveryManListReadFromFile.getEntry(index).getDeliveryManAddress() + "\n"
                            + "Phone No:                " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPhoneNo() + "\n"
                            + "Emergency Contacte No:   " + deliveryManListReadFromFile.getEntry(index).getDeliveryManEmergencyContact() + "\n"
                            + "Working Area:            " + deliveryManListReadFromFile.getEntry(index).getDeliveryManWorkArea() + "\n"
                            + "Status:                  " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPersonalStatus() + "\n");

                    /**
                     * System.out.print("Need to Update another fuction
                     * <y = Yes / n = No>: "); String continueOption =
                     * sc.nextLine(); if(continueOption.trim() == "Y" ||
                     * continueOption.trim() == "y"){ UpdateDeliveryMan();
                        }*
                     */
                } else if (field == 2) {

                    System.out.print("Enter Your New Password [Must more than 6 chracter include 1 uppercase 1 lowercase and 1 digit]");
                    String deliveryManNewPassword = sc.nextLine();
                    deliveryManNewPassword = sc.nextLine();
                    while (deliveryMan.validateDeliveryManPassword(deliveryManNewPassword) == false) {
                        System.out.print(" >>> Invalid Password Format ! Re-enter Password Format : ");
                        deliveryManNewPassword = sc.nextLine();
                    }
                    //wtite in file-----------------------------------------------------------------------
                    deliveryManListReadFromFile.getEntry(index).setDeliveryManPassword(deliveryManNewPassword);
                    writeDeliveryManFile(deliveryManListReadFromFile);
                    
                    System.out.printf("\n%-20s\n", "Success Updated Personal Info");
                    System.out.printf("%-20s\n", "-----------------------------");
                     System.out.printf("User Name:               " + deliveryManListReadFromFile.getEntry(index).getDeliveryManName().toString() + "\n"
                            + "Password:                " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPassword() + "\n"
                            + "Home Address:            " + deliveryManListReadFromFile.getEntry(index).getDeliveryManAddress() + "\n"
                            + "Phone No:                " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPhoneNo() + "\n"
                            + "Emergency Contacte No:   " + deliveryManListReadFromFile.getEntry(index).getDeliveryManEmergencyContact() + "\n"
                            + "Working Area:            " + deliveryManListReadFromFile.getEntry(index).getDeliveryManWorkArea() + "\n"
                            + "Status:                  " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPersonalStatus() + "\n");
                } else if (field == 3) {

                    System.out.print("Enter Your New Home Address :");
                    String deliverManNewAddress = sc.nextLine();
                    deliverManNewAddress = sc.nextLine();
                    
                    //wtite in file-----------------------------------------------------------------------
                    deliveryManListReadFromFile.getEntry(index).setDeliveryManAddress(deliverManNewAddress);
                    writeDeliveryManFile(deliveryManListReadFromFile);

                    System.out.printf("\n%-20s\n", "Success Updated Personal Info");
                    System.out.printf("%-20s\n", "-----------------------------");
                    System.out.printf("User Name:               " + deliveryManListReadFromFile.getEntry(index).getDeliveryManName().toString() + "\n"
                            + "Password:                " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPassword() + "\n"
                            + "Home Address:            " + deliveryManListReadFromFile.getEntry(index).getDeliveryManAddress() + "\n"
                            + "Phone No:                " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPhoneNo() + "\n"
                            + "Emergency Contacte No:   " + deliveryManListReadFromFile.getEntry(index).getDeliveryManEmergencyContact() + "\n"
                            + "Working Area:            " + deliveryManListReadFromFile.getEntry(index).getDeliveryManWorkArea() + "\n"
                            + "Status:                  " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPersonalStatus() + "\n");
                    break;

                } else if (field == 4) {
                    System.out.print("Enter Your New Phone No [e.g.XXX-XXXXXXX]:");
                    String deliverManNewPhoneNo = sc.nextLine();
                    deliverManNewPhoneNo = sc.nextLine();

                    while (deliveryMan.validateDeliveryManPhoneNo(deliverManNewPhoneNo) == false) {
                        System.out.print(" >>> Invalid Phone No Format ! Re-enter Phone No : ");
                        deliverManNewPhoneNo = sc.nextLine();
                    }
                    //wtite in file-----------------------------------------------------------------------
                    deliveryManListReadFromFile.getEntry(index).setDeliveryManPhoneNo(deliverManNewPhoneNo);
                    writeDeliveryManFile(deliveryManListReadFromFile);

                    System.out.printf("\n%-20s\n", "Success Updated Personal Info");
                    System.out.printf("%-20s\n", "-----------------------------");
                    System.out.printf("User Name:               " + deliveryManListReadFromFile.getEntry(index).getDeliveryManName().toString() + "\n"
                            + "Password:                " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPassword() + "\n"
                            + "Home Address:            " + deliveryManListReadFromFile.getEntry(index).getDeliveryManAddress() + "\n"
                            + "Phone No:                " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPhoneNo() + "\n"
                            + "Emergency Contacte No:   " + deliveryManListReadFromFile.getEntry(index).getDeliveryManEmergencyContact() + "\n"
                            + "Working Area:            " + deliveryManListReadFromFile.getEntry(index).getDeliveryManWorkArea() + "\n"
                            + "Status:                  " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPersonalStatus() + "\n");
                    break;
                } else if (field == 5) {
                    System.out.print("Enter Your New Emergency Contact Phone No [e.g.XXX-XXXXXXX]:");
                    String deliverManEmergencyContact = sc.nextLine();
                    deliverManEmergencyContact = sc.nextLine();

                    while (deliveryMan.validateDeliveryManPhoneNo(deliverManEmergencyContact) == false) {
                        System.out.print(" >>> Invalid Phone No Format ! Re-enter Phone No : ");
                        deliverManEmergencyContact = sc.nextLine();
                    }
                    //wtite in file-----------------------------------------------------------------------
                    deliveryManListReadFromFile.getEntry(index).setDeliveryManEmergencyContact(deliverManEmergencyContact);
                    writeDeliveryManFile(deliveryManListReadFromFile);

                    System.out.printf("\n%-20s\n", "Success Updated Personal Info");
                    System.out.printf("%-20s\n", "-----------------------------");;
                     System.out.printf("User Name:               " + deliveryManListReadFromFile.getEntry(index).getDeliveryManName().toString() + "\n"
                            + "Password:                " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPassword() + "\n"
                            + "Home Address:            " + deliveryManListReadFromFile.getEntry(index).getDeliveryManAddress() + "\n"
                            + "Phone No:                " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPhoneNo() + "\n"
                            + "Emergency Contacte No:   " + deliveryManListReadFromFile.getEntry(index).getDeliveryManEmergencyContact() + "\n"
                            + "Working Area:            " + deliveryManListReadFromFile.getEntry(index).getDeliveryManWorkArea() + "\n"
                            + "Status:                  " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPersonalStatus() + "\n");

                    break;
                } else if (field == 6) {
                    System.out.print("Enter Your New Working Area :");
                    String deliverManWorkArea = sc.nextLine();
                    deliverManWorkArea = sc.nextLine();
                    
                    
                    //wtite in file-----------------------------------------------------------------------
                    deliveryManListReadFromFile.getEntry(index).setDeliveryManWorkArea(deliverManWorkArea);
                    writeDeliveryManFile(deliveryManListReadFromFile);
                    
                    
                    System.out.printf("\n%-20s\n", "Success Updated Personal Info");
                    System.out.printf("%-20s\n", "-----------------------------");
                     System.out.printf("User Name:               " + deliveryManListReadFromFile.getEntry(index).getDeliveryManName().toString() + "\n"
                            + "Password:                " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPassword() + "\n"
                            + "Home Address:            " + deliveryManListReadFromFile.getEntry(index).getDeliveryManAddress() + "\n"
                            + "Phone No:                " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPhoneNo() + "\n"
                            + "Emergency Contacte No:   " + deliveryManListReadFromFile.getEntry(index).getDeliveryManEmergencyContact() + "\n"
                            + "Working Area:            " + deliveryManListReadFromFile.getEntry(index).getDeliveryManWorkArea() + "\n"
                            + "Status:                  " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPersonalStatus() + "\n");
                    break;
                } else if (field == 7) {
                    System.out.print("Enter Your New Personal Status[only can enter Retired or Resigned]:");
                    String deliverManPersonalStatus = sc.nextLine();
                    deliverManPersonalStatus = sc.nextLine();
                    while (deliveryMan.validateDeliveryPersonalStatus(deliverManPersonalStatus) == false) {
                        System.out.print(" >>> Invalid Status - Please re-enter[Retired or Resigned]: ");
                        deliverManPersonalStatus = sc.nextLine();
                    }
                    System.out.printf("\n%-20s\n", "Success Updated Personal Info");
                    System.out.printf("%-20s\n", "-----------------------------");
                    
                    
                    //wtite in file-----------------------------------------------------------------------
                    deliveryManListReadFromFile.getEntry(index).setDeliveryManPersonalStatus(deliverManPersonalStatus);
                    writeDeliveryManFile(deliveryManListReadFromFile);
                    
              System.out.printf("User Name:               " + deliveryManListReadFromFile.getEntry(index).getDeliveryManName().toString() + "\n"
                            + "Password:                " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPassword() + "\n"
                            + "Home Address:            " + deliveryManListReadFromFile.getEntry(index).getDeliveryManAddress() + "\n"
                            + "Phone No:                " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPhoneNo() + "\n"
                            + "Emergency Contacte No:   " + deliveryManListReadFromFile.getEntry(index).getDeliveryManEmergencyContact() + "\n"
                            + "Working Area:            " + deliveryManListReadFromFile.getEntry(index).getDeliveryManWorkArea() + "\n"
                            + "Status:                  " + deliveryManListReadFromFile.getEntry(index).getDeliveryManPersonalStatus() + "\n");
                    break;
                }

            } while (!(field >= 1 && field <= 7));

        } else {
            System.out.print("\n\n----------------------Invalid delivery man NAME[Try Again]!!--------------------------\n\n");
            mainMenu();
        }
    }

    public static void ViewReport() {
        Calendar c = Calendar.getInstance();
        arrayList.add(new report("1000", " Hey Hong Sheng ", "5", "\f25Km"));
        arrayList.add(new report("1001", "Chin Zi Kang  ", "10", " 50KM"));
        arrayList.add(new report("1002", "Tay Yong Zheng", "11", " 55KM"));
        arrayList.add(new report("1003", "Ong Volgent   ", "11", " 55KM"));
        arrayList.add(new report("1004", "Ong Chun Wei  ", "13", " 65KM"));

        System.out.printf("\n%12sDelivery Man Daily Work Report\n\n", " ");
        //System.out.printf("\n\n For DATE:  ");
        System.out.printf("Date: %s\t\t       Time: %s\n\n", dateFormat.format(c.getTime()), timeFormat.format(c.getTime()));
        //System.out.println( new java.sql.Date(System.currentTimeMillis()) );
        for (int i = 0; i < 54; i++) {
            System.out.print("#");
        }
        System.out.print("\n");

        int count = 0;

        System.out.printf("%-20s %-20s %-10s\n", "Delivery Man Name", "Complete delivery", "Distance");
        System.out.printf("------------------- -------------------- ----------- \n");
        //System.out.printf("%20s %10s %5s ", " User Name   ", " Complete delivery", " Distance\n");
        //System.out.printf("%20s %10s %5s ", "==================","===============", "==========\n");
        String display = arrayList.toString();

        System.out.print(display.replace("[", "").replace(",", "").replace("]", ""));
        System.out.printf("------------------- -------------------- ----------- \n");
        for (int i = 0; i < 54; i++) {
            System.out.print("#");
        }
        System.out.print("\n");
    }

    public static void RetrievePendingDeliveryMan() {
        int count = 0;
        StoredListInterface<DeliveryManInterface> deliveryManListReadFromFile = new StoredListkedList<>();
        deliveryManListReadFromFile = readDeliveryManFile();
        System.out.printf("\n\n%31s\n", "Delivery Mman Pending List");
        System.out.printf("%37s\n", "-------------------------------------");
        System.out.printf("%-5s %20s %10s\n", "No", "DeliveryMan Name", "Status");
        System.out.printf("%5s %20s   %10s\n", "-----", "------------------", "----------");

        for (int a = 1; a <= deliveryManListReadFromFile.getLength(); a++) {

            if (deliveryManListReadFromFile.getEntry(a).getDeliveryManStatus().equals("Pending")) {
                System.out.printf("%-5s    %-15s    %10s\n", ++count, deliveryManListReadFromFile.getEntry(a).getDeliveryManName(), deliveryManListReadFromFile.getEntry(a).getDeliveryManStatus());
            }
        }
        System.out.printf("%5s %20s   %10s\n", "-----", "------------------", "----------");
    }
}
