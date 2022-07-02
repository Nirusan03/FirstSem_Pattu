import java.util.Arrays;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        String[] numbers = {"Niru", "NiruShan", "h", "y" , "k"};
        int pos = 2;
        for(int i = pos-1 ; i < numbers.length; i++){
            if (i != numbers.length-1){
                numbers[i] = numbers[pos];
                pos++;
            }
        }
        numbers[numbers.length-1] = "e";
        System.out.println(Arrays.toString(numbers));
//        Scanner userInput =  new Scanner(System.in);
//        while (true){
//            System.out.print("enter the number : ");
//            String numbers = userInput.nextLine().toUpperCase();
//            if (numbers.equals("ABC") || numbers.equals("100"))
//                System.out.println("Success");
//            if (numbers.equals("YES"))
//                break;
//        }
//        System.out.println("Free              ".length());
    }
}
