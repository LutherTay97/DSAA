/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asspartb;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Win-8
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /** DeliveryManInterface man1 = new DeliveryMan(1000,"John", "971234567890", "123456", "Yong Peng", "0123456789", "0123456789", "Yong Peng", "Pending" ,"Working");
        DeliveryManInterface man2 = new DeliveryMan(1001,"Chin Zi Kang", "971234567890", "123456", "Yong Peng", "0123456789", "0123456789", "Yong Peng","Pending" , "Working");
        DeliveryManInterface man3 = new DeliveryMan(1002,"Hey Hong Sheng", "971234567890", "123456", "Yong Peng", "0123456789", "0123456789", "Yong Peng","Pending" ,"Working");
        DeliveryManInterface man4 = new DeliveryMan(1003,"Tay Yong Zheng", "971234567890", "123456", "Yong Peng", "0123456789", "0123456789", "Yong Peng", "Pending" ,"Working");
        DeliveryManInterface man5 = new DeliveryMan(1004,"Ong Chun Wei", "971234567890", "123456", "Yong Peng", "0123456789", "0123456789", "Yong Peng", "Pending" ,"Working");
        DeliveryManInterface man6 = new DeliveryMan(1005,"Ong Volgent", "971234567890", "123456", "Yong Peng", "0123456789", "0123456789", "Yong Peng", "Pending" ,"Working");
       
        StoredListInterface<DeliveryManInterface> deliveryManList = new StoredListkedList<>();
        deliveryManList.add(man1);
        deliveryManList.add(man2);
        deliveryManList.add(man3);
        deliveryManList.add(man4);
        deliveryManList.add(man5);
        deliveryManList.add(man6);
        
        
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("deliveryMan.dat"));
            ooStream.writeObject(deliveryManList);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot save to file", "ERROR", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }**/
        
        StoredListInterface<DeliveryManInterface> deliveryManListReadFromFile = new StoredListkedList<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("deliveryMan.dat"));
            deliveryManListReadFromFile = (StoredListInterface) oiStream.readObject();
            oiStream.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot read from delivery man file", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }
        
        int highest = Integer.parseInt(deliveryManListReadFromFile.getEntry(1).getDeliveryManId().substring(1, 5));
        
        for (int i=1; i<=deliveryManListReadFromFile.getLength(); i++) {
            System.out.println(deliveryManListReadFromFile.getEntry(i).getDeliveryManId()+"      "+deliveryManListReadFromFile.getEntry(i).getDeliveryManName());
            
            if (Integer.parseInt(deliveryManListReadFromFile.getEntry(i).getDeliveryManId().substring(1, 5)) > highest) {
                highest = Integer.parseInt(deliveryManListReadFromFile.getEntry(i).getDeliveryManId().substring(1, 5));
            }
        }
        
        System.out.println("Highest: " + highest);
        
        /*DeliveryManAttendance test1 = new DeliveryManAttendance(man1);
        test1.setClockIn(new Date());
        System.out.println(test1.getClockIn());
        
        StoredListInterface<DeliveryManAttendance> tempList = new StoredListkedList<>();
        tempList.add(test1);
        
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("deliveryManAttendance.dat"));
            ooStream.writeObject(tempList);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot save to file", "ERROR", JOptionPane.ERROR_MESSAGE);
        }*/
    }
    
}
