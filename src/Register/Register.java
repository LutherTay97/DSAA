
package register;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Register {

    public static void main(String[] args) {
        
        List<String> nameList = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        
        String confirmation = null;
        
        do {
        System.out.print("Please enter your Restaurant's name: ");
        String RName = scanner.nextLine();
        nameList.add(RName);

        System.out.print("Please enter your login name: ");
        String LName = scanner.nextLine();

        System.out.print("Please enter your login password: ");
        String password = scanner.nextLine();
        
        System.out.print("Do you want to register again? (y / n) : ");
        confirmation = scanner.nextLine();
        System.out.println();
        
        }while (confirmation.equals("y"));
        
        int list = 1;
        System.out.println();
        System.out.println("The restaurant name that you have created :");
        for (int a = 0; a < nameList.size(); a++) {
            System.out.println(list + ". " + nameList.get(a));
            list++;
        }
        //System.out.println("Your details is " + RName + " " + LName + " " + password);
        
    }
    
}
