
package register;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Register {

    public static void main(String[] args) {
        
        List<String> nameList = new ArrayList<String>();
        List<String> loginName = new ArrayList<String>();
        List<String> loginPassword = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        
        String confirmation = null;
        
        System.out.print("Please enter your Restaurant's name: ");
        String RName = scanner.nextLine();
        nameList.add(RName);
        
        System.out.print("Please enter your Restaurant's main category of food: ");
        String toFood = scanner.nextLine();
        
        System.out.print("Please enter your Restaurant's address: ");
        String address = scanner.nextLine();
        
        System.out.print("Please enter your login username: ");
        String LName = scanner.nextLine();
        loginName.add(LName);

        System.out.print("Please enter your login password: ");
        String password = scanner.nextLine();
        loginPassword.add(password);
        
        System.out.println();
        System.out.println("Your restaurant named " + RName + " has created successful!");
        
        System.out.println();
        System.out.println("Do you want to login now? (y / n) : ");
        confirmation = scanner.nextLine();
        System.out.println();

        if(confirmation.equals("y")){
            
            System.out.println();
            System.out.print("Please enter your login name: ");
            String LoginName = scanner.nextLine();

            System.out.print("Please enter your login password: ");
            String Lpassword = scanner.nextLine();
            
            for (int i = 0; i < loginName.size(); i++) {
                if(LoginName.equals(loginName.get(i))) {
                    for (int a = 0; a < loginPassword.size(); a++) {
                        if(Lpassword.equals(loginPassword.get(i))) {
                            
                            System.out.println("Welcome to " + nameList.get(0) + " restaurant profile!");
                            System.out.println();
                            
                            System.out.println("Main Menu~");
                            System.out.println("1. Add menu");
                            System.out.println("2. Exit");
                            
                            System.out.println("Please select the menu~");
                            String selectedM = scanner.nextLine();
                            
                            do {
                            if(selectedM.equals(1)) {
                                
                                category();
                                
                            }else if(selectedM.equals(2)){
                                
                                System.out.println();
                                System.out.println("You have been logout successful! Thanks for using our system!");
                                System.exit(0);
                                
                            }
                            }while(!"1".equals(selectedM) && !"2".equals(selectedM)); //!"success".equals(statusCheck)
                        }
                        else {
                            System.out.println("Username or Password Wrong! You will been exit now!!!");
                        }
                    }
                }
                else {
                    System.out.println("Username or Password Wrong! You will been exit now!!");
                }
            }
        }
        else {
            System.out.println("88");
        }
        
        /*
        int list = 1;
        System.out.println();
        System.out.println("The restaurant name that you have created :");
        for (int a = 0; a < nameList.size(); a++) {
            System.out.println(list + ". " + nameList.get(a));
            list++;
        } */
        //System.out.println("Your details is " + RName + " " + LName + " " + password);
    }
    
    public static void category() {
        
        List<String> foodName = new ArrayList<String>();
        //List<Double> foodPrice = new ArrayList<Double>();
        
        Scanner scanner = new Scanner(System.in);
        
        String confirmation = null;
        
        System.out.println();
        System.out.println("Category Menu~");
        System.out.println("1. Food");
        System.out.println("2. Drink");
        System.out.println("3. Exit");

        System.out.println("Please select which category you want to add: ");
        int category = Integer.valueOf(scanner.nextLine());
        
        do {
            if (category == 1) {
                
                do {
                System.out.println("Please enter new food name: ");
                String fName = scanner.nextLine();
                foodName.add(fName);
                
                System.out.println("Please enter new food price: ");
                double fPrice = Double.parseDouble(scanner.nextLine());
                //foodPrice.add(fPrice);
                
                System.out.println("Do you want to add again(y / n)? : ");
                confirmation = scanner.nextLine();
                
                System.out.println();
                
                }while(confirmation.equals("y"));
                
                System.out.println();
                System.out.println("Your account have been logout!");
                System.out.println("Here is the food you added recently~");
                for(int i = 0; i < foodName.size(); i++) {
                    System.out.println(foodName.get(i));
                }
                System.exit(0);
            }
            else if (category == 2) {
                categoryD();
            }
            else if (category == 3) {
                System.out.println();
                System.out.println("You have been logout successful! Thanks for using our system!");
                System.exit(0);
            }
        }while(category != 1 || category != 2 || category != 3);
    }
    
    public static void categoryD() {
        
        List<String> drinkName = new ArrayList<String>();
        
        Scanner scanner = new Scanner(System.in);
        String confirmation = null;
        
        do {
                System.out.println("Please enter new drink name: ");
                String dName = scanner.nextLine();
                drinkName.add(dName);
                
                System.out.println("Please enter new drink price: ");
                double dPrice = Double.parseDouble(scanner.nextLine());
                //foodPrice.add(fPrice);
                
                System.out.println("Do you want to add again(y / n)? : ");
                confirmation = scanner.nextLine();
                
                System.out.println();
                
                }while(confirmation.equals("y"));
                
                System.out.println();
                System.out.println("Your account have been logout!");
                System.out.println("Here is the drink you added recently~");
                for(int i = 0; i < drinkName.size(); i++) {
                    System.out.println(drinkName.get(i));
                }
                System.exit(0);
    }
}
