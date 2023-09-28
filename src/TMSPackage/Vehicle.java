package TMSPackage;

import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;

public class Vehicle {
    String vehicle_id;
    String vehicle_type;
    String V_driver_name;

    public static void Page(){      //print vehicle page name
        System.out.println("\t\t\tVehicle Page");
        System.out.println("\t\t\t------------");
    }

    public static void Make_vehicle(Vehicle v){
        Scanner str = new Scanner(System.in);
        System.out.print("\nEnter the Vehicle ID: ");
        v.vehicle_id = str.nextLine();
        System.out.print("Enter the Vehicle Type: ");
        v.vehicle_type = str.nextLine();
        System.out.print("Enter the Driver Name: ");
        v.V_driver_name = str.nextLine();

    }

    public static void Display_vehicle(Vehicle v){
        System.out.println("Vehicle ID: " + v.vehicle_id);
        System.out.println("Vehicle Type: " + v.vehicle_type);
        System.out.println("Driver Name: " + v.V_driver_name);
    }

    public static void Write_vehicle_file(Vehicle v) {
        String txt = "\n" + v.vehicle_id + " " + v.vehicle_type + " " + v.V_driver_name;
        try{
            FileWriter v_write = new FileWriter("Vehicle.txt",true);
            v_write.append(txt);
            v_write.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void printAll() {     //print all vehicles details
        try {
            FileReader v_read = new FileReader("Vehicle.txt");
            int i;
            while ((i = v_read.read()) != -1){
                System.out.print((char)i);
            }
            System.out.println("\n----------------------------------------");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

class car extends Vehicle{
    int num_seat;
    String AC_status;   //A/C has or not
}

class Heavy_Vehicle extends Vehicle{
    int num_tyre;
    int num_seat;
}
