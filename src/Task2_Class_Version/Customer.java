package Task2_Class_Version;

import java.io.*;
import java.util.*;

public class Customer  extends FuelQueue  {
    // Scanner object to get input from user.
    public static Scanner UserInput = new Scanner(System.in);
    static FuelQueue f1 = new FuelQueue();


    public static void main(String[] args) throws IOException {
        // Removing data from the text file. So next time when program runs new data can be added without any
        // issues.

        // Writer class to perform writings on text file
        // Accessing the text file
        FileWriter fileWrite = new FileWriter("Task2_FuelCenter.txt", false);
        PrintWriter printFile = new PrintWriter(fileWrite, false);

        // Writing on text file
        printFile.flush(); // Flushing the steam
        printFile.close(); // Closing the file on print file class
        fileWrite.close(); // Closing the file on file write class

        String customer;
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
                storeDataFile(customers);

            // If admin enter 107 or LPD: Load Program Data from file. "loadDataFile" method will get call.
            else if (customer.equals("107") || customer.equals("LPD"))
                loadDataFile(customers);

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
        String vehicleNo;  // Temporarily stores vehicle number.
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

                // Reading customers vehicle number
                System.out.print("Enter customer's vehicle number: ");
                vehicleNo  = UserInput.nextLine();

                // Reading  required liters name
                System.out.print("Enter required liters for " + firstName + "'s Vehicle : ");
                liters  = UserInput.nextDouble();

                for(int i = 0; i < count.length; i++){
                    if (count[i] > count[pumpNo])
                        pumpNo = i;
                }
                // Endless loop to get valid input from admin
                // Handling errors if user enters any input rather than integer for pump number
                do{

                    // Getting customer's pump to wish.
                    try{
                        System.out.print("Enter the pump number,  customer wish to go : ");
                        pumpNo = UserInput.nextInt() - 1;
                        break;
                    }

                    // Display alert message if user enters value rather than integers
                    catch (InputMismatchException e){
                        System.out.println("Pump number can only be number.\nInteger Required.\n");
                        UserInput.nextLine();
                    }
                }while (true);

                for(int i = 0; i < customers[pumpNo].length; i++){
                    if (customers[pumpNo][i].getFilling().equals("e")){
                        customers[pumpNo][i].setFirstName(firstName);
                        customers[pumpNo][i].setSecondName(secondName);
                        customers[pumpNo][i].setLiter(liters);
                        customers[pumpNo][i].setVehicleNo(vehicleNo);
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
                        incomeQueue[pump_number] -= customers[pump_number][pos-1].getLiter();
                        for (int i = pos - 1 ;i < customers[pump_number].length; i++){
                            if (i != customers[pump_number].length-1){
                                customers[pump_number][i].setFirstName(customers[pump_number][pos].getFirstName());
                                customers[pump_number][i].setSecondName(customers[pump_number][pos].getSecondName());
                                customers[pump_number][i].setVehicleNo(customers[pump_number][pos].getVehicleNo());
                                customers[pump_number][i].setLiter(customers[pump_number][pos].getLiter());
                                if (customers[pump_number][i].getFirstName().equals("name"))
                                    customers[pump_number][i].setFilling("e");
                                pos++;
                            }
                        }
                        break;
                    }

                    // If the pump number is invalid then asking admin to enter valid pump number.
                    else
                        System.out.println("Invalid Pump number.");
                }

                customers[pump_number][5].fill();
            }

