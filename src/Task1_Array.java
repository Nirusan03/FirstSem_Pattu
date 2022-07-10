// Importing java classes to do full the tasks
import java.io.*;
import java.util.*;

public class Task1_Array {

    // Declaring static methods to access everywhere.
    // Fuel stock count in liters.
    public static int fuelStock = 6600;

    // Scanner object to get input from user.
    public static Scanner UserInput = new Scanner(System.in);

    // Array to keep count of every vehicle in the fuel center's queue.
    public static int[] count = {0, 0, 0};

    // Storing served customers name inside a string variable to store in text file
    public static String servedCustomer = "\nServed Customers data\n---------------------\n";

    // Storing served customers count inside an integer variable to store in text file
    public static int servedCustomer_count = 0;

    // Storing served customers count inside a string variable to store in text file
    public static String servedCount = "";

    // Storing served fuel in liters inside an integer variable to store in text file
    public static int servedFuel = 0;


    public static void main(String[] args) throws IOException{

        // Array to store customer names of each queue.
        String[][] customer_queue = new String[3][6];

        // Variable to store admins option.
        String customer;

        // Calling initializing method to initialize array customer name array.
        initialise(customer_queue);


        // Removing data from the text file. So next time when program runs new data can be added without any
        // issues.

        // Writer class to perform writings on text file
        // Accessing the text file
        FileWriter fileWrite = new FileWriter("Task1_FuelCenter.txt", false);
        PrintWriter printFile = new PrintWriter(fileWrite, false);

        // Writing on text file
        printFile.flush(); // Flushing the steam
        printFile.close(); // Closing the file on print file class
        fileWrite.close(); // Closing the file on file write class

        // Endless loop to keep running code till admin enters to quit.
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
                    "999 or EXT: Exit the Program.\n\n" +
                    "Enter the number or characters to perform the task : ");

            // Storing the option entered by admin.
            customer = UserInput.nextLine().toUpperCase();
            // If admin enter 100 or VFQ: View all Fuel Queues. viewQueue method will get call.
            if (customer.equals("100") || customer.equals("VFQ"))
            {
                System.out.println("\n" + "-".repeat(60)+"\nDisplaying all customers in fuel queue.\n");
                viewQueue(customer_queue);
                System.out.println("=".repeat(100));
            }

            // If admin enter 101 or VEQ: View all Empty Queues. "emptyQueue" method will get call.
            else if (customer.equals("101") || customer.equals("VEQ"))
                emptyQueue (customer_queue);

            // If admin enter 102 or ACQ: Add customer to a Queue. "addCustomer" method will get call.
            else if (customer.equals("102") || customer.equals("ACQ"))
                addCustomer(customer_queue);

            // If admin enter 103 or RCQ: Remove a customer from a Queue. (From a specific location) "removeSpecific"
            // will get call.
            else if (customer.equals("103") || customer.equals("RCQ"))
                removeSpecific(customer_queue);

            // If admin enter 104 or PCQ: Remove a served customer. "removeServed" method will get call.
            else if (customer.equals("104") || customer.equals("PCQ"))
                removeServed(customer_queue);

            // If admin enter 105 or VCS: View Customers Sorted in alphabetical order. "sorted" method will get call.
            else if (customer.equals("105") || customer.equals("VCS"))
                sortedNames(customer_queue);

            // If admin enter 106 or SPD: Store Program Data into file. "storeDataFile" method will get call.
            else if (customer.equals("106") || customer.equals("SPD"))
                storeDataFile(customer_queue);

            // If admin enter 107 or LPD: Load Program Data from file. "loadDataFile" method will get call.
            else if (customer.equals("107") || customer.equals("LPD"))
                loadDataFile(customer_queue);

            // If admin enter 108 or STK: View Remaining Fuel Stock. "remainingFuel" method will get call.
            else if (customer.equals("108") || customer.equals("STK"))
                remainingFuel();

