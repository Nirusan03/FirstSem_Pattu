package Advance_class_version;

import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer extends FuelQueue {
    // Scanner object to get input from user.
    public static Scanner UserInput = new Scanner(System.in);
    static FuelQueue f1 = new FuelQueue();
    public static void main(String[] args) {
        String customer;
//        FuelQueue f1 = new FuelQueue();
        f1.initialise(customers);
        while (true){

            // Display menu.
            System.out.print("\n\nFuel center administration to, \n\n" +
                    "100 or VFQ: View all Fuel Queues.\n" +
                    "101 or VEQ: View all Empty Queues.\n" +
                    "102 or ACQ: Add customer to a Queue.\n" +
                    "103 or RCQ: Remove a customer from a Queue.\n" +
                    "104 or PCQ: Remove a served customer.\n" +
                    "105 or VCS: View Customers Sorted in alphabetical order.\n" +
                    "106 or SPD: Store Program Data into file.\n" +
                    "107 or LPD: Load Program Data from file.\n" +
                    "108 or STK: View Remaining Fuel Stock.\n" +
                    "109 or AFS: Add Fuel Stock.\n" +
                    "110 or IFQ: View income of each fuel queue\n"+
                    "999 or EXT: Exit the Program.\n\n" +
                    "Enter the number or characters to perform the task : ");

            // Storing the option entered by admin.
            customer = UserInput.nextLine().toUpperCase();
            // If admin enter 100 or VFQ: View all Fuel Queues. viewQueue method will get call.
            if (customer.equals("100") || customer.equals("VFQ"))
            {
                System.out.println("\n" + "-".repeat(60)+"\nDisplaying all customers in fuel queue.\n");
                f1.viewQueue(customers);
                System.out.println("=".repeat(100));
            }

            // If admin enter 101 or VEQ: View all Empty Queues. "emptyQueue" method will get call.
            else if (customer.equals("101") || customer.equals("VEQ"))
                f1.emptyQueue (customers);

            // If admin enter 102 or ACQ: Add customer to a Queue. "addCustomer" method will get call.
            else if (customer.equals("102") || customer.equals("ACQ"))
                addCustomer(customers);

            // If admin enter 103 or RCQ: Remove a customer from a Queue. (From a specific location) "removeSpecific"
            // will get call.
            else if (customer.equals("103") || customer.equals("RCQ"))
                removeSpecific(customers);

            // If admin enter 104 or PCQ: Remove a served customer. "removeServed" method will get call.
            else if (customer.equals("104") || customer.equals("PCQ"))
                removeServed(customers);

            // If admin enter 105 or VCS: View Customers Sorted in alphabetical order. "sorted" method will get call.
            else if (customer.equals("105") || customer.equals("VCS"))
                sortedNames(customers);

            // If admin enter 106 or SPD: Store Program Data into file. "storeDataFile" method will get call.
            else if (customer.equals("106") || customer.equals("SPD"))
                f1.storeDataFile(customers);

            // If admin enter 107 or LPD: Load Program Data from file. "loadDataFile" method will get call.
            else if (customer.equals("107") || customer.equals("LPD"))
                f1.loadDataFile(customers);

            // If admin enter 108 or STK: View Remaining Fuel Stock. "remainingFuel" method will get call.
            else if (customer.equals("108") || customer.equals("STK"))
                f1.remainingFuel();

            //109 or AFS: Add Fuel Stock. "addFuel" method will get call.
            else if (customer.equals("109") || customer.equals("AFS")){
                System.out.println("\n" + "-".repeat(60)+"\nAdding fuel to stock option is selected.\n");
                f1.addFuel();
                System.out.println("=".repeat(100));
            }

            //109 or AFS: Add Fuel Stock. "addFuel" method will get call.
            else if (customer.equals("110") || customer.equals("IFQ")){
                f1.fuelQueueIncome(customers);
                System.out.println("=".repeat(100));
            }


            // If admin enter999 or EXT: Exit the Program. The program will get quite
            else if (customer.equals("999") || customer.equals("EXT"))
            {
                System.out.println("\n" + "-".repeat(60)+"\nThe program is ended.");
                System.out.println("=".repeat(15) + "\n|| THANK YOU ||\n" + "=".repeat(15));
                break;
            }


            // If admin enters invalid option. The message bellow and ask to enter the option again.
            else
                System.out.println("\nInvalid option selected.\nTry again." + "\n" + "-".repeat(60));
        }
    }

    public static void addCustomer(FuelQueue[][] customers){
        System.out.println("\n" + "-".repeat(60)+"\nAdding customer to queue.\n");
        System.out.println(getFuelStock() + " : fuel stock");

        // Declaring variables
        String firstName; // Temporarily stores customer first name.
        String secondName; // Temporarily stores customer second name.

        double liters; // Temporarily stores required liters.
        int pumpNo = 0;  // Temporarily store customer's pump number.

        // If there is no fuel in stock then alert message will be displayed.
        if (getFuelStock() == 0)
            System.out.println("Sorry there is no fuel in stock.\nAdd fuel please.");

            // If there is fuel then program will ask admin to enter customer name.
        else{
            // If fuel in stock is lower than or equal to 100 then program will ask admin to add fuel or not.
            if (getFuelStock() <= 100)
                f1.addFuel();

            // Display queue data before entering customer name.
            f1.viewQueue(customers);
            if (count[0] == 0 && count[1] == 0 && count[2] == 0 && count[3] == 0 && count[4] == 0)
                System.out.println("Sorry fuel center is full.\n");
            else{

                // Reading  customer first name
                System.out.print("\nEnter customer's first name : ");
                firstName  = UserInput.nextLine();
                // Changing customer name's first letter to string.
                firstName = Character.toUpperCase(firstName.charAt(0))+ firstName.substring(1);

                // Reading  customer second name
                System.out.print("Enter customer's second name : ");
                secondName  = UserInput.nextLine();
                // Changing customer name's second letter to string.
                secondName = Character.toUpperCase(secondName.charAt(0))+ secondName.substring(1);

                // Reading  required liters name
                System.out.print("Enter required liters for " + firstName + "'s Vehicle : ");
                liters  = UserInput.nextDouble();

                for(int i = 0; i < count.length; i++){
                    if (count[i] > count[pumpNo])
                        pumpNo = i;
                }

                for(int i = 0; i < customers[pumpNo].length; i++){
                    if (customers[pumpNo][i].getFilling().equals("e")){
                        customers[pumpNo][i].setFirstName(firstName);
                        customers[pumpNo][i].setSecondName(secondName);
                        customers[pumpNo][i].setLiter(liters);
                        customers[pumpNo][i].setFilling("Filled");
                        incomeQueue[pumpNo] += liters;
                        System.out.println("Customer added to the queue");
                        break;
                    }
                }
            }

            UserInput.nextLine();
        }
        System.out.println("=".repeat(100));
    }

    public static void removeSpecific(FuelQueue[][] customers){
        System.out.println("\n" + "-".repeat(60) + "\nRemoving Specific Customer from queue selected.\n\n");
        System.out.println("Displaying all customers in the queue");
        int pump_number = 0;
        int pos = 0;

        // Before removing the customer showing the queue details at first.
        f1.viewQueue(customers);

        // Endless loop to get valid input from admin
        do{

            // Storing customer's pump number to remove from the queue.
            try{
                System.out.print("\nEnter the customer's pump number to remove : ");
                pump_number = UserInput.nextInt() - 1;
                break;
            }

            // Display alert message if user enters value rather than integers
            catch (InputMismatchException e){
                System.out.println("Pump number can only be number.\nInteger Required.\n");
                UserInput.nextLine();
            }
        }while(true);

        if(count[pump_number] != 6){
            // Endless loop to get valid input from admin
            do{
                // Storing customer's position number to remove from the queue.
                try{
                    System.out.print("Enter the customer's queue position number : ");
                    pos = UserInput.nextInt();
                    break;
                }

                // Display alert message if user enters value rather than integers
                catch (InputMismatchException e){
                    System.out.println("Queue position can only be number.\nInteger Required.\n");
                    UserInput.nextLine();
                }
            }while (true);

            // If the slot is not empty then removing the customer from the queue and filling the empty slot
            // with behind customers.
            if (!customers[pump_number][pos-1].getFilling().equals("e")){
                while (true){
                    if (pump_number <= 5 && pump_number >= 0 ){
                        for (int i = pos - 1 ;i < customers[pump_number].length; i++){
                            if (i != customers[pump_number].length-1){
                                customers[pump_number][i].setFirstName(customers[pump_number][pos].getFirstName());
                                customers[pump_number][i].setSecondName(customers[pump_number][pos].getSecondName());
                                customers[pump_number][i].setLiter(customers[pump_number][pos].getLiter());
                            }
                        }
                    }
                }
            }
        }
    }

    public static void removeServed(FuelQueue[][] customers){

    }

    public static void sortedNames(FuelQueue[][] customers){

    }
}
