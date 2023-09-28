import java.util.Scanner;
import java.lang.String;
import java.lang.System;

import TMSPackage.Customer;
import TMSPackage.Driver;
import TMSPackage.Vehicle;
import TMSPackage.Route;
import TMSPackage.Booking;

public class TMSMain {
    static Scanner MScan = new Scanner(System.in);

    public static void main(String[] args) {
        Start();    //Starting the program
    }

    public static void TMS(){       //To print application name
        System.out.println("----------------------------------------");
        System.out.println("\t\tTravel Management System.");
        System.out.println("----------------------------------------");
    }

    private static void Start() {
        TMS();
        System.out.println("\nChoose(Type the number)?");
        System.out.println("    1.Customer Page.");
        System.out.println("    2.Driver Page.");
        System.out.println("    3.Booking Page.");
        System.out.println("    4.Route Page.");
        System.out.println("    5.Vehicle Page.");
        System.out.println("    6.Admin.");
        System.out.println("    9.Exit program.");
        System.out.print("\nEnter the number: ");
        char n = MScan.next().charAt(0);
        switch (n) {
            case '1':
                Main_customer();
                Start();
            case '2':
                Main_driver();
                Start();
            case '3':
                Main_booking();
                Start();
            case '4':
                Main_route();
                Start();
            case '5':
                Main_vehicle();
                Start();
            case '6':
                //Admin_login();    //For login to admin
                Admin();
                Start();
            case '9':
                TMS();
                System.out.println("\n\n\t\t\tThank you....!\n\n");
                System.out.println("----------------------------------------");
                System.exit(0);
            default:
                System.out.println("\nEntered a wrong number....!");
                Start();
        }
    }

/*    private static void Admin_login() {
        TMS();
        System.out.println("\t\tAdmin");
        System.out.println("\t\t-----");
        System.out.println("\nChoose(Type the number):");
        System.out.println("    1.Log in admin.");
        System.out.println("    0.Main menu.");
        System.out.print("\nEnter the number: ");
        int n = MScan.nextInt();

        switch (n) {
            case 0:
                Start();
            case 1:
                String Apass = null;
                String Auname;
                do {
                    TMS();
                    System.out.println("\t\t\tAdmin");
                    System.out.println("\t\t-----");

                    System.out.print("Enter admin username: ");
                    Auname = MScan.nextLine();

                    if (Auname == "Admin") {
                        System.out.print("Enter the password: ");
                        Apass = MScan.nextLine();
                        if (Apass == "Admin") {     //After username and password checked, Then do admin works
                            Admin();    //Called to admin method
                        } else {
                            Admin_login();
                        }
                    } else {
                        Admin_login();
                    }
                    Admin_login();
                } while (Apass != "Admin") ;
            default:
                System.out.println("Entered wrong number....!");
                Admin_login();
        }
    }
 */

    private static void Admin() {
        TMS();
        System.out.println("\nWhat you want(Type the number)?");
        System.out.println("    1.Check all cutomer details.");
        System.out.println("    2.check all drivers details.");
        System.out.println("    3.check all vehicles details.");
        System.out.println("    4.check all bookings details.");
        System.out.println("    5.check all routes details.");
        System.out.println("    6.Add a New Route.");
        System.out.println("    0.Main menu.");
        System.out.print("\nEnter the number: ");
        char n = MScan.next().charAt(0);
        switch (n){
            case '0':
                Start();
            case '1':
                TMS();
                Customer.printAll();
                Admin();
            case '2':
                TMS();
                Driver.printAll();
                Admin();
            case '3':
                TMS();
                Vehicle.printAll();
                Admin();
            case '4':
                TMS();
                Booking.printAll();
                Admin();
            case '5':
                TMS();
                Route.printAll();
                Admin();
            case '6':
                TMS();
                Route r = new Route();
                Route.Make_route(r);
                TMS();
                Route.Page();
                Route.Display_route(r);
                char ans;
                do{
                    System.out.println("\nEntered values are correct(Y/N)?"); //Check entered values are correct
                    ans = MScan.next().charAt(0);
                    if (ans == 'N') {
                        TMS();
                        Route.Page();
                        Route.Make_route(r);
                        TMS();
                        Route.Page();
                        Route.Display_route(r);
                    }
                }while (ans != 'Y');
                Route.Write_route_file(r);
                Admin();
            default:
                Admin();
        }
    }

    private static void Main_vehicle() {
        TMS();
        Vehicle.Page();
        Vehicle v = new Vehicle();
        System.out.println("\nWhat you want(Type the number)?");
        System.out.println("    1.Check the Vehicles details.");
        System.out.println("    2.Add a New Vahicle.");
        System.out.println("    0.Main menu.");
        System.out.print("\nEnter the number: ");
        char n = MScan.next().charAt(0);
        switch (n) {
            case '0':
                Start();
            case '1':
                TMS();
                Vehicle.printAll();
                Main_vehicle();
            case '2':
                TMS();
                Vehicle.Page();
                Vehicle.Make_vehicle(v);
                TMS();
                Vehicle.Page();
                Vehicle.Display_vehicle(v);
                char ans;
                do{
                    System.out.println("\nEntered values are correct(Y/N)?"); //Check entered values are correct
                    ans = MScan.next().charAt(0);
                    if (ans == 'N') {
                        TMS();
                        Vehicle.Page();
                        Vehicle.Make_vehicle(v);
                        TMS();
                        Vehicle.Page();
                        Vehicle.Display_vehicle(v);
                    }
                }while (ans != 'Y');
                Vehicle.Write_vehicle_file(v);
                Main_vehicle();
            default:
                System.out.println("\nEntered a wrong number....!");
                Main_vehicle();
        }
    }

