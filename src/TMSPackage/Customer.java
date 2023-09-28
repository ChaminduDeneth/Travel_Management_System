package TMSPackage;

import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;

public class Customer {
    String customer_id;
    private String customer_name;    //Using Encapsulation concept
    private String customer_address; //Number,Village, City, District
    String customer_email;
    String customer_mobile;
    String customer_regdate; //Customer registered date.
    //private String cus_password;    //private String cus_password;

    public static void Page(){      //print customer page name
        System.out.println("\t\t\tCustomer Page");
        System.out.println("\t\t\t-------------");
    }

    public static void Make_customer(Customer c){
        Scanner str = new Scanner(System.in);
        System.out.print("\nEnter the customer ID: ");
        c.customer_id = str.nextLine();
        System.out.print("Enter the customer name: ");
        c.customer_name = str.nextLine();
        System.out.print("Enter the customer address: ");
        c.customer_address = str.nextLine();
        System.out.print("Enter the mobile number: ");
        c.customer_mobile = str.nextLine();
        System.out.print("Enter the customer email: ");
        c.customer_email = str.nextLine();
        System.out.print("Enter the date: ");
        c.customer_regdate = str.nextLine();
    }

    public static void Display_customer(Customer c){
        System.out.println("Customer ID: " + c.customer_id);
        System.out.println("Customer Name: " + c.customer_name);
        System.out.println("Customer Address: " + c.customer_address);
        System.out.println("Customer Mobile: " + c.customer_mobile);
        System.out.println("Customer Email: " + c.customer_email);
        System.out.println("Customer Registered Date: " + c.customer_regdate);
    }

    public static void Write_customer_file(Customer c) {
        String txt = "\n" + c.customer_id + " " + c.customer_name + " " + c.customer_address + " " + c.customer_mobile + " " + c.customer_email + " " + c.customer_regdate;
        try{
            FileWriter c_write = new FileWriter("Customer.txt",true);
            c_write.append(txt);
            c_write.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void printAll() {     //print all customers details
        try {
            FileReader c_read = new FileReader("Customer.txt");
            int i;
            while ((i = c_read.read()) != -1){
                System.out.print((char)i);
            }
            System.out.println("\n----------------------------------------");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

