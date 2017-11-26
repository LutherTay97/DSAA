/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliveryMan;

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
        /*DeliveryMan man1 = new DeliveryMan("John", "01234567890", "john@gmail.com");
        DeliveryMan man2 = new DeliveryMan("Alex", "01234567890", "alex@gmail.com");
        DeliveryMan man3 = new DeliveryMan("May", "01234567890", "may@gmail.com");
        DeliveryMan man4 = new DeliveryMan("Zk", "01234567890", "john@gmail.com");
        DeliveryMan man5 = new DeliveryMan("HS", "01234567890", "alex@gmail.com");
        DeliveryMan man6 = new DeliveryMan("CW", "01234567890", "may@gmail.com");*/

        List<DeliveryMan> readFromFileList = null;
        /*List<DeliveryMan> deliveryManList = new ArrayList<>();
        deliveryManList.add(man1);
        deliveryManList.add(man2);
        deliveryManList.add(man3);
        deliveryManList.add(man4);
        deliveryManList.add(man5);
        deliveryManList.add(man6);
        
        System.out.println(man1.getDeliveryManId());*/

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
            JOptionPane.showMessageDialog(null, "Cannot read from main file", "ERROR", JOptionPane.ERROR_MESSAGE);
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
        DeliveryMan useToStoreListDeliveryMan;

        SimpleDateFormat forDate = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat forTime = new SimpleDateFormat("HH:mm:ss");

        //List<DeliveryManAttendance> attendanceList = new ArrayList<>();
        List<DeliveryManAttendance> attendanceListReadFromFile = null;

        List<DeliveryMan> deliveryManListReadFromFile = null;

        int choose, deliveryManIndex = 0;

        do {
            System.out.println("1. Clock In");
            System.out.println("2. Clock Out");
            System.out.println("3. Change delivery status");
            System.out.println("4. Logout");
            choose = scanner.nextInt();

            if (choose == 1) {
                attendanceListReadFromFile = readAttendanceFile();
                deliveryManListReadFromFile = readDeliveryManFile();

                deliveryManIndex = getDeliveryManIdex(deliveryManListReadFromFile, deliveryManDetail);

                boolean clockInAlready = checkForClockIn(attendanceListReadFromFile, deliveryManDetail);

                if (clockInAlready == false) {

                    attendance.setClockIn(new Date());
                    attendanceListReadFromFile.add(attendance);
                    writeAttendenceFile(attendanceListReadFromFile);

                    useToStoreListDeliveryMan = deliveryManListReadFromFile.get(deliveryManIndex);
                    useToStoreListDeliveryMan.setStatus("Available");
                    deliveryManListReadFromFile.set(deliveryManIndex, useToStoreListDeliveryMan);
                    writeDeliveryManFile(deliveryManListReadFromFile);
                    System.out.println("Clock In success. Clock in date is: " + forDate.format(attendance.getClockIn()) + " Clock in time" + forTime.format(attendance.getClockIn()) + "\n\n\n\n");
                } else {
                    System.out.println("Clock in already\n\n\n\n");
                }

            } else if (choose == 2) {
                attendanceListReadFromFile = readAttendanceFile();
                deliveryManListReadFromFile = readDeliveryManFile();

                int index = getAttendanceListIndex(attendanceListReadFromFile, deliveryManDetail);
                deliveryManIndex = getDeliveryManIdex(deliveryManListReadFromFile, deliveryManDetail);

                boolean clockInToday = checkForClockOut(attendanceListReadFromFile, deliveryManDetail);

                if (clockInToday == false) {
                    System.out.println("Clock out fail!\n\n\n\n");
                } else {
                    attendance = attendanceListReadFromFile.get(index);
                    attendance.setClockOut(new Date());
                    attendanceListReadFromFile.set(index, attendance);

                    useToStoreListDeliveryMan = deliveryManListReadFromFile.get(deliveryManIndex);
                    useToStoreListDeliveryMan.setStatus("Break");
                    deliveryManListReadFromFile.set(deliveryManIndex, useToStoreListDeliveryMan);
                    writeDeliveryManFile(deliveryManListReadFromFile);

                    System.out.println("Clock out success. Clock out date: " + forDate.format(attendance.getClockIn()) + "   Clock out time: " + forTime.format(attendance.getClockIn()) + "\n\n\n\n");
                    writeAttendenceFile(attendanceListReadFromFile);
                }
            } else if (choose == 3) {
                deliveryManListReadFromFile = readDeliveryManFile();
                deliveryManIndex = getDeliveryManIdex(deliveryManListReadFromFile, deliveryManDetail);
                attendanceListReadFromFile = readAttendanceFile();

                boolean clockOutAlready = false;

                for (int a = 0; a < attendanceListReadFromFile.size(); a++) {
                    if (attendanceListReadFromFile.get(a).getDeliveryMan().getDeliveryManId().equals(deliveryManDetail.getDeliveryManId()) && (attendanceListReadFromFile.get(a).getClockOut() !=null && forDate.format(attendanceListReadFromFile.get(a).getClockOut()).equals(forDate.format(new Date())))) {
                        //Today clock out already
                        clockOutAlready = true;
                        break;
                    }
                }

                System.out.println("Your status now is " + deliveryManDetail.getStatus());
                System.out.println("Change to:");
                System.out.println("1. Available");
                System.out.println("2. Delivery");
                System.out.println("3. Break");
                System.out.println("Please choose a number: ");
                int statusNum = scanner.nextInt();

                while (statusNum < 1 || statusNum > 3) {
                    System.out.println("Invalid status! Please choose again: ");
                    statusNum = scanner.nextInt();
                }

                if (statusNum == 1) {
                    setStatus(deliveryManIndex, deliveryManListReadFromFile, "Available");
                    System.out.println("Change status success");
                } else if (statusNum == 2) {
                    if (clockOutAlready == false) {
                        setStatus(deliveryManIndex, deliveryManListReadFromFile, "Delivery");
                        System.out.println("Change status success");
                    } else {
                        System.out.println("Change status fail! You clock out already");
                    }

                } else if (statusNum == 3) {
                    setStatus(deliveryManIndex, deliveryManListReadFromFile, "Break");
                    System.out.println("Change status success");
                }
            }
        } while (choose != 4);

        displayResult();
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
            JOptionPane.showMessageDialog(null, "Cannot read from attendance file", "ERROR", JOptionPane.ERROR_MESSAGE);
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

    public static List<DeliveryMan> readDeliveryManFile() {
        List<DeliveryMan> deliveryManListReadFromFile = new ArrayList<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("deliveryMan.dat"));
            deliveryManListReadFromFile = (List) oiStream.readObject();
            oiStream.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot read from delivery man file", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return deliveryManListReadFromFile;
    }

    public static void writeDeliveryManFile(List<DeliveryMan> deliveryManList) {
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("deliveryMan.dat"));
            ooStream.writeObject(deliveryManList);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot save to file", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static int getDeliveryManIdex(List<DeliveryMan> deliveryManListReadFromFile, DeliveryMan deliveryManDetail) {
        int deliveryManIndex = 0;
        for (int i = 0; i < deliveryManListReadFromFile.size(); i++) {
            if (deliveryManListReadFromFile.get(i).getDeliveryManId().equals(deliveryManDetail.getDeliveryManId())) {
                deliveryManIndex = i;
                break;
            }
        }
        return deliveryManIndex;
    }

    public static boolean checkForClockIn(List<DeliveryManAttendance> attendanceListReadFromFile, DeliveryMan deliveryManDetail) {
        boolean clockInAlready = false;
        SimpleDateFormat forDate = new SimpleDateFormat("yyyy/MM/dd");
        for (int a = 0; a < attendanceListReadFromFile.size(); a++) {
            if (attendanceListReadFromFile.get(a).getDeliveryMan().getDeliveryManId().equals(deliveryManDetail.getDeliveryManId()) && forDate.format(attendanceListReadFromFile.get(a).getClockIn()).equals(forDate.format(new Date()))) {
                clockInAlready = true;
                break;
            } else {
                clockInAlready = false;
            }
        }

        return clockInAlready;
    }

    public static int getAttendanceListIndex(List<DeliveryManAttendance> attendanceListReadFromFile, DeliveryMan deliveryManDetail) {
        int index = 0;
        SimpleDateFormat forDate = new SimpleDateFormat("yyyy/MM/dd");
        for (int a = 0; a < attendanceListReadFromFile.size(); a++) {
            if (attendanceListReadFromFile.get(a).getDeliveryMan().getDeliveryManId().equals(deliveryManDetail.getDeliveryManId()) && forDate.format(attendanceListReadFromFile.get(a).getClockIn()).equals(forDate.format(new Date()))) {
                index = a;
                break;
            }
        }
        return index;
    }

    public static boolean checkForClockOut(List<DeliveryManAttendance> attendanceListReadFromFile, DeliveryMan deliveryManDetail) {
        boolean clockInToday = false;
        SimpleDateFormat forDate = new SimpleDateFormat("yyyy/MM/dd");

        for (int a = 0; a < attendanceListReadFromFile.size(); a++) {
            //Today not clock out and the clock in data is today 
            if (attendanceListReadFromFile.get(a).getDeliveryMan().getDeliveryManId().equals(deliveryManDetail.getDeliveryManId()) && forDate.format(attendanceListReadFromFile.get(a).getClockIn()).equals(forDate.format(new Date())) && attendanceListReadFromFile.get(a).getClockOut() == null) {
                clockInToday = true;
                break;
            } else if (attendanceListReadFromFile.get(a).getDeliveryMan().getDeliveryManId().equals(deliveryManDetail.getDeliveryManId()) && attendanceListReadFromFile.get(a).getClockIn() == null) {
                //Today not clock in yet
                clockInToday = false;
            } else if (attendanceListReadFromFile.get(a).getDeliveryMan().getDeliveryManId().equals(deliveryManDetail.getDeliveryManId()) && attendanceListReadFromFile.get(a).getClockOut() != null) {
                //Today clock out already
                clockInToday = false;
            }
        }
        return clockInToday;
    }

    public static void setStatus(int deliveryManIndex, List<DeliveryMan> deliveryManListReadFromFile, String status) {
        DeliveryMan deliveryMan = deliveryManListReadFromFile.get(deliveryManIndex);
        deliveryMan.setStatus(status);
        deliveryManListReadFromFile.set(deliveryManIndex, deliveryMan);
        writeDeliveryManFile(deliveryManListReadFromFile);
    }

    public static void displayResult() {
        List<DeliveryManAttendance> attendanceListReadFromFile = readAttendanceFile();
        List<DeliveryMan> deliveryManListReadFromFile = readDeliveryManFile();
        for (int a = 0; a < attendanceListReadFromFile.size(); a++) {
            System.out.print("ID: " + attendanceListReadFromFile.get(a).getDeliveryMan().getDeliveryManId());
            System.out.print("      Clock In: " + attendanceListReadFromFile.get(a).getClockIn());
            System.out.println("       Clock Out: " + attendanceListReadFromFile.get(a).getClockOut());
        }
        System.out.println("\n\n");
        for (int i = 0; i < deliveryManListReadFromFile.size(); i++) {
            System.out.print("Delivery Man id: " + deliveryManListReadFromFile.get(i).getDeliveryManId());
            System.out.println("    Delivery Man status: " + deliveryManListReadFromFile.get(i).getStatus());
        }
    }
}
