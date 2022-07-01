import java.util.*;

public class Task1_Array {
    public static int fuelStock = 6600;
    public static Scanner UserInput = new Scanner(System.in);
    public static void main(String[] args) {
        String[][] customer_queue = new String[6][3];
        String customer;
        initialise(customer_queue);
        viewQueue(customer_queue);

    }

    public static void initialise(String[][] customer_queue){
        for (int i = 0; i < customer_queue.length; i++){
            for (int j = 0; j < customer_queue[i].length; j++){
                customer_queue[i][j] = "e";
            }
        }
    }

    public static void viewQueue(String[][] customer_queue){
        System.out.println("Gasoline Pump 1  |  Gasoline Pump 2  |  Gasoline Pump 3  ");
        for(int i = 0; i < customer_queue.length; i++){
            for (int j = 0; j < customer_queue[i].length; j++){
                if (customer_queue[i][j].equals("e"))
                    System.out.print("Free                  ");
                else
                    System.out.print(customer_queue[i][j]);
            }
            System.out.println();
        }
    }

    public static void addCustomer(String[][] customer_queue){
        System.out.print("Enter customer's name : ");
        String name  = UserInput.nextLine();
    }
}
