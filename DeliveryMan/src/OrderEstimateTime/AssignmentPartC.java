package OrderEstimateTime;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    public static ArrayList<Customer> custList = new ArrayList<>();
    public static ArrayList<Order> orderList = new ArrayList<>();
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
        initializeList();
        mainMenu();
        //displayRestaurant();
        //selectRestaurant();
    }

    public static void mainMenu() {
        List<Order> listForOrderReadFromFile = readOrderFile();

        setCustDetails();
        System.out.print("Enter your customer id: ");
        String customerId = scanner.nextLine();
        Boolean isCustomer = false;
        boolean isPending = false;
        int customerIndex = 0;
        int indexForOrder = 0;
        do {
            for (int i = 0; i < custList.size(); i++) {
                if (customerId.equals(custList.get(i).getId())) {
                    isCustomer = true;
                    customerIndex = i;
                    break;
                }
            }

            for (int i = 0; i < listForOrderReadFromFile.size(); i++) {
                if (customerId.equals(listForOrderReadFromFile.get(i).getCustomer().getId())) {
                    if (listForOrderReadFromFile.get(i).getOrderStatus().equals("Delivery")) {
                        isPending = true;
                        indexForOrder = i;
                        break;
                    }
                }
            }
            if (isCustomer) {

                System.out.println("/nPlease choose what you want to do: ");
                System.out.println("1. Order");
                if (isPending) {
                    System.out.println("2. Estimate time to arrival");
                }
                System.out.print("Your choice: ");
                String choice = scanner.next();

                if (choice.equals("1")) {
                    displayRestaurant();
                    selectRestaurant(custList.get(customerIndex));
                } else if (choice.equals("2") && isPending) {
                    estimateTimeArrival(listForOrderReadFromFile, indexForOrder);
                } else {
                    System.exit(0);
                }
            } else {
                System.out.print("Invalid customer id! Please enter again: ");
                customerId = scanner.nextLine();
            }
        } while (isCustomer == false);

    }

    public static void retrieveCustDetails() {

        boolean isValid = false;

        while (isValid != true) {

            System.out.print("\nPlease enter customer's phone number: ");
            String phoneNo = scanner.next();

            for (int i = 0; i < custList.size(); i++) {

                if (phoneNo.equals(custList.get(i).getPhoneNo())) {

                    System.out.println("\nCustomer's Phone Number : " + custList.get(i).getPhoneNo());
                    System.out.println("Customer's Name         : " + custList.get(i).getName());
                    System.out.println("Customer's Area Code    : " + custList.get(i).getAreaCode());
                    isValid = true;
                    break;

                } else {
                    if (i + 1 == custList.size()) {
                        System.out.println("Sorry, there is no such number. Please try again.");
                    }
                }
            }
        }
    }

    public static void setCustDetails() {
        Customer customer1 = new Customer("0177654256", "Zoey Landsburg", "Sri Petaling");
        Customer customer2 = new Customer("0125839634", "Polalazi Washington", "Setapak");
        custList.add(customer1);
        custList.add(customer2);
    }

    public static void selectMenu(int chosen, Customer customer) {
        String goBackSelectMenu = null;
        int quantity = 0;

        List<String> selectedRestaurent = displayMenu(chosen);
        List<Order> listForOrder = new ArrayList<>();
        List<OrderList> listForOrderList = new ArrayList<>();
        
        SimpleDateFormat forTime = new SimpleDateFormat("HH:mm:ss");
        Date orderDate = new Date();

        Order order = new Order(customer, "Delivery", orderDate);
        Calendar c = Calendar.getInstance();
        double totalPrice = 0;
        int totalMenuItem = 1;
        do {
            for (int i = 0; i < selectedRestaurent.size(); i++) {
                System.out.println((i + 1) + ". " + selectedRestaurent.get(i));
                totalMenuItem++;
            }
            System.out.println("Please select: ");
            int menuChoice = scanner.nextInt();
            while (menuChoice < 1 || menuChoice > totalMenuItem) {
                System.out.print("Invalid menu! Please select again: ");
                menuChoice = scanner.nextInt();
            }

            System.out.println("You have select " + selectedRestaurent.get(menuChoice - 1));
            System.out.print("Quantity: ");
            quantity = scanner.nextInt();

            OrderList orderList = new OrderList(order.getOrderId(), selectedRestaurent.get(menuChoice - 1), quantity);
            listForOrderList.add(orderList);

            scanner.nextLine();
            System.out.print("Do you want to select food again?: ");
            goBackSelectMenu = scanner.nextLine();
        } while (goBackSelectMenu.equals("y"));

        for (int i = 0; i < listForOrderList.size(); i++) {
            totalPrice += listForOrderList.get(i).getQuantity() * 5;
        }
        c.setTime(orderDate);
        c.add(Calendar.MINUTE, 25);

        order.setTotalPrice(totalPrice);
        order.setEstimateArrivalTime(c.getTime());
        listForOrder.add(order);
        
        System.out.println("Order Done");
        System.out.println("Total Price: " + String.format("%.2f", totalPrice));
        System.out.println("Estimate time to arrivals: " + forTime.format(order.getEstimateArrivalTime()));

        writeDeliveryManFile(listForOrder);
    }

    public static void selectRestaurant(Customer customer) {

        int chosen = 0;
        int choice = 0;
        boolean isValid = false;

        while (isValid != true) {
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
        selectMenu(choice, customer);
    }

    public static void displayRestaurant() {
        System.out.println("List of Restaurants:");

        for (int i = 0; i < restaurantList.size(); i++) {
            System.out.println((i + 1) + ". " + restaurantList.get(i));
        }
    }

    public static List<String> displayMenu(int chosen) {
        System.out.println("\nMenu List:");
        List<String> chooseRestaurent = new ArrayList<>();
        if (chosen == 1) {
            chooseRestaurent = mcdList;
        } else if (chosen == 2) {
            chooseRestaurent = kfcList;
        } else if (chosen == 3) {
            chooseRestaurent = sushiList;
        } else if (chosen == 4) {
            chooseRestaurent = bbqList;
        } else if (chosen == 5) {
            chooseRestaurent = nandoList;
        } else {
            System.out.println("Sorry, there was an unexpected error.");
        }
        return chooseRestaurent;

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

        String yesNo;
        boolean isTrueFalse = false;
        boolean isValid = false;

        while (isValid != true) {

            System.out.print("You have chosen " + something + ". " + "Are you sure you want to proceed?(Yes/No or Y/N) ");
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

    public static List<Order> readOrderFile() {
        List<Order> listForOrder = new ArrayList<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("order.dat"));
            listForOrder = (List) oiStream.readObject();
            oiStream.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot read from delivery man file", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return listForOrder;
    }

    public static void writeDeliveryManFile(List<Order> listForOrder) {
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("order.dat"));
            ooStream.writeObject(listForOrder);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot save to file", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }
    }

    public static void estimateTimeArrival(List<Order> listForOrderReadFromFile, int indexForOrder) {
        SimpleDateFormat forTime = new SimpleDateFormat("HH:mm:ss");
        long diff = listForOrderReadFromFile.get(indexForOrder).getEstimateArrivalTime().getTime()- new Date().getTime();
        long minutes = diff / (60 * 1000) % 60;
        
        System.out.println("Estimate time arrivals: " + forTime.format(listForOrderReadFromFile.get(indexForOrder).getEstimateArrivalTime()));
        System.out.println("Remaining Time (minutes): " + minutes);
    }
}
