import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageThree {
    public static void mortgageThree(){
        System.out.println("inside mortgage three");

        int principle = (int) message("Principal ($1k - $1m): ", 1000, 1_000_000);
        float rate = (float) message("Annual Interest Rate: ", 1, 30);
        int period = (int) message("Period (1 - 30 Years): ", 1, 30);

        // mortgage total
        double mortgage = calculateMortgage(principle,rate,period);

        String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormated);

    }

    public static double message(String message, int min, int max){
        Scanner scan = new Scanner(System.in);
        double input;

        while(true){
            System.out.print(message);
            input = Double.parseDouble(scan.nextLine().trim());
            if(input >= min && input <= max){
                break;
            }
            System.out.println("Please enter value between " + min + " and " + max);
        }

        return input;
    };

    public static double calculateMortgage(int principle, float rate, int period){
        final byte PERCENT = 100;
        final byte MONTH = 12;

        int totalMonths = period * 12;
        float interest = (rate / PERCENT) / MONTH;

        return principle * ((interest*(Math.pow(interest+1,totalMonths))) / (Math.pow(interest+1,totalMonths)-1));
    };
}