            //109 or AFS: Add Fuel Stock. "addFuel" method will get call.
            else if (customer.equals("109") || customer.equals("AFS")){
                System.out.println("\n" + "-".repeat(60)+"\nAdding fuel to stock option is selected.\n");
                addFuel();
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

    // Method to initialize the array.
    public static void initialise(String[][] customer_queue){
        for (int i = 0; i < customer_queue.length; i++){
            for (int j = 0; j < customer_queue[i].length; j++){
                customer_queue[i][j] = "e";
            }
        }
    }

    // Method to display customers in the queue - 100 or VFQ: View all Fuel Queues.
    public static void viewQueue(String[][] customer_queue){
        count = new int[]{0, 0, 0};
        for(int i = 0; i < customer_queue.length; i++){
            for (int j = 0; j < customer_queue[i].length; j++){

                // Displaying gasoline pump number.
                if (j == 0)
                    System.out.print("Gasoline Pump " + (i+1) + " : ");

                // If particular queue slot is empty, then it will show as "Available".
                if (customer_queue[i][j].equals("e")){
                    System.out.print("Available | ");
                    count[i]++;
                }

                // If the particular slot is filled, then it will show the customer name.
                else
                    System.out.print(customer_queue[i][j] + " | ");
            }
            System.out.println("\n");
        }

        // Loop to display overview summary of fuel center's vehicle count .
        for (int x  = 0; x < count.length; x++){
            if (count[x] == 0)
                System.out.println("No slots available in pump no" + (x+1) + "\n");
            else
                System.out.print(count[x] + " slots available in pump no" + (x+1) + "\n");
        }
    }

    //Method to display empty slots in queue - 101 or VEQ: View all Empty Queues.
    public static void emptyQueue(String[][] customer_queue){
        System.out.println("\n" + "-".repeat(60)+"\nEmpty slots of each queue.\n");

        // Variable to keep count of vehicle count.
        int count = 0;

        // Loop to display empty spaces in queue.
        for(int i = 0; i < customer_queue.length; i++){
            for (int j = 0; j < customer_queue[i].length; j++){
                if (j == 0)
                    System.out.print("Gasoline Pump " + (i+1) + " : ");
                if (customer_queue[i][j].equals("e")){
                    count++;
                    System.out.print("Available | ");
                    if (j == customer_queue[i].length-1){

                        // Displaying available slots.
                        System.out.print(count + " slots available.");
                        count = 0;
                    }
                }
            }
            System.out.println("\n");
        }

        System.out.println("=".repeat(100));
    }

    // Method to add customers on the queue - 102 or ACQ: Add customer to a Queue.
    public static void addCustomer(String[][] customer_queue){
        System.out.println("\n" + "-".repeat(60)+"\nAdding customer to queue.\n");

        // Declaring variables
        String name; // Temporarily stores customer name.
        int pumpNo;  // Temporarily store customer's pump number.

        // If there is no fuel in stock then alert message will be displayed.
        if (fuelStock == 0)
            System.out.println("Sorry there is no fuel in stock.\nAdd fuel please.");

        // If there is fuel then program will ask admin to enter customer name.
        else{
            // If fuel in stock is lower than or equal to 100 then program will ask admin to add fuel or not.
            if (fuelStock <= 100)
                    addFuel();

            // Display queue data before entering customer name.
            viewQueue(customer_queue);

            System.out.print("\nEnter customer's name : ");

            // Reading  customer name
            name  = UserInput.nextLine();

            // Changing customer name's first letter to string.
            name = Character.toUpperCase(name.charAt(0))+ name.substring(1);

            // Endless loop to get the proper input
            while (true){

                // Endless loop to get valid input from admin
                // Handling errors if user enters any input rather than integer for pump number
                do{

                    // Getting customer's pump to wish.
                    try{
                        System.out.print("Enter the pump number, " + name + " wish to go : ");
                        pumpNo = UserInput.nextInt() - 1;
                        break;
                    }

                    // Display alert message if user enters value rather than integers
                    catch (InputMismatchException e){
                        System.out.println("Pump number can only be number.\nInteger Required.\n");
                        UserInput.nextLine();
                    }
                }while (true);

                // If pump number is valid  then program will accept that.
                if (pumpNo >= 0 && pumpNo <= 2){

                    // If the particular queue is full then program will tell the admin to ask another pump number.
                    if (count[pumpNo] == 0)
                        System.out.println("Sorry, there is no space in pump " + pumpNo +
                                "'s queue");

                    // If there is space in queue then program will add customer name to array.
                    else{
                        for(int i = 0; i < customer_queue[pumpNo].length; i++){
                            if (customer_queue[pumpNo][i].equals("e")){
                                customer_queue[pumpNo][i] = name;
                                System.out.println("Customer added to the queue");
                                break;
                            }
                        }
                        break;
                    }
                }

                // If invalid pump numbers get entered then program will ask to enter again.
                else{
                    System.out.println("Invalid pump number.\n");
                }
            }
                UserInput.nextLine();
        }
        System.out.println("=".repeat(100));
    }

    // Method to remove a customer from queue - 103 or RCQ: Remove a customer from a Queue. (From a specific location).
    public static void removeSpecific(String[][] customer_queue) {
        System.out.println("\n" + "-".repeat(60)+"\nRemoving customer from queue selected.\n\n");
        System.out.println("Displaying all customers in the queue.");
        int pump_number = 0;
        int pos = 0;
        // Before removing the customer showing the queue details at first.
        viewQueue(customer_queue);

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


        // If the pump is not empty then program will ask for customer's queue slot number.
        if (count[pump_number] != 6)
        {

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
            if (!customer_queue[pump_number][pos-1].equals("e")){
                while (true) {
                    if (pump_number <= 2 && pump_number >= 0) {
                        for (int i = pos - 1; i < customer_queue[pump_number].length; i++) {
                            if (i != customer_queue[pump_number].length - 1) {
                                customer_queue[pump_number][i] = customer_queue[pump_number][pos];
                                pos++;
                            }
                        }
                        break;
                    }

                    // If the pump number is invalid then asking admin to enter valid pump number.
                    else
                        System.out.println("Invalid Pump number.");
                }

                // Displaying customer is removed from the queue
                System.out.println("Customer removed from the queue");
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

    // Method to remove served customer from queue - 104 or PCQ: Remove a served customer.
    public static void removeServed(String[][] customer_queue){
        int pump_number = 0;
        int pos = 1; // Variable to bring behind customers to front
        System.out.println("\n" + "-".repeat(60)+"\nRemoving served customer from queue selected.\n");

        System.out.println("Displaying all customers in the queue.\n");

        // Before removing the served customer from queue, displaying the queue details first.
        viewQueue(customer_queue);

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

        // If the pump is not empty the served customer will get removed.
        if (pump_number <= 2 && pump_number >=0){
            while (true){
                if (count[pump_number] != 6 ){
                    servedCustomer_count ++;
                    servedCustomer += (servedCustomer_count) + ") " +
                            customer_queue[pump_number][0] + "\n   Pump number - " + ( pump_number + 1) + "\n\n";
                    for(int i = 0 ; i < customer_queue[pump_number].length; i++){
                        if (i != customer_queue[pump_number].length-1){
                            customer_queue[pump_number][i] = customer_queue[pump_number][pos];
                            pos++;
                        }
                    }

                    // Displaying the customer got removed.
                    System.out.println("\nServed for the customer. Customer removed from the queue.");

                    // Deducting 10 liters from fuel stock.
                    fuelStock -= 10;
                    servedFuel += 10;
                    // Keep counting served customers


                    // Displaying a message when fuel reaches 500 liters of stock and asking to refill or not.
                    if ( (6600 - fuelStock) % 500 == 0){
                        System.out.println("Fuel reached a value of 500 liters.");
                        addFuel();
                    }

                    // Displaying remaining fuel.
                    else
                        System.out.println("Remaining fuel : " + fuelStock + " liters");
                    break;
                }

                // If admin enters invalid pump number displaying the message and asking to enter again.
                else
                    System.out.println("There is no customer in pump no " + (pump_number+1));
            }
        }

        // Displaying message if there is no customer in selected pump.
        else
            System.out.println("Invalid Pump number.");
        System.out.println("=".repeat(100));
        UserInput.nextLine();
    }

    // Method to display customers names in alphabetical order - 105 or VCS: View Customers Sorted in alphabetical order.
    public static void sortedNames(String[][] customer_queue){
        System.out.println("\n" + "-".repeat(60)+"\nSorted customer names in the queues bellow.\n");

        // Declaring an array store ordered customer name.
        String[][] customer_sort = new String[3][6];

        // Copying the customer's name array to another array.
        for(int i = 0; i < customer_queue.length; i++)
            for(int j = 0; j < customer_queue[i].length; j++)
                customer_sort[i][j] = customer_queue[i][j];

        // Bubble sort.
        // Sorting customer's name.
        for (int i = 0; i < customer_sort.length; i++){
            for (int j = 0; j < customer_sort[i].length; j++){
                for (int k = j + 1; k < customer_sort[i].length; k++){

                    // If the previous name is larger than next name by alphabetical order then, names will get swap
                    if (customer_sort[i][j].compareTo(customer_sort[i][k]) > 0){
                        String temp = customer_sort[i][j];
                        customer_sort[i][j] = customer_sort[i][k];
                        customer_sort[i][k] = temp;
                    }
                }
            }
        }

        // Displaying sorted customers name.
        for(int i = 0; i < customer_sort.length; i++) {
            for (int j = 0; j < customer_sort[i].length; j++) {
                if (j == 0)
                    System.out.print("Gasoline Pump " + (i + 1) + " : ");
                if (customer_sort[i][j].equals("e")) {
                    System.out.print("Available | ");
                } else
                    System.out.print(customer_sort[i][j] + " | ");
            }
            System.out.println();
        }

        System.out.println("=".repeat(100));
    }

    // Method to store data in text file - 106 or SPD: Store Program Data into file.
    public static void storeDataFile(String[][] customer_queue) throws IOException {

        // String variable to store data which going to store inside the text file.
        String customerData_Container = "";

        // Before storing displaying queue data to admin.
        viewQueue(customer_queue);

        customerData_Container += "FUEL CENTER - TASK 1\n====================\n\n";
        // Storing available fuel in string.
        customerData_Container += "Available fuel in stock : " + fuelStock + " liters\n";

        customerData_Container += "Served fuel in liters   : " + servedFuel + " liters\n";

        // Getting the count of customer count.
        int customer_count = 0;
        for(String[] names : customer_queue)
            for (String name: names){
                if (!name.equals("e"))
                    customer_count++;
            }

        // Storing customer count in string.
        customerData_Container += "Current customer count on Fuel center :  " + (customer_count) + "\n\n" +
                "Existing pump details : \n";
        for (int i = 0; i < customer_queue.length; i++){
            for (int j = 0; j < customer_queue[i].length; j++){

                // Storing pump number in string.
                if (j == 0)
                    customerData_Container += "Gasoline pump " + (i + 1) + " : ";

                // Storing available slots in string.
                if (customer_queue[i][j].equals("e")){
                    customerData_Container += "Available | ";
                }

                // Storing customer name in string.
                else
                    customerData_Container += customer_queue[i][j] + " | ";
            }
            customerData_Container += "\n";
        }
        customerData_Container += "\n";


        for(int x = 0; x < count.length; x++){

            // Storing overview summary in string.
            if (count[x] == 0)
                customerData_Container += "No slots available in pump no" + (x+1) + "\n";
            else
                customerData_Container += count[x] + " slots available in pump no" + (x+1) + "\n";
        }

        // Concatenating served customer count.
        servedCount = "Served customer count : " + servedCustomer_count + "\n";

        // Writer class to perform writings on text file.
        // Accessing the text file.
        FileWriter fileWrite = new FileWriter("Task1_FuelCenter.txt");

        // Writing on text file.
        fileWrite.write(customerData_Container);
        fileWrite.write(servedCustomer);
        fileWrite.write(servedCount);
        // Committing the changes.
        fileWrite.close();

        // Displaying the text after data got saved.
        System.out.println("\n" + "-".repeat(60)+"\nData above stored in text file");
        System.out.println("=".repeat(100));
    }

    // Method to display the data in text file :  107 or LPD: Load Program Data from file.
    public static void loadDataFile(String[][] customer_queue) throws IOException{
        System.out.println("\n" + "-".repeat(60)+"\nLoaded data from text file\n");

        // Error handling if the admin forgets to create the text file.
        try{
            // File class to read the text file.
            // Accessing the text file.
            File readFile = new File("Task1_FuelCenter.txt");

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
    }

    // Method to display remaining fuel in the stock -  108 or STK: View Remaining Fuel Stock.
    public static void remainingFuel(){
        System.out.println("\n" + "-".repeat(60)+"\nnDisplaying remaining fuel in stock.\n");
        System.out.println("Remaining fuel : " + fuelStock + " liters");
        System.out.println("=".repeat(100));
    }

    //Method to add refile the fuel in the stock - 109 or AFS: Add Fuel Stock.
    public static void addFuel(){
        String option = "";

        // Endless loop, break when user enter valid input.
        while (true){

            // If fuel in stock is lower than 100 asking admin to refill it or not.
            if (fuelStock <= 100){
                System.out.print("\nFuel stock is nearly empty.\nWould you like to add Stock again?" +
                        "\nEnter 'Y' to refill | Enter 'N' to not refill : ");
//                option = UserInput.nextLine().toUpperCase();
            }

            // If there is no fuel in stock asking admin to refill it or not.
            else if(fuelStock == 0){
                System.out.print("\nFuel stock is empty." +
                        "\nEnter 'Y' to refill | Enter 'N' to not refill : ");
//                option = UserInput.nextLine().toUpperCase();
            }

            // Asking admin to refill it or not.
            else{
                System.out.print("There are " + fuelStock + "l of fuel stock left.\nWould you like to add Stock again?" +
                        "?\nEnter 'Y' to refill | Enter 'N' to not refill : ");
//                option = UserInput.nextLine().toUpperCase();
            }

            // Reading admins input
            option = UserInput.nextLine().toUpperCase();

            // If the option is yes then refilling the fuel in stock
            if (option.equals("Y")){
                fuelStock = 6600;
                System.out.println("Fuel stock refiled.");
                break;
            }

            // If the option is no then doing nothing
            else if (option.equals("N")){
                System.out.println("Stock is same");
                break;
            }

            // If user enters invalid data then telling him to enter the data again.
            else
                System.out.println("Invalid option entered.\nTry again.\n");
        }
    }
}
