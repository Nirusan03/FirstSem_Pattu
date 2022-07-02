import java.util.*;

public class Task1_Array {
    public static int fuelStock = 6600;
    public static Scanner UserInput = new Scanner(System.in);
    public static void main(String[] args) {

        String[][] customer_queue = new String[3][6];
        String customer;
        initialise(customer_queue);
//        viewQueue(customer_queue);
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
//        System.out.println(customer);
        if (customer.equals("100") || customer.equals("VFQ"))
            viewQueue(customer_queue);

        else if (customer.equals("101") || customer.equals("VEQ"))
            emptyQueue (customer_queue);

        else if (customer.equals("102") || customer.equals("ACQ"))
            addCustomer(customer_queue);
    }

    public static void initialise(String[][] customer_queue){
        for (int i = 0; i < customer_queue.length; i++){
            for (int j = 0; j < customer_queue[i].length; j++){
                customer_queue[i][j] = "e";
            }
        }
    }

    public static void viewQueue(String[][] customer_queue){
//        System.out.println("Gasoline Pump 1  |  Gasoline Pump 2  |  Gasoline Pump 3  ");
        for(int i = 0; i < customer_queue.length; i++){
            for (int j = 0; j < customer_queue[i].length; j++){
                if (j == 0)
                    System.out.print("Gasoline Pump " + (i+1) + " : ");
                if (customer_queue[i][j].equals("e"))
                    System.out.print("Available | ");
                else
                    System.out.print(customer_queue[i][j]);
            }
            System.out.println("\n");
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
        System.out.print("Enter customer's name : ");
        String name  = UserInput.nextLine();
        name = Character.toUpperCase(name.charAt(0))+ name.substring(1);

    }


}
