package Task3_Class_Queue_Version;

import java.util.Arrays;
import java.util.Scanner;

public class FuelQueue extends abstraction {

    public static int[] count = {0, 0, 0, 0, 0};
    public static double[] incomeQueue = {0, 0, 0, 0, 0};
    private static double fuelStock = 6600;
    private String firstName;
    private String secondName;
    private String vehicleNo;
    private double liter;
    private String filling;

    private int rear = -2;

    private int font = -2;

    private final String[] waitingCustomerQueue = new String[150];
    static FuelQueue[][] customers = new FuelQueue[5][6];
//    static

    // Storing served customers name inside a string variable to store in text file
    public static String servedCustomer = "\nServed Customers data\n---------------------\n";

    // Storing served customers count inside an integer variable to store in text file
    public static int servedCustomer_count = 0;

    // Storing served customers count inside a string variable to store in text file
    public static String servedCount = "";

    // Storing served fuel in liters inside an integer variable to store in text file
    public static int servedFuel = 0;


    public static double getFuelStock() {
        return fuelStock;
    }

    public static void setFuelStock(double fuelStock) {
        FuelQueue.fuelStock = fuelStock;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public double getLiter() {
        return liter;
    }

    public void setLiter(double liter) {
        this.liter = liter;
    }
    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }


    public void fill(){
        filling = "e";
        firstName = "name";
        secondName = "name";
        vehicleNo = "vehicleNo";
        liter = 0;
    }

    public void initialise(FuelQueue[][] customers){
        for(int i = 0; i < customers.length; i++){
            for(int j = 0; j < customers[i].length; j++){
                customers[i][j] = new FuelQueue();
                customers[i][j].fill();
            }
        }
    }

    public void viewQueue(FuelQueue[][] customers){
        count = new int[]{0, 0, 0, 0, 0};
        for(int i = 0; i < customers.length; i++){
            System.out.print("Fuel Pump no " + (i+1) + " : ");
            for (int j = 0; j < customers[i].length; j++){
                if (customers[i][j].getFilling().equals("e")){
                    System.out.print(" Available | ");
                    count[i]++;
                }

                else
                    System.out.print(customers[i][j].getFirstName() + " " + customers[i][j].getSecondName() + " | ");
            }
            System.out.println();
        }

        // Loop to display overview summary of fuel center's vehicle count .
        for (int x  = 0; x < count.length; x++){
            if (count[x] == 0)
                System.out.println("No slots available in pump no" + (x+1) + "\n");
            else
                System.out.print(count[x] + " slots available in pump no" + (x+1) + "\n");
        }
    }

    public void emptyQueue(FuelQueue[][] customers){
        System.out.println("\n" + "-".repeat(60)+"\nEmpty slots of each queue.\n");

        // Variable to keep count of vehicle count.
        int counts = 0;

        // Loop to display empty spaces in queue.
        for(int i = 0; i <  customers.length; i++){
            for(int j = 0; j < customers[i].length; j++){
                if (j == 0)
                    System.out.print("Gasoline Pump " + (i+1) + " : ");
                if (customers[i][j].getFilling().equals("e")){
                    counts++;
                    System.out.print("Available | ");
                    if (j == customers[i].length-1){
                        System.out.print(counts + " slots available.");
                        counts = 0;
                    }
                }
            }
            System.out.println();
        }
        // Loop to display overview summary of fuel center's vehicle count .
        for (int x  = 0; x < count.length; x++){
            if (count[x] == 0)
                System.out.println("No slots available in pump no" + (x+1) + "\n");
            else
                System.out.print(count[x] + " slots available in pump no" + (x+1) + "\n");
        }
    }

    public void remainingFuel(){
        System.out.println("\n" + "-".repeat(60)+"\nnDisplaying remaining fuel in stock.\n");
        System.out.println("Remaining fuel : " + fuelStock + " liters");
        System.out.println("=".repeat(100));
    };

    public void addFuel(){
        String option = "";
        Scanner UserInput = new Scanner(System.in);
        // Endless loop, break when user enter valid input.
        while (true){

            // If fuel in stock is lower than 100 asking admin to refill it or not.
            if (fuelStock <= 100){
                System.out.print("\nFuel stock is nearly empty.\nWould you like to add Stock again?" +
                        "\nEnter 'Y' to refill | Enter 'N' to not refill : ");
            }

            // If there is no fuel in stock asking admin to refill it or not.
            else if(fuelStock == 0){
                System.out.print("\nFuel stock is empty." +
                        "\nEnter 'Y' to refill | Enter 'N' to not refill : ");
            }

            // Asking admin to refill it or not.
            else{
                System.out.print("There are " + fuelStock + "l of fuel stock left.\nWould you like to add Stock again?" +
                        "?\nEnter 'Y' to refill | Enter 'N' to not refill : ");
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
    };

    public void fuelQueueIncome(FuelQueue[][] customers){
        System.out.println("\n" + "-".repeat(60)+"\nView income of each fuel queue Selected.\n");
        System.out.println("Displaying all queue's income");

        for(int i = 0; i < incomeQueue.length; i++){
            System.out.println("Fuel queue "+ (i+1) + " income :  " + incomeQueue[i] * 420.0);
        }
    }

    public void enqueue(String fName, String sName, String vNo, double liter){
        if (rear == -2 && font == -2){
            rear = font = 0;
            waitingCustomerQueue[rear] = fName;  // 0
            rear = (rear + 1) % waitingCustomerQueue.length; // 1

            waitingCustomerQueue[rear] = sName; // 1
            rear = (rear + 1) % waitingCustomerQueue.length; // 2

            waitingCustomerQueue[rear] = vNo; // 2
            rear = (rear + 1) % waitingCustomerQueue.length; // 3

            waitingCustomerQueue[rear] = String.valueOf(liter); // 3
        }

        else if (((rear + 1) % waitingCustomerQueue.length) == font){
            System.out.println("\nWaiting queue is full.\n");
        }

        else {
            rear = (rear + 1) % waitingCustomerQueue.length; // 4

            waitingCustomerQueue[rear] = fName;  // 4
            rear = (rear + 1) % waitingCustomerQueue.length; // 5

            waitingCustomerQueue[rear] = sName; // 5
            rear = (rear + 1) % waitingCustomerQueue.length; // 6

            waitingCustomerQueue[rear] = vNo; // 6
            rear = (rear + 1) % waitingCustomerQueue.length; // 7

            waitingCustomerQueue[rear] = String.valueOf(liter); // 7
        }

        System.out.println(Arrays.toString(waitingCustomerQueue));
    }
}
