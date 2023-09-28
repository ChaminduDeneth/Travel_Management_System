package TMSPackage;

import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;

public class Route {
    String route_id;
    String route_name;

    public static void Page(){      //print route page name
        System.out.println("\t\t\tRoute Page");
        System.out.println("\t\t\t----------");
    }

    public static void Make_route(Route r){
        Scanner str = new Scanner(System.in);
        System.out.print("\nEnter the Route ID: ");
        r.route_id = str.nextLine();
        System.out.print("Enter the Route Name: ");
        r.route_name = str.nextLine();
    }

    public static void Display_route(Route r){
        System.out.println("Route ID: " + r.route_id);
        System.out.println("Route Name: " + r.route_name);
    }

    public static void Write_route_file(Route r) {
        String txt = "\n" + r.route_id + " " + r.route_name;
        try{
            FileWriter r_write = new FileWriter("Route.txt",true);
            r_write.append(txt);
            r_write.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void printAll() {     //print all routes details
        try {
            FileReader r_read = new FileReader("Route.txt");
            int i;
            while ((i = r_read.read()) != -1){
                System.out.print((char)i);
            }
            System.out.println("\n----------------------------------------");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
