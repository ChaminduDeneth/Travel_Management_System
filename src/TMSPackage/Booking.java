package TMSPackage;

import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;

public class Booking {
    String booking_id;
    String booking_cus_name;
    String booking_pick;
    String booking_regdate;
    String booking_cus_mobile;

    public static void Page(){      //print booking page name
        System.out.println("\t\t\tBooking Page");
        System.out.println("\t\t\t------------");
    }

    public static void Make_booking(Booking b){
        Scanner str = new Scanner(System.in);
        System.out.print("\nEnter the booking ID: ");
        b.booking_id = str.nextLine();
        System.out.print("Enter the customer name: ");
        b.booking_cus_name = str.nextLine();
        System.out.print("Enter the customer mobile: ");
        b.booking_cus_mobile = str.nextLine();
        System.out.print("Enter the pickup place: ");
        b.booking_pick = str.nextLine();
        System.out.print("Enter the booking regdate: ");
        b.booking_regdate = str.nextLine();
    }

    public static void Display_booking(Booking b){
        System.out.println("Booking ID: " + b.booking_id);
        System.out.println("Booking Customer Name: " + b.booking_cus_name);
        System.out.println("Pickup Place: " + b.booking_pick);
        System.out.println("Customer Mobile: " + b.booking_cus_mobile);
        System.out.println("Booking Registered Date: " + b.booking_regdate);
    }

    public static void Write_booking_file(Booking b) {
        String txt = "\n" + b.booking_id + " " + b.booking_cus_name + " " + b.booking_cus_mobile + " " + b.booking_pick + " " + b.booking_regdate;
        try{
            FileWriter b_write = new FileWriter("Booking.txt",true);
            b_write.append(txt);
            b_write.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void printAll() {     //print all bookings details
        try {
            FileReader b_read = new FileReader("Booking.txt");
            int i;
            while ((i = b_read.read()) != -1){
                System.out.print((char)i);
            }
            System.out.println("\n----------------------------------------");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
