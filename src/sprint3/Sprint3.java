package sprint3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sprint3 {

    public static void main(String[] args) {
        
        String yesNo;
        
        List<Schedule2> schedule2 = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        Schedule2 s1 = new Schedule2("KFC", 15, 12, 2017, "Dinner Plate", 2, "1,Jalan ABC,Taman ABC,85000,Segamat,Johor", 0);
        schedule2.add(s1);

        System.out.print("Login ID:");
        String loginID = scanner.nextLine();

        System.out.print("Password:");
        String password = scanner.nextLine();
        do {
        for (int i = 0; i < schedule2.size(); i++) {
            if (i == 0) {
                System.out.printf("\n%d.Restaurant Name: %s\n", i + 1, s1.getRestaurantName());
                System.out.printf("  Date: %d.%d.%d\n", s1.getDate(), s1.getMonth(), s1.getYear());
                System.out.printf("  Food Name: %s\n", s1.getFoodName());
                System.out.printf("  Food Quantity: %s\n", s1.getFoodQuantity());
                System.out.printf("  Address: %s\n\n", s1.getAddress());
            }
        }

        
            System.out.print("Select the menu that you want to update: ");
            int option = scanner.nextInt();

            if (option == 1) {
                System.out.printf("\n1.Restaurant Name: %s\n", s1.getRestaurantName());
                System.out.printf("2.Date: %d.%d.%d\n", s1.getDate(), s1.getMonth(), s1.getYear());
                System.out.printf("3.Address: %s\n\n", s1.getAddress());

                System.out.print("Select the option that you want to update: ");
                int choice = scanner.nextInt();

                String i = scanner.nextLine();

                if (choice == 1) {
                    System.out.print("Please enter the new Restaurant Name:");
                    String newRestaurantName = scanner.nextLine();

                    System.out.print("Please enter the new Food Name:");
                    String newFoodName = scanner.nextLine();

                    System.out.print("Please enter the Food Quantity:");
                    int newQuantity = scanner.nextInt();

                    s1.setRestaurantName(newRestaurantName);
                    s1.setFoodName(newFoodName);
                    s1.setFoodQuantity(newQuantity);

                    System.out.println("Update Successfully");
                    System.out.printf("\n1.Restaurant Name: %s\n", s1.getRestaurantName());
                    System.out.printf("2.Date: %d.%d.%d\n", s1.getDate(), s1.getMonth(), s1.getYear());
                    System.out.printf("3.Food Name: %s\n", s1.getFoodName());
                    System.out.printf("4.Food Quantity: %s\n", s1.getFoodQuantity());
                    System.out.printf("5.Address: %s\n\n", s1.getAddress());
                } else if (choice == 2) {
                    System.out.print("Please enter the new Date:");
                    int newDate = scanner.nextInt();

                    System.out.print("Please enter the new Month:");
                    int newMonth = scanner.nextInt();

                    System.out.print("Please enter the new Year:");
                    int newYear = scanner.nextInt();

                    s1.setDate(newDate);
                    s1.setMonth(newMonth);
                    s1.setYear(newYear);

                    System.out.println("Update Successfully");
                    System.out.printf("\n1.Restaurant Name: %s\n", s1.getRestaurantName());
                    System.out.printf("2.Date: %d.%d.%d\n", s1.getDate(), s1.getMonth(), s1.getYear());
                    System.out.printf("3.Food Name: %s\n", s1.getFoodName());
                    System.out.printf("4.Food Quantity: %s\n", s1.getFoodQuantity());
                    System.out.printf("5.Address: %s\n\n", s1.getAddress());
                } else if (choice == 3) {
                    System.out.print("Please enter the new Delivery Address:");
                    String newAddress = scanner.nextLine();

                    s1.setAddress(newAddress);
                    System.out.println("Update Successfully");
                    System.out.printf("\n1.Restaurant Name: %s\n", s1.getRestaurantName());
                    System.out.printf("2.Date: %d.%d.%d\n", s1.getDate(), s1.getMonth(), s1.getYear());
                    System.out.printf("3.Food Name: %s\n", s1.getFoodName());
                    System.out.printf("4.Food Quantity: %s\n", s1.getFoodQuantity());
                    System.out.printf("5.Address: %s\n\n", s1.getAddress());
                }
            }
            
            String g = scanner.nextLine();
            
            System.out.print("Do you want to continue (Y or N):");
            yesNo = scanner.nextLine();
                 
        } while (yesNo.equals("Y") || yesNo.equals("y"));

    }
}