    private static void Main_route() {
        TMS();
        Route.Page();
        //Route r = new Route();
        System.out.println("\nWhat you want(Type the number)?");
        System.out.println("    1.Check the Routes details.");
        System.out.println("    2.Bookings details.");
        System.out.println("    0.Main menu.");
        System.out.print("\nEnter the number: ");
        char n = MScan.next().charAt(0);
        switch (n) {
            case '0':
                Start();
            case '1':
                TMS();
                Route.printAll();
                Main_route();
            case '2':
                TMS();
                Booking.printAll();
                Main_route();
            default:
                System.out.println("\nEntered a wrong number....!");
                Main_route();
        }
    }

    private static void Main_booking() {
        TMS();
        Booking.Page();
        Booking b = new Booking();
        System.out.println("\nWhat you want(Type the number)?");
        System.out.println("    1.Check bookings details.");
        System.out.println("    2.Add a New booking.");
        System.out.println("    3.Customers details.");
        System.out.println("    0.Main menu.");
        System.out.print("\nEnter the number: ");
        char n = MScan.next().charAt(0);
        switch (n) {
            case '0':
                Start();
            case '1':
                TMS();
                Booking.printAll();
                Main_booking();
            case '2':
                TMS();
                Booking.Page();
                Booking.Make_booking(b);
                TMS();
                Booking.Page();
                Booking.Display_booking(b);
                char ans;
                do{
                    System.out.println("\nEntered values are correct(Y/N)?"); //Check entered values are correct
                    ans = MScan.next().charAt(0);
                    if (ans == 'N') {
                        TMS();
                        Booking.Page();
                        Booking.Make_booking(b);
                        TMS();
                        Booking.Page();
                        Booking.Display_booking(b);
                    }
                }while (ans != 'Y');
                Booking.Write_booking_file(b);
                Main_booking();
            case '3':
                TMS();
                Customer.printAll();
                Main_booking();
            default:
                System.out.println("\nEntered a wrong number....!");
                Main_booking();
        }
    }

    private static void Main_driver() {
        TMS();
        Driver.Page();
        Driver d = new Driver();
        System.out.println("\nWhat you want(Type the number)?");
        System.out.println("    1.Check driver details.");
        System.out.println("    2.Add a New driver.");
        System.out.println("    3.Vehicles details.");
        System.out.println("    4.Bookings details.");
        System.out.println("    5.Routes details.");
        System.out.println("    0.Main menu.");
        System.out.print("\nEnter the number: ");
        char n = MScan.next().charAt(0);
        switch (n) {
            case '0':
                Start();
            case '1':
                TMS();
                Driver.printAll();
                Main_driver();
            case '2':
                TMS();
                Driver.Page();
                Driver.Make_driver(d);
                TMS();
                Driver.Page();
                Driver.Display_driver(d);
                char ans;
                do{
                    System.out.println("\nEntered values are correct(Y/N)?"); //Check entered values are correct
                    ans = MScan.next().charAt(0);
                    if (ans == 'N') {
                        TMS();
                        Driver.Page();
                        Driver.Make_driver(d);
                        TMS();
                        Driver.Page();
                        Driver.Display_driver(d);
                    }
                }while (ans != 'Y');
                Driver.Write_driver_file(d);
                Main_driver();
            case '3':
                TMS();
                Vehicle.printAll();
                Main_driver();
            case '4':
                TMS();
                Booking.printAll();
                Main_driver();
            case '5':
                TMS();
                Route.printAll();
                Main_driver();
            default:
                System.out.println("\nEntered a wrong number....!");
                Main_driver();
        }
    }

    private static void Main_customer() {
        TMS();
        Customer.Page();
        Customer c = new Customer();
        System.out.println("\nWhat you wan(Type the number)?");
        System.out.println("    1.Check customers details.");
        System.out.println("    2.Add a New Customer.");
        System.out.println("    3.Routes details.");
        System.out.println("    4.Bookings details.");
        System.out.println("    0.Main menu.");
        System.out.print("\nEnter the number: ");
        char n = MScan.next().charAt(0);
        switch (n) {
            case '0':
                Start();
            case '1':
                Customer.printAll();
                Main_customer();
            case '2':
                TMS();
                Customer.Page();
                Customer.Make_customer(c);
                TMS();
                Customer.Page();
                Customer.Display_customer(c);
                char ans;
                do{
                    System.out.println("\nEntered values are correct(Y/N)?"); //Check entered values are correct
                    ans = MScan.next().charAt(0);
                    if (ans == 'N') {
                        TMS();
                        Customer.Page();
                        Customer.Make_customer(c);
                        TMS();
                        Customer.Page();
                        Customer.Display_customer(c);
                    }
                }while (ans != 'Y');
                Customer.Write_customer_file(c);
                Main_customer();
            case '3':
                TMS();
                Route.printAll();
                Main_customer();
            case '4':
                TMS();
                Booking.printAll();
                Main_customer();
            default:
                System.out.println("\nEntered a wrong number....!");
                Main_customer();
        }
    }
}
