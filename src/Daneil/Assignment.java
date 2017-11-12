package Daneil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import javax.print.attribute.standard.DateTimeAtCompleted;

public class Assignment {
    
    
    public static void main(String[] args) {

        List<Object> schedule = new ArrayList<>();
        
        Calendar now = Calendar.getInstance();

        int date = now.get(Calendar.DATE);
        int month = Calendar.MONTH;
        int year = Calendar.YEAR;

        Scanner scanner = new Scanner(System.in);
        String restaurantName;
        String Food;
        int BookingDate;
        int BookingMonth;
        int BookingYear;
        int foodQuantity;
        String fullDate;
        String FoodQuantity;

        System.out.print("Please enter the restaurant name: ");
        restaurantName = scanner.nextLine();

        System.out.printf("Restaurant name entered: %s\n", restaurantName);

        System.out.print("\n");

        System.out.print("Please enter the Booking Date(1-31): ");
        BookingDate = scanner.nextInt();

        if (BookingDate >= 1 && BookingDate <= 31 && BookingDate >= date) {
            System.out.print("Please enter the Booking Month(1-12): ");
            BookingMonth = scanner.nextInt();
            if (BookingMonth >= 1 && BookingMonth <= 12 && BookingMonth >= month) {
                System.out.print("Please enter the Booking Year: ");
                BookingYear = scanner.nextInt();
                if (BookingYear >= year) {
                    System.out.printf("Selected Date: %d - %d - %d\n", BookingDate, BookingMonth, BookingYear);

                    fullDate = "" + BookingDate + " - " + BookingMonth + " - " + BookingYear;

                    System.out.print("\n");
                    System.out.print("Please enter the Food Name: ");
                    Food = scanner.nextLine();

                    Food = scanner.nextLine();

                    System.out.print("Please enter the Food Quantity: ");
                    foodQuantity = scanner.nextInt();

                    FoodQuantity = "" + foodQuantity;

                    System.out.printf("Food: %s with Quantity: %d\n", Food, foodQuantity);

                    Schedule s = new Schedule(restaurantName, fullDate, Food, FoodQuantity);
                    schedule.add(s);
                }
            }
        }
        System.out.println("Order Successfully!");
        System.out.println("Payment will conduct when the food delivered!");
    }
}
