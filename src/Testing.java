import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        Scanner userInput =  new Scanner(System.in);
        while (true){
            System.out.print("enter the number : ");
            String numbers = userInput.nextLine().toUpperCase();
            if (numbers.equals("ABC") || numbers.equals("100"))
                System.out.println("Sucess");
            if (numbers.equals("YES"))
                break;
        }
        System.out.println("Free              ".length());
    }
}
