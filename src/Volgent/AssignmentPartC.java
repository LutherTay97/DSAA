
package volgent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class AssignmentPartC {

    public static List<String> restaurantList = new ArrayList<String>();
    public static List<String> mcdList = new ArrayList<String>();
    public static List<String> kfcList = new ArrayList<String>();
    public static List<String> sushiList = new ArrayList<String>();
    public static List<String> bbqList = new ArrayList<String>();
    public static List<String> nandoList = new ArrayList<String>();
    
    
    //private static List<Runner> runnerList = new ArrayList<>();
    
    public static void main(String[] args) {
        
        initializeList();
        displayRestaurant();
        selectRestaurant();
    }
    
    public static void selectMenu(int chosen) {
        Scanner scanner = new Scanner(System.in);
        int menuChoice = 0;
        boolean isValid = false;
        
        displayMenu(chosen);
        
        while(isValid != true) {
            System.out.print("\nPlease enter the number from the menu: ");
            menuChoice = scanner.nextInt();
            
            if(menuChoice >= 1 && menuChoice <= 5){
                if(chosen == 1) {
                    if (chosen <= mcdList.size()) {
                        if (chosen <= 0) {
                            System.out.print("Sorry, there is no such number. Please choose again.\n");
                        } else {
                            menuChoice = menuChoice - 1;
                            isValid = askConfirmation(mcdList.get(menuChoice));
                        }
                    } else {
                        System.out.print("Sorry, there is no such number. Please choose again.\n");
                    }
                } else if(chosen == 2) {
                    if (chosen <= kfcList.size()) {
                        if (chosen <= 0) {
                            System.out.print("Sorry, there is no such number. Please choose again.\n");
                        } else {
                            menuChoice = menuChoice - 1;
                            isValid = askConfirmation(kfcList.get(menuChoice));
                        }
                    } else {
                        System.out.print("Sorry, there is no such number. Please choose again.\n");
                    }
                } else if(chosen == 3) {
                    if (chosen <= sushiList.size()) {
                        if (chosen <= 0) {
                            System.out.print("Sorry, there is no such number. Please choose again.\n");
                        } else {
                            menuChoice = menuChoice - 1;
                            isValid = askConfirmation(sushiList.get(menuChoice));
                        }
                    } else {
                        System.out.print("Sorry, there is no such number. Please choose again.\n");
                    }
                } else if(chosen == 4) {
                    if (chosen <= bbqList.size()) {
                        if (chosen <= 0) {
                            System.out.print("Sorry, there is no such number. Please choose again.\n");
                        } else {
                            menuChoice = menuChoice - 1;
                            isValid = askConfirmation(bbqList.get(menuChoice));
                        }
                    } else {
                        System.out.print("Sorry, there is no such number. Please choose again.\n");
                    }
                } else if(chosen == 5) {
                    if (chosen <= nandoList.size()) {
                        if (chosen <= 0) {
                            System.out.print("Sorry, there is no such number. Please choose again.\n");
                        } else {
                            menuChoice = menuChoice - 1;
                            isValid = askConfirmation(nandoList.get(menuChoice));
                        }
                    } else {
                        System.out.print("Sorry, there is no such number. Please choose again.\n");
                    }
                }else {
                    System.out.println("Sorry, there was an unexpected error.");
                }
            }else {
                System.out.println("Sorry, there is no such number from the menu. Please choose again.");
            }
        }
    }
    
    public static void selectRestaurant() {
        
        Scanner scanner = new Scanner(System.in);
        int chosen = 0;
        int choice = 0;
        boolean isValid = false;
        
        while(isValid != true) {
            System.out.print("\nPlease enter the number of the restaurant: ");
            choice = scanner.nextInt();
            
            if (choice <= restaurantList.size()) {
                if (choice <= 0) {
                    System.out.print("Sorry, there is no such restaurant. Please choose again.\n");
                } else {
                    chosen = choice - 1;
                    isValid = askConfirmation(restaurantList.get(chosen));
                }
            } else {
                System.out.print("Sorry, there is no such restaurant. Please choose again.\n");
            }
        }
        selectMenu(choice);
    }
    
    public static void displayRestaurant() {
        System.out.println("List of Restaurants:");
        
        for(int i = 0; i < restaurantList.size(); i++) {
            System.out.println((i + 1) + ". " + restaurantList.get(i));
        }
    }
    
    public static void displayMenu(int chosen) {
        System.out.println("\nMenu List:");
        
        if(chosen == 1) {
            for(int i = 0; i < mcdList.size(); i++) {
                System.out.println((i + 1) + ". " + mcdList.get(i));
            }
        } else if(chosen == 2) {
            for(int i = 0; i < kfcList.size(); i++) {
                System.out.println((i + 1) + ". " + kfcList.get(i));
            }
        } else if(chosen == 3) {
            for(int i = 0; i < sushiList.size(); i++) {
                System.out.println((i + 1) + ". " + sushiList.get(i));
            }
        } else if(chosen == 4) {
            for(int i = 0; i < bbqList.size(); i++) {
                System.out.println((i + 1) + ". " + bbqList.get(i));
            }
        } else if(chosen == 5) {
            for(int i = 0; i < nandoList.size(); i++) {
                System.out.println((i + 1) + ". " + nandoList.get(i));
            }
        } else {
            System.out.println("Sorry, there was an unexpected error.");
        }
        
    }
    
    public static void initializeList() {
        
        restaurantList.add("McDonalds");
        restaurantList.add("KFC");
        restaurantList.add("Sushi King");
        restaurantList.add("BBQ Plaza");
        restaurantList.add("Nando's");
        
        mcdList.add("McChicken");
        mcdList.add("Big Mac");
        mcdList.add("Beefburger");
        mcdList.add("Cheeseburger");
        mcdList.add("Filet-O-Fish");
        
        kfcList.add("Chizza Box");
        kfcList.add("Zinger Burger");
        kfcList.add("Colonel Burger");
        kfcList.add("Cheezy Wedges");
        kfcList.add("Vanilla Pudding Original");
        
        sushiList.add("Premium Salmon");
        sushiList.add("Tuna Mayo");
        sushiList.add("Salmon Nishoku");
        sushiList.add("Spicy Gyu Maki");
        sushiList.add("Tamago Maki");
        
        bbqList.add("Economy Pork Set");
        bbqList.add("Marinated Chicken Set");
        bbqList.add("Deluxe Family Set");
        bbqList.add("Family Mixed Set");
        bbqList.add("Season Set");
        
        nandoList.add("Red Velvet Cake");
        nandoList.add("Caramel Cheesecake");
        nandoList.add("Chicken Liver and Portuguese Roll");
        nandoList.add("Pineapple Slice");
        nandoList.add("Feta Cheese");
    }
    
    public static Boolean askConfirmation(String something) {
        Scanner scanner = new Scanner(System.in);
        String yesNo;
        boolean isTrueFalse = false;
        boolean isValid = false;
        
        while (isValid != true) {
            
            System.out.print("You have chosen " + something + ". " + "Are you sure you want to proceed?(Yes/No or Y/N) " );
            yesNo = scanner.next();
            
            if (yesNo.equalsIgnoreCase("Yes") || yesNo.equalsIgnoreCase("Y")) {
                isTrueFalse = true;
                isValid = true;
            } else if (yesNo.equalsIgnoreCase("No") || yesNo.equalsIgnoreCase("N")) {
                isTrueFalse = false;
                isValid = true;
            } else {
                System.out.println("\nSorry, there is no input like that. Please try again.");
                isValid = false;
            }
        }
        return isTrueFalse;
    }
    
    /* public static void readBinaryFile() {
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("runners.dat"));
            runnerList = (ArrayList)(oiStream.readObject()); //because the runnerList was created using it's own place, so need to use runningman.Runner class to get
           
            System.out.println(runnerList);

            oiStream.close();
        } catch (FileNotFoundException ex) {
          JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
          JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } 
    } */
}
