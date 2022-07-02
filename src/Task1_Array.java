import javax.print.MultiDocPrintService;
import java.util.*;

public class Task1_Array {
    public static int fuelStock = 6600;
    public static Scanner UserInput = new Scanner(System.in);
    public static int[] count = {0, 0, 0};
    public static void main(String[] args) {

        String[][] customer_queue = new String[3][6];
        String customer;
        initialise(customer_queue);
//        viewQueue(customer_queue);
//        System.out.println(customer);
        while (true){
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

            customer = UserInput.nextLine().toUpperCase();
            if (customer.equals("100") || customer.equals("VFQ"))
                viewQueue(customer_queue);

            else if (customer.equals("101") || customer.equals("VEQ"))
                emptyQueue (customer_queue);

            else if (customer.equals("102") || customer.equals("ACQ"))
                addCustomer(customer_queue);

            else if (customer.equals("103") || customer.equals("RCQ"))
                removeSpecific(customer_queue);

            else if (customer.equals("104") || customer.equals("PCQ"))
                removeServed(customer_queue);

            else if (customer.equals("108") || customer.equals("STK"))
                remainingFuel();

            else if (customer.equals("109") || customer.equals("AFS"))
                addFuel();

            else if (customer.equals("999") || customer.equals("EXT"))
                break;
        }

    }

    public static void initialise(String[][] customer_queue){
        for (int i = 0; i < customer_queue.length; i++){
            for (int j = 0; j < customer_queue[i].length; j++){
                customer_queue[i][j] = "e";
            }
        }
    }

    // 100 or VFQ: View all Fuel Queues.
    public static void viewQueue(String[][] customer_queue){
        count = new int[]{0, 0, 0};
        for(int i = 0; i < customer_queue.length; i++){
            for (int j = 0; j < customer_queue[i].length; j++){
                if (j == 0)
                    System.out.print("Gasoline Pump " + (i+1) + " : ");
                if (customer_queue[i][j].equals("e")){
                    System.out.print("Available | ");
                    count[i]++;
                }

                else
                    System.out.print(customer_queue[i][j] + " | ");
            }
            System.out.println("\n");
        }
        for (int x  = 0; x < count.length; x++){
            if (count[x] == 0)
                System.out.println("No slots available in pump no" + (x+1) + "\n");
            else
                System.out.print(count[x] + " slots available in pump no" + (x+1) + "\n");
        }
    }

    public static void emptyQueue(String[][] customer_queue){
        int count = 0;
        for(int i = 0; i < customer_queue.length; i++){
            for (int j = 0; j < customer_queue[i].length; j++){
                if (j == 0)
                    System.out.print("Gasoline Pump " + (i+1) + " : ");
                if (customer_queue[i][j].equals("e")){
                    count++;
                    System.out.print("Available | ");
                    if (j == customer_queue[i].length-1){
                        System.out.print(count + " slots available.");
                        count = 0;
                    }
                }
            }
            System.out.println("\n");
        }
    }

    public static void addCustomer(String[][] customer_queue){
        String name;
        int pumpNo;

        if (fuelStock == 0)
            System.out.println("Sorry there is no fuel in stock. Mooditu queue ah anupuda");
        else if (fuelStock <= 100)
            addFuel();
        viewQueue(customer_queue);
        System.out.print("\nEnter customer's name : ");
        name  = UserInput.nextLine();
        name = Character.toUpperCase(name.charAt(0))+ name.substring(1);
        while (true){
            System.out.print("Enter the pump number, " + name + " wish to go : ");
            pumpNo = UserInput.nextInt() - 1;

            if (pumpNo >= 0 && pumpNo <= 2){
                if (count[pumpNo] == 0)
                    System.out.println("Sorry, there is no space in pump " + pumpNo +
                            "'s queue");
                else{
                    for(int i = 0; i < customer_queue[pumpNo].length; i++){
                        if (customer_queue[pumpNo][i].equals("e")){
                         customer_queue[pumpNo][i] = name;
                         break;
                        }
                    }
                    break;
                }
            }

            else{
                System.out.println("Invalid pump number.\n");
            }
        }
    }

    public static void addFuel(){
        if (fuelStock <= 100){
            System.out.print("\nFuel stock is nearly empty.\nWould you like to add Stock again?" +
                    "\nEnter 'Y' to refill | Enter 'N' to not refill : ");
        }

        else if(fuelStock == 0){
            System.out.print("\nFuel stock is empty." +
                    "\nEnter 'Y' to refill | Enter 'N' to not refill : ");
        }

        else
            System.out.print("\nThere are " + fuelStock + "l of fuel stock left.\nWould you like to add Stock again?" +
                "?\nEnter 'Y' to refill | Enter 'N' to not refill");
        String option = UserInput.nextLine().toUpperCase();
        if (option.equals("Y")){
            fuelStock = 6600;
            System.out.println("Fuel stock refiled.");
        }

        else
            System.out.println("Stock is same");
    }

    public static void remainingFuel(){
        System.out.println("Remaining fuel : " + fuelStock + " liters");
    }

    public static void removeSpecific(String[][] customer_queue) {
        System.out.println("\nEnter the served customer's pump number : ");
        int pump_number = UserInput.nextInt() - 1;

        System.out.println("\nEnter the served customer's queue position number : ");
        int pos = UserInput.nextInt();

//        int pos = 1;
        while (true) {
            if (pump_number <= 2 && pump_number >= 0) {
                for (int i = pos - 1; i < customer_queue[pump_number].length; i++) {
                    if (i != customer_queue[pump_number].length - 1) {
                        customer_queue[pump_number][i] = customer_queue[pump_number][pos];
                        pos++;
                    }
                }
                fuelStock -= 10;
                break;
            } else
                System.out.println("Invalid Pump number.");
        }
    }

    public static void removeServed(String[][] customer_queue){
        System.out.println("\nEnter the served customer's pump number : ");
        int pump_number = UserInput.nextInt()-1;
        int pos = 1;
        while (true){
            if (pump_number <= 2 && pump_number >=0){
                for(int i = 0 ; i < customer_queue[pump_number].length; i++){
                    if (i != customer_queue[pump_number].length-1){
                        customer_queue[pump_number][i] = customer_queue[pump_number][pos];
                        pos++;
                    }
                }
                fuelStock -= 10;
                break;
            }
            else
                System.out.println("Invalid Pump number.");
        }
//        customer_queue[customer_queue.length-1] = "e";
    }

}
