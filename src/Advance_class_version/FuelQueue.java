package Advance_class_version;

import java.io.IOException;

public class FuelQueue extends abstraction{

    public static int[] count = {0, 0, 0, 0, 0};
    public static double[] incomeQueue = {0, 0, 0, 0, 0};
    private static double fuelStock = 6600;
    private String firstName;
    private String secondName;
    private String vehicleNo;
    private double liter;
    private String filling;
    static FuelQueue[][] customers = new FuelQueue[5][6];

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

    };

    public void fuelQueueIncome(FuelQueue[][] customers){
        System.out.println("\n" + "-".repeat(60)+"\nView income of each fuel queue Selected.\n");
        System.out.println("Displaying all queue's income");
        System.out.println("Fuel queue 1 income :  " + incomeQueue[0] * 420.0);
        System.out.println("Fuel queue 2 income :  " + incomeQueue[1] * 420.0);
        System.out.println("Fuel queue 3 income :  " + incomeQueue[2] * 420.0);
        System.out.println("Fuel queue 4 income :  " + incomeQueue[3] * 420.0);
        System.out.println("Fuel queue 5 income :  " + incomeQueue[4] * 420.0);
    }
}
