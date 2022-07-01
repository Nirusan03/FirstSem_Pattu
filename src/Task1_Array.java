import java.util.Arrays;

public class Task1_Array {
    public static void main(String[] args) {
        int fuelStock = 6600;
        String[][] customer_queue = new String[3][6];
        String customer;
        initialise(customer_queue);
        for(String[] i : customer_queue){
            for (String j : i)
                System.out.print(j + " ");
            System.out.println();
        }

    }

    public static void initialise(String[][] customer_queue){
        for (int i = 0; i < customer_queue.length; i++){
            for (int j = 0; j < customer_queue[i].length; j++){
                customer_queue[i][j] = "e";
            }
        }
    }
}
