/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliveryman;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javaClass.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Win-8
 */
public class DeliveryManApplication {

    /**
     * @param args the command line arguments
     */
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<DeliveryMan> readFromFileList = null;

        //Write to dat file
        /*try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("deliveryMan.dat"));
            ooStream.writeObject(deliveryManList);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot save to file", "ERROR", JOptionPane.ERROR_MESSAGE);
        }*/
        //read from dat file
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("deliveryMan.dat"));
            readFromFileList = (ArrayList) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        System.out.println("Enter your delivery man id: ");
        String id = scanner.nextLine();

        for (int a = 0; a < readFromFileList.size(); a++) {
            if (readFromFileList.get(a).getDeliveryManId().equals(id)) {
                System.out.println("Welcome " + readFromFileList.get(a).getName());
                deliveryManFunction(readFromFileList.get(a));
                break;
            }
        }
    }

    @SuppressWarnings("empty-statement")
    public static void deliveryManFunction(DeliveryMan deliveryManDetail) {
        DeliveryManAttendance attendance = new DeliveryManAttendance(deliveryManDetail);

        SimpleDateFormat forDate = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat forTime = new SimpleDateFormat("HH:mm:ss");

        List<DeliveryManAttendance> attendanceList = new ArrayList<>();
        List<DeliveryManAttendance> attendanceListReadFromFile = null;

        int choose;
        
        do {
            System.out.println("1. Clock In");
            System.out.println("2. Clock Out");
            System.out.println("3. Logout");
            choose = scanner.nextInt();

            if (choose == 1) {
                attendanceListReadFromFile = readAttendanceFile();
                boolean clockInAlready = false;

                for (int a = 0; a < attendanceListReadFromFile.size(); a++) {
                    if (attendanceListReadFromFile.get(a).getDeliveryMan().getDeliveryManId().equals(deliveryManDetail.getDeliveryManId()) && forDate.format(attendanceListReadFromFile.get(a).getClockIn()).equals(forDate.format(new Date()))) {
                        clockInAlready = true;
                        break;
                    } else {
                        clockInAlready = false;
                    }
                }

                if (clockInAlready == false) {
                    attendance.setClockIn(new Date());
                    attendanceListReadFromFile.add(attendance);
                    writeAttendenceFile(attendanceListReadFromFile);
                    System.out.println("Clock In success. Clock in date is: " + forDate.format(attendance.getClockIn()) + " Clock in time" +forTime.format(attendance.getClockIn()) + "\n\n\n\n");
                } else {
                    System.out.println("Clock in already\n\n\n\n");
                }

            } else if (choose == 2) {
                attendanceListReadFromFile = readAttendanceFile();
                int index = 0;

                for (int a = 0; a < attendanceListReadFromFile.size(); a++) {
                    if (attendanceListReadFromFile.get(a).getDeliveryMan().getDeliveryManId().equals(deliveryManDetail.getDeliveryManId()) && forDate.format(attendanceListReadFromFile.get(a).getClockIn()).equals(forDate.format(new Date()))) {
                        index = a;
                        break;
                    }
                }

                boolean clockInToday = false;

                for (int a = 0; a < attendanceListReadFromFile.size(); a++) {

                    if (attendanceListReadFromFile.get(a).getDeliveryMan().getDeliveryManId().equals(deliveryManDetail.getDeliveryManId()) && forDate.format(attendanceListReadFromFile.get(a).getClockIn()).equals(forDate.format(new Date())) && attendanceListReadFromFile.get(a).getClockOut() == null) {
                        clockInToday = true;
                        break;
                    } else if (attendanceListReadFromFile.get(a).getDeliveryMan().getDeliveryManId().equals(deliveryManDetail.getDeliveryManId()) && attendanceListReadFromFile.get(a).getClockIn() == null) {
                        clockInToday = false;
                    } else if (attendanceListReadFromFile.get(a).getDeliveryMan().getDeliveryManId().equals(deliveryManDetail.getDeliveryManId()) && !attendanceListReadFromFile.get(a).getClockOut().equals(null)) {
                        clockInToday = false;
                    }
                }

                if (clockInToday == false) {
                    System.out.println("Clock out fail!\n\n\n\n");
                } else {
                    attendance = attendanceListReadFromFile.get(index);
                    attendance.setClockOut(new Date());
                    attendanceListReadFromFile.set(index, attendance);
                    System.out.println("Clock out success. Clock out date: "+ forDate.format(attendance.getClockIn()) + "   Clock out time: " +forTime.format(attendance.getClockIn()) + "\n\n\n\n");
                    writeAttendenceFile(attendanceListReadFromFile);
                }
            }
        } while (choose != 3);
        
        attendanceListReadFromFile = readAttendanceFile();
        for (int a = 0; a < attendanceListReadFromFile.size(); a++) {
            System.out.print("ID: " + attendanceListReadFromFile.get(a).getDeliveryMan().getDeliveryManId());
            System.out.print("      Clock In: " + attendanceListReadFromFile.get(a).getClockIn());
            System.out.println("       Clock Out: " + attendanceListReadFromFile.get(a).getClockOut());
        }
        
        System.exit(0);
    }

    public static List<DeliveryManAttendance> readAttendanceFile() {
        List<DeliveryManAttendance> attendanceListReadFromFile = new ArrayList<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("deliveryManAttendance.dat"));
            attendanceListReadFromFile = (List) oiStream.readObject();
            oiStream.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return attendanceListReadFromFile;
    }

    public static void writeAttendenceFile(List<DeliveryManAttendance> attendanceList) {
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("deliveryManAttendance.dat"));
            ooStream.writeObject(attendanceList);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot save to file", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
