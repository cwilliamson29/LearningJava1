import java.util.Scanner;

public class FizzBuzz {
    public static void fizzBuzz(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Number: ");
        int number = Integer.parseInt(scan.nextLine().trim());

        if(number % 3 == 0 && number % 5 == 0 ){
            System.out.println("FizzBuzz");
        } else if (number % 3 == 0 ){
            System.out.println("Fizz");
        } else if (number % 5 == 0 ){
            System.out.println("Buzz");
        } else {
            System.out.println(number);
        }
    }
}
