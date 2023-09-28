package TMSPackage;

import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;

public class Driver {
    String driver_id;
    private String driver_name;
    private String driver_address;
    String driver_v_type;
    String driver_v_id;
    String driver_mobile;
    String driver_route;

    public static void Page(){      //print driver page name
        System.out.println("\t\t\tDriver Page");
        System.out.println("\t\t\t-----------");
    }

    public static void Make_driver(Driver d){
        Scanner str = new Scanner(System.in);
        System.out.print("\nEnter the Driver ID: ");
        d.driver_id = str.nextLine();
        System.out.print("Enter the Driver Name: ");
        d.driver_name = str.nextLine();
        System.out.print("Enter the Driver Adress: ");
        d.driver_address = str.nextLine();
        System.out.print("Enter the Vehicle Type: ");
        d.driver_v_type = str.nextLine();
        System.out.print("Enter the Vehicle ID: ");
        d.driver_v_id = str.nextLine();
        System.out.print("Enter the Driver mobile no: ");
        d.driver_mobile = str.nextLine();
        System.out.print("Enter the Driver Route ID: ");
        d.driver_route = str.nextLine();
    }

    public static void Display_driver(Driver d){
        System.out.println("\nDriver ID: " + d.driver_id);
        System.out.println("Driver Name: " + d.driver_name);
        System.out.println("Driver Adress: " + d.driver_address);
        System.out.println("Vehicle Type: " + d.driver_v_type);
        System.out.println("Vehicle ID: " + d.driver_v_id);
        System.out.println("Driver mobile no: " + d.driver_mobile);
        System.out.println("Driver Route: " + d.driver_route);
    }

    public static void Write_driver_file(Driver d) {
        String txt = "\n" + d.driver_id + " " + d.driver_name + " " + d.driver_address + " " + d.driver_v_type + " " + d.driver_v_id + " " + d.driver_mobile + " " + d.driver_route;
        try{
            FileWriter d_write = new FileWriter("Driver.txt",true);
            d_write.append(txt);
            d_write.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void printAll() {     //print all drivers details
        try {
            FileReader d_read = new FileReader("Driver.txt");
            int i;
            while ((i = d_read.read()) != -1){
                System.out.print((char)i);
            }
            System.out.println("\n----------------------------------------");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
