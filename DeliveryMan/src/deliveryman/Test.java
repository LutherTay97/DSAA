/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliveryMan;
import javaClass.*;

/**
 *
 * @author Win-8
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DeliveryMan man1 = new DeliveryMan("John", "01234567890", "john@gmail.com");
        
        System.out.println(man1.getStatus());
        
        man1.setStatus("Available");
        
        System.out.println(man1.getStatus());
    }
    
}
