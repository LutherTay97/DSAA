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

        if (confirmation.equals("y")) {

            System.out.println();
            System.out.print("Please enter your login name: ");
            String LoginName = scanner.nextLine();

            System.out.print("Please enter your login password: ");
            String Lpassword = scanner.nextLine();

            for (int i = 0; i < loginName.size(); i++) {
                if (LoginName.equals(loginName.get(i))) {
                    for (int a = 0; a < loginPassword.size(); a++) {
                        if (Lpassword.equals(loginPassword.get(i))) {

                            String selectedM = "";

                            System.out.println("Welcome to " + nameList.get(0) + " restaurant profile!");
                            System.out.println();

                            category();
                        } else {
                            System.out.println("Username or Password Wrong! You will been exit now!!!");
                        }
                    }
                } else {
                    System.out.println("Username or Password Wrong! You will been exit now!!");
                }
            }
        } else {
            System.out.println("Thanks for using our system, have a Nice Day~");
        }
    }
    
    public static void category() {

        List<String> foodName = new ArrayList<String>();
        List<String> drinkName = new ArrayList<String>();
        List<Double> foodPrice = new ArrayList<Double>();
        List<Double> drinkPrice = new ArrayList<Double>();
        
        foodName.add("Chicken Chop");
        foodName.add("Mee Goreng");
        drinkName.add("Coca-Cola");
        drinkName.add("Ice Lemon Tea");
        foodPrice.add(12.50);
        foodPrice.add(4.50);
        drinkPrice.add(3.00);
        drinkPrice.add(3.50);
        
        Scanner updateFName = new Scanner(System.in);
        Scanner deleteFName = new Scanner(System.in);
        Scanner deleteDName = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        Scanner updateNFPrice = new Scanner(System.in);
        
        int category = 0;
        String confirmation = null;
        String deleteConfirm = null;
        String updateConfirm = null;
        String confirmation3 = null;
        String selection = null;
        String dselection = null;
        String uselection = null;
        String updateNName = null;
        String changeValue = null;
        double updatePFName = 0;
        int updateNSelection = 0;
        int arrayUpdateName = 0;
        int deleteSelection = 0;
        int count = 1;
        int arrayDelete = 0;

        System.out.println();
        do {

            System.out.println("Welcome to mystery menu system!");
            System.out.println("1. Add Menu");
            System.out.println("2. View Menu");
            System.out.println("3. Update Menu");
            System.out.println("4. Delete Menu");
            System.out.println("Please select your choice: ");
            scanner.nextLine();
            selection = scanner.nextLine();

            while (!selection.equals("1") && !selection.equals("2") && !selection.equals("3") && !selection.equals("4")) {
                System.out.println("Input error! Please select the menu again~");
                selection = scanner.nextLine();
            }

            if (selection.equals("1")) {

                System.out.println();
                System.out.println("Category Menu~");
                System.out.println("1. Food");
                System.out.println("2. Drink");
                System.out.println("3. Exit");

                System.out.println("Please select which category you want to add: ");
                category = Integer.valueOf(scanner.nextLine());

                while (category != 1 && category != 2 && category != 3) {
                    System.out.println("Input error! Please enter again E~");
                    category = scanner.nextInt();
                }

                if (category == 1) {

                    do {
                        System.out.println("Please enter new food name: ");
                        String fName = scanner.nextLine();
                        foodName.add(fName);

                        System.out.println("Please enter new food price: ");
                        double fPrice = Double.parseDouble(scanner.nextLine());
                        foodPrice.add(fPrice);

                        System.out.println("Do you want to add again(y / n)? : ");
                        confirmation = scanner.nextLine();
                        
                         while (!confirmation.equals("y") && !confirmation.equals("n")) {
                            System.out.println("Input error! Please select the menu again~");
                            confirmation = scanner.nextLine();
                        }
                    } while (confirmation.equals("y"));

                        if(confirmation.equals("n")){
                            System.out.println();
                            System.out.println("Do you want go back main menu(y / n)? : ");
                            confirmation3 = scanner.nextLine();
                            
                            if(confirmation3.equals("n")){
                                
                                    System.out.println();
                                    System.out.println("Your account have been logout!");
                                    System.out.println("Here is the food you added recently~");
                                    for (int i = 0; i < foodName.size(); i++) {
                                        System.out.println(foodName.get(i));
                                    }
                                    System.exit(0);
                            }
                        }
                } else if (category == 2) {

                    do {
                        System.out.println("Please enter new drink name: ");
                        String fName = scanner.nextLine();
                        drinkName.add(fName);

                        System.out.println("Please enter new drink price: ");
                        double dPrice = Double.parseDouble(scanner.nextLine());
                        drinkPrice.add(dPrice);

                        System.out.println("Do you want to add again(y / n)? : ");
                        confirmation = scanner.nextLine();
                        
                         while (!confirmation.equals("y") && !confirmation.equals("n")) {
                            System.out.println("Input error! Please select the menu again~");
                            confirmation = scanner.nextLine();
                        }
                    } while (confirmation.equals("y"));

                        if(confirmation.equals("n")){
                            System.out.println();
                            System.out.println("Do you want go back main menu(y / n)? : ");
                            confirmation3 = scanner.nextLine();
                            
                            if(confirmation3.equals("n")){
                                
                                    System.out.println();
                                    System.out.println("Your account have been logout!");
                                    System.out.println("Here is the drink you added recently~");
                                    for (int i = 0; i < drinkName.size(); i++) {
                                        System.out.println(drinkName.get(i));
                                    }
                                    System.exit(0);
                            }
                        }
                } else if (category == 3) {
                    System.out.println();
                    System.out.println("You have been logout successful! Thanks for using our system!");
                    System.exit(0);
                }
            }
            else if (selection.equals("2")) {
                    
                    System.out.println();
                    System.out.println("Your food menu list~!");

                    for (int i = 0; i < foodName.size(); i++) {
                        System.out.println(foodName.get(i) + "------" + foodPrice.get(i));
                    }

                    System.out.println();
                    System.out.println("Your drink menu list");

                    for (int i = 0; i < drinkName.size(); i++) {
                        System.out.println(drinkName.get(i) + "------" + drinkPrice.get(i));
                    }

                    System.out.println();
                    System.out.println("Here is all the items in your restaurants.");
                    System.out.println("Do you want go back main menu(y / n)? : ");
                    confirmation3 = scanner.nextLine();
                    
                    while (!confirmation3.equals("y") && !confirmation3.equals("n")) {
                        System.out.println("Input error! Please select the menu again~");
                        confirmation3 = scanner.nextLine();
                    }
                }
            else if(selection.equals("3")) {
                
                System.out.println("Update--Category Menu--");
                System.out.println("1. Food");
                System.out.println("2. Drink");
                System.out.println("3. Exit");
                System.out.println("Please select your choice:");
                updateConfirm = scanner.nextLine();
                
                while (!updateConfirm.equals("1") && !updateConfirm.equals("2") && !updateConfirm.equals("3")) {
                    System.out.println("Input error! Please select the menu again~");
                    updateConfirm = scanner.nextLine();
                }
                
                if(updateConfirm.equals("1")) {
                        
                        count = 0;
                        do {
                            count = 1;
                            
                            System.out.println("Here's is all the food in your restaurant!~");

                                for (int i = 0; i < foodName.size(); i++) {
                                    System.out.println(count + ". " + foodName.get(i));
                                    count++;
                                }
                                
                            System.out.println("Please select the number to update the item:");
                            updateNSelection = scanner.nextInt();
                            arrayUpdateName = updateNSelection;
                            arrayUpdateName--;
                            
                            /*
                            while (arrayUpdateName > foodName.size() || arrayUpdateName < foodName.size()) {
                                System.out.println("Input error! Please select the menu again~");
                                updateNSelection = scanner.nextInt();
                            } 
                            int Max = 0;
                            int Min = 1;
                            
                            for (int a = 0; a < foodName.size(); a++) {
                                Max++;
                            }
                            
                            while (updateNSelection > Max && updateNSelection < Min) {
                                System.out.println("Input error! Please select the menu again~");
                                updateNSelection = scanner.nextInt();
                            }*/
                            
                            System.out.println();
                            System.out.println("Please select your choice to update the selected item details!");
                            System.out.println("1. Name");
                            System.out.println("2. Price");
                            changeValue = updateNFPrice.nextLine();
                            
                            if(changeValue.equals("1")) {
                                
                                System.out.println();
                                System.out.println("Please enter the new name for the current food:");
                                updateNName = updateFName.nextLine();

                                for (int j = 0; j < foodName.size(); j++) {
                                    if(j == arrayUpdateName) {
                                        foodName.set(j, updateNName);
                                    }
                                }
                            }
                            else if (changeValue.equals("2")) {
                                
                                System.out.println();
                                System.out.println("Please enter the new price for the current food:");
                                updatePFName = updateFName.nextDouble();

                                for (int j = 0; j < foodName.size(); j++) {
                                    if(j == arrayUpdateName) {
                                        foodPrice.set(j, updatePFName);
                                    }
                                }
                            }
                            
                            System.out.println();
                            System.out.println("The selected item have been update successfully!");
                            System.out.println("Do you want to update other food (y / n)?");
                            updateFName.nextLine();
                            uselection = updateFName.nextLine();
                        
                            while (!uselection.equals("y") && !uselection.equals("n")) {
                                
                                System.out.println("Brainless Netbean");
                                updateFName.nextLine();
                                uselection = updateFName.nextLine();
                            } 
                    } while (uselection.equals("y"));
                    
                    if(uselection.equals("n")){
                        System.out.println();
                        System.out.println("Do you want go back main menu(y / n)? : ");
                        confirmation3 = updateFName.nextLine();
                    }
                }
                else if(updateConfirm.equals("2")) {
                        
                        count = 0;
                        do {
                            count = 1;
                            
                            System.out.println("Here's is all the food in your restaurant!~");

                                for (int i = 0; i < drinkName.size(); i++) {
                                    System.out.println(count + ". " + drinkName.get(i));
                                    count++;
                                }
                                
                            System.out.println("Please select the number to update the item:");
                            updateNSelection = scanner.nextInt();
                            arrayUpdateName = updateNSelection;
                            arrayUpdateName--;
                            
                            /*
                            while (arrayUpdateName > foodName.size() || arrayUpdateName < foodName.size()) {
                                System.out.println("Input error! Please select the menu again~");
                                updateNSelection = scanner.nextInt();
                            } 
                            int Max = 0;
                            int Min = 1;
                            
                            for (int a = 0; a < foodName.size(); a++) {
                                Max++;
                            }
                            
                            while (updateNSelection > Max && updateNSelection < Min) {
                                System.out.println("Input error! Please select the menu again~");
                                updateNSelection = scanner.nextInt();
                            }*/
                            
                            System.out.println();
                            System.out.println("Please select your choice to update the selected item details!");
                            System.out.println("1. Name");
                            System.out.println("2. Price");
                            changeValue = updateNFPrice.nextLine();
                            
                            if(changeValue.equals("1")) {
                                
                                System.out.println();
                                System.out.println("Please enter the new name for the current drink:");
                                updateNName = updateFName.nextLine();

                                for (int j = 0; j < drinkName.size(); j++) {
                                    if(j == arrayUpdateName) {
                                        drinkName.set(j, updateNName);
                                    }
                                }
                            }
                            else if (changeValue.equals("2")) {
                                
                                System.out.println();
                                System.out.println("Please enter the new price for the current drink:");
                                updatePFName = updateFName.nextDouble();

                                for (int j = 0; j < drinkName.size(); j++) {
                                    if(j == arrayUpdateName) {
                                        drinkPrice.set(j, updatePFName);
                                    }
                                }
                            }
                            
                            System.out.println();
                            System.out.println("The selected item have been update successfully!");
                            System.out.println("Do you want to update other food (y / n)?");
                            updateFName.nextLine();
                            uselection = updateFName.nextLine();
                        
                            while (!uselection.equals("y") && !uselection.equals("n")) {
                                
                                System.out.println("Brainless Netbean");
                                updateFName.nextLine();
                                uselection = updateFName.nextLine();
                            } 
                    } while (uselection.equals("y"));
                    
                    if(uselection.equals("n")){
                        System.out.println();
                        System.out.println("Do you want go back main menu(y / n)? : ");
                        confirmation3 = updateFName.nextLine();
                    }
                }
            }
            else if (selection.equals("4")) {
                
                System.out.println("Deleteion--Category Menu--");
                System.out.println("1. Food");
                System.out.println("2. Drink");
                System.out.println("3. Exit");
                System.out.println("Please select your choice:");
                deleteConfirm = scanner.nextLine();
                
                while (!deleteConfirm.equals("1") && !deleteConfirm.equals("2") && !deleteConfirm.equals("3")) {
                    System.out.println("Input error! Please select the menu again~");
                    deleteConfirm = scanner.nextLine();
                }
                
                if(deleteConfirm.equals("1")) {
                        
                        count = 0;
                        
                        do {
                            System.out.println("Here's is all the food in your restaurant!~");
                                
                                count = 1;
                                
                                for (int i = 0; i < foodName.size(); i++) {
                                    System.out.println(count + ". " + foodName.get(i));
                                    count++;
                                }
                            System.out.println("Please select the number to delete the item:");
                            deleteSelection = deleteFName.nextInt();
                            arrayDelete = deleteSelection;
                            arrayDelete--;

                            for (int j = 0; j < foodName.size(); j++) {
                                if(j == arrayDelete) {
                                    foodName.remove(j);
                                    foodPrice.remove(j);
                                }
                            }
                            
                            System.out.println();
                            System.out.println("The selected item have been deleted successfully!");
                            System.out.println("Do you want to delete other food (y / n)?");
                            deleteFName.nextLine();
                            dselection = deleteFName.nextLine();
                        
                            while (!dselection.equals("y") && !dselection.equals("n")) {
                                
                                System.out.println("Brainless Netbean");
                                dselection = deleteFName.nextLine();
                            } 
                    } while (dselection.equals("y"));
                    
                    if(dselection.equals("n")){
                        System.out.println();
                        System.out.println("Do you want go back main menu(y / n)? : ");
                        confirmation3 = scanner.nextLine();
                    }
                }
                if(deleteConfirm.equals("2")) {
                        
                        count = 0;
                    
                        do {
                            System.out.println("Here's is all the drinks in your restaurant!~");
                            
                                count = 1;
                            
                                for (int i = 0; i < drinkName.size(); i++) {
                                    System.out.println(count + ". " + drinkName.get(i));
                                    count++;
                                }
                            System.out.println("Please select the number to delete the item:");
                            deleteSelection = deleteDName.nextInt();
                            arrayDelete = deleteSelection;
                            arrayDelete--;

                            for (int j = 0; j < drinkName.size(); j++) {
                                if(j == arrayDelete) {
                                    drinkName.remove(j);
                                    drinkPrice.remove(j);
                                }
                            }
                            
                            System.out.println();
                            System.out.println("The selected item have been deleted successfully!");
                            System.out.println("Do you want to delete other food (y / n)?");
                            dselection = deleteDName.nextLine();
                        
                            while (!dselection.equals("y") && !dselection.equals("n")) {
                                
                                System.out.println("Brainless Netbean");
                                dselection = deleteDName.nextLine();
                            } 
                    } while (dselection.equals("y"));
                    
                    if(dselection.equals("n")){
                        System.out.println();
                        System.out.println("Do you want go back main menu(y / n)? : ");
                        confirmation3 = scanner.nextLine();
                    }
                }
            }
            
        }while (confirmation3.equals("y"));

        System.out.println();
        System.out.println("Your account have been logout!");
        System.exit(0);
    }
}

