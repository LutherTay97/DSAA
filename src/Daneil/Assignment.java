/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daneil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Assignment {

    public static void main(String[] args) {

        List<Object> schedule = new ArrayList<>();
        List<Object> deliveryMan = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int choice;
        int order;

        Schedule1 s1 = new Schedule1("KFC", 28, 11, 2017, "Dinner Plate", 2, "1,Jalan ABC,Taman ABC,85000,Segamat,Johor", 0);
        schedule.add(s1);

        Schedule1 s2 = new Schedule1("McDonald", 29, 11, 2017, "Spicy Chicken McDeluxe", 2, "2,Jalan EFG,Taman EFG,85000,Segamat,Johor", 0);
        schedule.add(s2);

        Schedule1 s3 = new Schedule1("Sushi King", 1, 12, 2017, "Salmon Sushi", 2, "3,Jalan HIJ,Taman HIJ,85000,Segamat,Johor", 0);
        schedule.add(s3);

        Schedule1 s4 = new Schedule1("Domino Pizza", 3, 12, 2017, "Chicken Sausage Pizza", 2, "4,Jalan KLM,Taman KLM,85000,Segamat,Johor", 0);
        schedule.add(s4);

        DeliveryMan dm1 = new DeliveryMan("Abu", 0);
        deliveryMan.add(dm1);

        DeliveryMan dm2 = new DeliveryMan("Ali", 0);
        deliveryMan.add(dm2);

        DeliveryMan dm3 = new DeliveryMan("Ahman", 0);
        deliveryMan.add(dm3);

        DeliveryMan dm4 = new DeliveryMan("Afis", 0);
        deliveryMan.add(dm4);

        for (int i = 0; i < schedule.size(); i++) {
            if (i == 0) {
                System.out.printf("%d.Restaurant Name: %s\n", i + 1, s1.getRestaurantName());
                System.out.printf("  Date: %d.%d.%d\n", s1.getDate(), s1.getMonth(), s1.getYear());
                System.out.printf("  Food Name: %s\n", s1.getFoodName());
                System.out.printf("  Food Quantity: %s\n", s1.getFoodQuantity());
                System.out.printf("  Address: %s\n\n", s1.getAddress());
            } else if (i == 1) {
                System.out.printf("%d.Restaurant Name: %s\n", i + 1, s2.getRestaurantName());
                System.out.printf("  Date: %d.%d.%d\n", s2.getDate(), s2.getMonth(), s2.getYear());
                System.out.printf("  Food Name: %s\n", s2.getFoodName());
                System.out.printf("  Food Quantity: %s\n", s2.getFoodQuantity());
                System.out.printf("  Address: %s\n\n", s2.getAddress());
            } else if (i == 2) {
                System.out.printf("%d.Restaurant Name: %s\n", i + 1, s3.getRestaurantName());
                System.out.printf("  Date: %d.%d.%d\n", s3.getDate(), s3.getMonth(), s3.getYear());
                System.out.printf("  Food Name: %s\n", s3.getFoodName());
                System.out.printf("  Food Quantity: %s\n", s3.getFoodQuantity());
                System.out.printf("  Address: %s\n\n", s3.getAddress());
            } else if (i == 3) {
                System.out.printf("%d.Restaurant Name: %s\n", i + 1, s4.getRestaurantName());
                System.out.printf("  Date: %d.%d.%d\n", s4.getDate(), s4.getMonth(), s4.getYear());
                System.out.printf("  Food Name: %s\n", s4.getFoodName());
                System.out.printf("  Food Quantity: %s\n", s4.getFoodQuantity());
                System.out.printf("  Address: %s\n\n", s4.getAddress());
            }
        }
            System.out.println("Delivery Man:");
            for (int i = 0; i < deliveryMan.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, deliveryMan.get(i));
            }

            System.out.print("\nPlease select the Delivery Man:");
            choice = scanner.nextInt();
            
            String name = null;
            if (choice == 1)
            {
                name = "Abu";
            }
            else if (choice == 2)
            {
                name = "Ali";
            }
            else if (choice == 3)
            {
                name = "Ahman";
            }
            else
            {
                name = "Afis";
            }
            
            System.out.print("Please assign the order:");
            order = scanner.nextInt();
            
            System.out.printf("\n\nDelivery Man: %s\n", name);
            
            DeliveryMan dm = new DeliveryMan(choice, 1);
            deliveryMan.add(dm);

           
            System.out.println("Assign Successfully. Notice will send to the particular delivery man.");

        }

}
