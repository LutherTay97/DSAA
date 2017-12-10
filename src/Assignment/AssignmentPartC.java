
package Assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class AssignmentPartC {

    public static List<String> restaurantList = new ArrayList<String>();
    
    public static ArrayList<Customer> custList = new ArrayList<>();
    public static ArrayList<Order> orderList = new ArrayList<>();
    public static int id = 3000;
    
    public static ArrayList<Food> mcdList = new ArrayList<>();
    public static ArrayList<Food> kfcList = new ArrayList<>();
    public static ArrayList<Food> sushiList = new ArrayList<>();
    public static ArrayList<Food> bbqList = new ArrayList<>();
    public static ArrayList<Food> nandoList = new ArrayList<>();
            
    public static ArrayList<ArrayList<Food>> foodListArray = new ArrayList<ArrayList<Food>>();
    
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        /*double totalPrice = 0;
        orderList.add(new Order(4, 25.00)); //100
        orderList.add(new Order(2, 10.00)); //20
        orderList.add(new Order(3, 15.00)); //45
        orderList.add(new Order(7, 5.00));  //35
        
        for(int i = 0; i < orderList.size(); i++){
            
            totalPrice += Order.countEachPrice(orderList.get(i).getQuantity(), orderList.get(i).getPrice());
            
        }
        System.out.println(totalPrice);*/
        
        /*for(int i = 0; i < foodListArray.size(); i++) {
            for(int a = 0; a < foodListArray.get(i).size(); a++){
                System.out.println(foodListArray.get(i).get(a).toString());
            }
        }
        orderList.add(new Order("Zinger Burger", 4, 25.00));
        orderList.add(new Order("McChicken", 2, 18.00));
        orderList.add(new Order("Chicken Marinated Super Burger", 8, 50.00));
        orderList.add(new Order("Marigold Milk", 2, 30.00));
        orderList.add(new Order("Spicy McChicken", 4, 40.00));
        */
        
        mainMenu();
        
    }
    
    public static void mainMenu() {
        
        System.out.println("\nMain Menu");
        System.out.println("----------------------------------");
        System.out.println("Please choose what you want to do: ");
        System.out.println("1. Retrieve Customer Details");
        System.out.println("2. Order");
        System.out.print("Your choice: ");
        String choice = scanner.next();
        
        if (choice.equals("1")) {
            setCustDetails();
        } else if (choice.equals("2")) {
            initializeList();
        } else {
            System.out.println("Sorry, there is no such input.");
            mainMenu();
        }
        
    }
    
    public static void setCustDetails() {
        custList.add(new Customer(1000, "0177654256", "Zoey Landsburg", "Sri Petaling"));
        custList.add(new Customer(1001, "0125839634", "Polalazi Washington", "Setapak"));
        custList.add(new Customer(1002, "0112380934", "Lunaris Starlight", "Gombak"));
        custList.add(new Customer(1003, "0198765432", "Nett Beckham", "PV128"));
        custList.add(new Customer(1004, "0123456789", "Calci Dutchtam", "Wangsa Maju"));
        
        retrieveCustDetails();
    }
    
    public static void retrieveCustDetails() {
        
        boolean isValid = false;

        while(isValid != true){
            
            System.out.print("\nPlease enter customer's phone number: ");
            String phoneNo = scanner.next();
            
            for(int i = 0; i < custList.size(); i++){
                
                if(phoneNo.equals(custList.get(i).getPhoneNo())){
                    
                    System.out.println("\nCustomer's ID           : " + custList.get(i).getId());
                    System.out.println("Customer's Phone Number : " + custList.get(i).getPhoneNo());
                    System.out.println("Customer's Name         : " + custList.get(i).getName());
                    System.out.println("Customer's Area Code    : " + custList.get(i).getAreaCode());
                    isValid = askChooseAgain();
                    
                    if(isValid == true){
                        mainMenu();
                    }
                    break;

                } else {
                    if(i + 1 == custList.size()){
                        System.out.println("Sorry, there is no such number. Please try again.");
                    }
                }
            }
        }
    }
    
    public static boolean askChooseAgain(){
        
        String yesNo;
        boolean isTrueFalse = false;
        boolean isValid = false;
        
        while (isValid != true) {
            
            System.out.print("\nDo you want to choose again?(Yes/No or Y/N): " );
            yesNo = scanner.next();
            
            if (yesNo.equalsIgnoreCase("Yes") || yesNo.equalsIgnoreCase("Y")) {
                isTrueFalse = false;
                isValid = true;
            } else if (yesNo.equalsIgnoreCase("No") || yesNo.equalsIgnoreCase("N")) {
                isTrueFalse = true;
                isValid = true;
            } else {
                System.out.println("Sorry, there is no input like that. Please try again.");
                isValid = false;
            }
        }
        return isTrueFalse;
    }
    
    public static void initializeList() {
        
        restaurantList.add("McDonalds");
        restaurantList.add("KFC");
        restaurantList.add("Sushi King");
        restaurantList.add("BBQ Plaza");
        restaurantList.add("Nando's");
        
        mcdList.add(new Food(4000, 1, "McChicken", 9.00));
        mcdList.add(new Food(4001, 2, "Big Mac", 12.00));
        mcdList.add(new Food(4002, 3, "Beefburger", 11.00));
        mcdList.add(new Food(4003, 4, "Cheeseburger", 10.00));
        mcdList.add(new Food(4004, 5, "Filet-O-Fish", 8.00));
        mcdList.add(new Food(4005, 6, "Spicy McChicken", 11.00));
        
        kfcList.add(new Food(5000, 1, "Chizza Box", 18.00));
        kfcList.add(new Food(5001, 2, "Zinger Burger", 13.00));
        kfcList.add(new Food(5002, 3, "Colonel Burger", 14.00));
        kfcList.add(new Food(5003, 4, "Cheezy Wedges", 7.00));
        kfcList.add(new Food(5004, 5, "Vanilla Pudding Original", 10.00));
        kfcList.add(new Food(5005, 6, "Chicken Nuggets", 8.00));
        
        sushiList.add(new Food(6000, 1, "Premium Salmon", 19.00));
        sushiList.add(new Food(6001, 2, "Tuna Mayo", 18.00));
        sushiList.add(new Food(6002, 3, "Salmon Nishoku", 20.00));
        sushiList.add(new Food(6003, 4, "Spicy Gyu Maki", 17.00));
        sushiList.add(new Food(6004, 5, "Tamago Maki", 14.00));
        sushiList.add(new Food(6005, 6, "Tuna Sandwich", 12.00));
        
        bbqList.add(new Food(7000, 1, "Economy Pork Set", 23.00));
        bbqList.add(new Food(7001, 2, "Marinated Chicken Set", 20.00));
        bbqList.add(new Food(7002, 3, "Deluxe Family Set", 25.00));
        bbqList.add(new Food(7003, 4, "Family Mixed Set", 30.00));
        bbqList.add(new Food(7004, 5, "Season Set", 26.00));
        bbqList.add(new Food(7005, 6, "Super Set", 32.00));
        
        nandoList.add(new Food(8000, 1, "Red Velvet Cake", 21.00));
        nandoList.add(new Food(8001, 2, "Caramel Cheesecake", 22.00));
        nandoList.add(new Food(8002, 3, "Chicken Liver and Portuguese Roll", 20.00));
        nandoList.add(new Food(8003, 4, "Pineapple Slice", 19.00));
        nandoList.add(new Food(8004, 5, "Feta Cheese", 24.00));
        nandoList.add(new Food(8005, 6, "Beta Mozzarella", 27.00));
        
        foodListArray.add(mcdList);
        foodListArray.add(kfcList);
        foodListArray.add(sushiList);
        foodListArray.add(bbqList);
        foodListArray.add(nandoList);
        
        displayRestaurant();
    }
    
    public static void displayRestaurant() {
        System.out.println("\nList of Restaurants:");
        
        for(int i = 0; i < restaurantList.size(); i++) {
            System.out.println((i + 1) + ". " + restaurantList.get(i));
        }
        
        selectRestaurant();
    }
    
    public static void selectRestaurant() {
        
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
                    isValid = askProceedConfirmation(restaurantList.get(chosen));
                }
            } else {
                System.out.print("Sorry, there is no such restaurant. Please choose again.\n");
            }
        }
        selectMenu(choice);
    }
    
    public static void displayMenu(int chosen) {
        System.out.println("\nMenu List:");
        
        for(int i = 0; i < foodListArray.size(); i++){
            for(int a = 0; a < foodListArray.get(i).size(); a++) {
                System.out.println((a + 1) + ". " + foodListArray.get(chosen - 1).get(a).getFood());
            }
            break;
        } 
    }
    
    public static void selectMenu(int chosen) {

        int menuChoice = 0;
        String foodName;
        double foodPrice = 0;
        boolean isValid = false;
        
        displayMenu(chosen);
        
        while(isValid != true) {
            System.out.print("\nPlease enter the number from the menu: ");
            menuChoice = scanner.nextInt();

            for(int i = 1; i <= foodListArray.size(); ++i){
                
                if(chosen == i){
                    if(menuChoice > 0 && menuChoice <= foodListArray.get(i).size()){
                        for(int a = 1; a <= foodListArray.get(i).size(); a++){
                            if(menuChoice == foodListArray.get(i).get(a).getNumber()){
                                isValid = askProceedConfirmation(foodListArray.get(i - 1).get(a).getFood());

                                if(isValid == true){
                                    foodName = foodListArray.get(i - 1).get(a).getFood();
                                    foodPrice = foodListArray.get(i - 1).get(a).getPrice();
                                    selectQuantity(foodName, foodPrice, chosen);
                                }
                                break;
                            }
                        }
                    } else {
                        System.out.println("Sorry, there is no such meal on the menu.");
                    }
                }
            }
        }
    }
    
    public static void selectQuantity(String foodName, double foodPrice, int chosen) {
        
        boolean isValid = false;
        
        System.out.print("\nPlease enter the quantity that you would like to have for " + foodName + " : ");
        int quantity = scanner.nextInt();
        
        while(isValid != true){
            setOrderList(foodName, quantity, foodPrice);
            isValid = askChooseAgain();
            
            if(isValid == false) {
                isValid = true;
                selectMenu(chosen);

            } else {
                viewOrderList();
            }
        }
    }
    
    public static void setOrderList(String foodName, int quantity, double foodPrice) {
        
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        //System.out.println(dateFormat.format(date));

        if(orderList.isEmpty()){
            orderList.add(new Order(id, foodName, quantity, "Unpaid", date, Order.countEachPrice(quantity, foodPrice)));
        } else {
            id = id + 1;
            orderList.add(new Order(id, foodName, quantity, "Unpaid", date, Order.countEachPrice(quantity, foodPrice)));            
        }
    }
    
    public static void viewOrderList() {
        String yesNo;
        boolean isValid = false;
        
        double totalPrice = 0;
        
        System.out.println("\nHere is a list of what you bought: ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("No.\t\tMeal Name\t\tQuantity\tPrice(RM)");
        System.out.println("-----------------------------------------------------------------");
        for(int i = 0; i < orderList.size(); i++){
            System.out.printf("%-3d %-35s %5d %16.2f\n", i + 1, orderList.get(i).getName(), orderList.get(i).getQuantity(), orderList.get(i).getPrice());
        }
        System.out.println("-----------------------------------------------------------------");
        
        for(int i = 0; i < orderList.size(); i++) {
            totalPrice += orderList.get(i).getPrice();
        }
        System.out.printf("\t\t\t\t\tTotal Price: RM%7.2f\n", totalPrice);

        
        while (isValid != true) {
            
            System.out.print("\nDo you want to go to main menu?(Yes/No or Y/N): ");
            yesNo = scanner.next();
            
            if (yesNo.equalsIgnoreCase("Yes") || yesNo.equalsIgnoreCase("Y")) {
                isValid = true;
                mainMenu();
            } else if (yesNo.equalsIgnoreCase("No") || yesNo.equalsIgnoreCase("N")) {
                isValid = true;
            } else {
                System.out.println("Sorry, there is no input like that. Please try again.");
                isValid = false;
            }
        }
    }
    
    public static Boolean askProceedConfirmation(String something) {
        
        String yesNo;
        boolean isTrueFalse = false;
        boolean isValid = false;
        
        while (isValid != true) {
            
            System.out.print("You have chosen " + something + ". " + "Are you sure you want to proceed?(Yes/No or Y/N): " );
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