            // If the slot is empty. Showing slot is empty
            else
                System.out.println("There is no customer in that particular slot.");
        }

        // If the pump is empty displaying a message
        else
            System.out.println("There is no customer in pump no " + (pump_number+1));
        System.out.println("=".repeat(100));
        UserInput.nextLine();
    }

    public static void removeServed(FuelQueue[][] customers){
        int pump_number = 0;
        int pos = 1; // Variable to bring behind customers to front
        System.out.println("\n" + "-".repeat(60)+"\nRemoving served customer from queue selected.\n");

        System.out.println("Displaying all customers in the queue.\n");

        // Before removing the served customer from queue, displaying the queue details first.
        f1.viewQueue(customers);

        // Getting pump number of served customer.
        do{
            try{
                System.out.print("Enter the served customer's pump number : ");
                pump_number = UserInput.nextInt()-1;
                break;
            }
            // Display alert message if user enters value rather than integers
            catch (InputMismatchException e){
                System.out.println("Pump number can only be number.\nInteger Required.\n");
                UserInput.nextLine();
            }
        }while (true);

        if(pump_number <= 5 && pump_number >= 0){
            while (true){
                if (count[pump_number] != 6){
                    servedFuel += customers[pump_number][0].getLiter();
                    setFuelStock(getFuelStock() - customers[pump_number][0].getLiter());
                    servedCustomer_count ++;
                    servedCustomer += (servedCustomer_count) + ") " +
                            customers[pump_number][0].getFirstName() + "\n   Pump number - " + ( pump_number + 1) + "\n\n";
                    for(int i = 0; i < customers.length; i ++){
                        if (i < customers[pump_number].length-1){
                            customers[pump_number][i].setFirstName(customers[pump_number][pos].getFirstName());
                            customers[pump_number][i].setSecondName(customers[pump_number][pos].getSecondName());
                            customers[pump_number][i].setVehicleNo(customers[pump_number][pos].getVehicleNo());
                            customers[pump_number][i].setLiter(customers[pump_number][pos].getLiter());
                            if (customers[pump_number][i].getFirstName().equals("name"))
                                customers[pump_number][i].setFilling("e");
                            pos++;
                        }
                    }
                    customers[pump_number][5].fill();
                    // Displaying the customer got removed.
                    System.out.println("\nServed for the customer. Customer removed from the queue.");

                    // Displaying a message when fuel reaches 500 liters of stock and asking to refill or not.
                    if ( (6600 - getFuelStock()) % 500 == 0){
                        System.out.println("Fuel reached a value of 500 liters.");
                        f1.addFuel();
                    }

                    // Displaying remaining fuel.
                    else
                        System.out.println("Remaining fuel : " + getFuelStock() + " liters");

                    break;
                }

                // If admin enters invalid pump number displaying the message and asking to enter again.
                else{
                    System.out.println("There is no customer in pump no " + (pump_number+1));
                    break;
                }

            }
        }
        // Displaying message if there is no customer in selected pump.
        else
            System.out.println("Invalid Pump number.");
        System.out.println("=".repeat(100));
        UserInput.nextLine();
    }

    public static void sortedNames(FuelQueue[][] customers){
        System.out.println("\n" + "-".repeat(60)+"\nSorted customer names in the queues bellow.\n");

        // Declaring an array store ordered customer name.
        String[][] customer_sort = new String[5][6];

        // Copying the customer's name array to another array.
        for(int i = 0; i < customers.length; i ++){
            for(int j = 0; j < customers[i].length; j++){
                String fullName = customers[i][j].getFirstName() + " " + customers[i][j].getSecondName();
                customer_sort[i][j] = fullName;
            }
        }

        for(int i = 0; i < customer_sort.length; i++){
            for(int j = 0; j < customer_sort[i].length; j++){
                for (int k = j +1 ; k < customer_sort[i].length; k++){
                    if (!customer_sort[i][j].equals("name name")) {
                        if (customer_sort[i][j].compareTo(customer_sort[i][k]) > 0){
                            String tempName = customer_sort[i][j];
                            customer_sort[i][j] = customer_sort[i][k];
                            customer_sort[i][k] = tempName;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < customer_sort.length; i++){
            System.out.print("Fuel queue " + (i+1) + " : ");
            for(int j = 0; j < customer_sort[i].length; j++){
                if (!customer_sort[i][j].equals("name name"))
                    System.out.print(customer_sort[i][j] + " | ");
                else
                    System.out.print(" Available | ");
            }
            System.out.println();
        }

        System.out.println("=".repeat(100));
    }

    public static void storeDataFile( FuelQueue[][] customers) throws IOException {
        // String variable to store data which going to store inside the text file.
        String customerData_Container = "";
        int customer_count = 0;
        double totalFuel = 0;
        // Before storing displaying queue data to admin.
        f1.viewQueue(customers);

        customerData_Container += "FUEL CENTER - TASK 1\n====================\n\n";
        // Storing available fuel in string.
        customerData_Container += "Available fuel in stock : " + getFuelStock() + " liters\n";


        for(int i = 0; i < count.length; i++){
            customer_count += (6 - count[i]);
        }

        customerData_Container += "Served fuel in liters   : " + servedFuel + " liters\n";

        // Getting the count of customer count.
        customerData_Container += "Current customer count on the fuel center : " +
                customer_count + "\n\nCurrent fuel queue details : \n";

        for(int i = 0; i < customers.length; i++){
            customerData_Container += "Fuel pump " + (i + 1) + " : ";
            for(int j = 0; j < customers[i].length; j++){
                if (customers[i][j].getFilling().equals("e"))
                    customerData_Container += " Available | ";
                else
                    customerData_Container += customers[i][j].getFirstName() + " " + customers[i][j].getSecondName() + " | ";
            }
            customerData_Container +="\n";
        }
        for(int i = 0; i < incomeQueue.length; i++){ totalFuel += incomeQueue[i]; }
        customerData_Container += "\n\nIncome including current fuel queue \n---------------------------------------\n" +
                "Total Fuel : " + totalFuel + " liters";

        double totalCost = 0;
        for(int i = 0; i < incomeQueue.length; i++){
            customerData_Container += "\nFuel queue "+ (i+1) + " income :  " + incomeQueue[i] + " liters - " +  incomeQueue[i] * 420.0 ;
            totalCost += incomeQueue[i] * 420.0;
        }

        customerData_Container += "\nTotal income : " + totalCost + " \n---------------------------------------\n" ;

        for(int i = 0; i < count.length; i++){
            if (count[i] == 0)
                customerData_Container += "No slots available in pump no" + (i+1) + "\n";
            else
                customerData_Container += count[i] + " slot available in pump no " + (i+1) + "\n";
        }

        // Concatenating served customer count.
        servedCount = "Served customer count : " + servedCustomer_count + "\n";

        // Writer class to write on text file
        // Accessing the text file

        FileWriter fileWrite = new FileWriter("Task2_FuelCenter.txt");

        // Writing on text file.
        fileWrite.write(customerData_Container);
        fileWrite.write(servedCustomer);
        fileWrite.write((servedCount));
        // Committing the changes.
        fileWrite.close();

        // Displaying the text after data got saved.
        System.out.println("\n" + "-".repeat(60)+"\nData above stored in text file");
        System.out.println("=".repeat(100));
    };

    public static void loadDataFile( FuelQueue[][] customers){
        System.out.println("\n" + "-".repeat(60)+"\nLoaded data from text file\n");

        // Error handling if the admin forgets to create the text file.
        try{
            // File class to read the text file.
            // Accessing the text file.
            File readFile = new File("Task2_FuelCenter.txt");

            // Scanner object to read text file, line by line.
            Scanner scanFile = new Scanner(readFile);
            while (scanFile.hasNextLine())
                System.out.println(scanFile.nextLine());

            System.out.println("=".repeat(100));
        }

        // Exception if text not found
        catch (FileNotFoundException e){
            System.out.println("Cannot find the text file.\nCreate the text file and store data in it.");
        }
    };
}
