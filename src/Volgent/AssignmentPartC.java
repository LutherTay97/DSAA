
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

    private static List<String> restaurantList = new ArrayList<String>();
    
    //private static List<Runner> runnerList = new ArrayList<>();
    
    public static void main(String[] args) {
        
        //readBinaryFile();
        
        initializeList();
        displayMenu();
        selectRestaurant();
    }
    
    private static void selectRestaurant() {
        
        Scanner scanner = new Scanner(System.in);
        boolean pass = false;
        
        while(pass != true) {
            System.out.print("\nPlease type the number of the restaurant: ");
            int choice = scanner.nextInt();
            
            //if (choice <= runnerList.size()) {
            if (choice <= restaurantList.size()) {
                if (choice <= 0) {
                    System.out.print("Sorry, there is no such restaurant. Please choose again.\n");
                } else {
                    choice -= 1;
                    System.out.println("You have chosen " + restaurantList.get(choice) + ".");
                    pass = true;
                }
            } else {
                System.out.print("Sorry, there is no such restaurant. Please choose again.\n");
            }
        }
            
    }
    
    private static void displayMenu() {
        
        System.out.println("List of Restaurants:");
        
        for(int i = 0; i < restaurantList.size(); i++) {
            
            System.out.println((i + 1) + ". " + restaurantList.get(i));
        }
        
    }
    
    private static void initializeList() {
        
        restaurantList.add("McDonalds");
        restaurantList.add("KFC");
        restaurantList.add("Sushi King");
        restaurantList.add("BBQ Plaza");
        restaurantList.add("Nando's");
        restaurantList.add("Domino's Pizza");
        restaurantList.add("Pizza Hut");
        restaurantList.add("Sushi Mentai");
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
