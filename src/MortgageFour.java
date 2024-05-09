import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageFour {
    final static byte PERCENT = 100;
    final static byte MONTH = 12;

    public static void mortgageFour(){
        System.out.println("inside mortgage four");

        int principle = (int) message("Principal ($1k - $1m): ", 1000, 1_000_000);
        float rate = (float) message("Annual Interest Rate: ", 1, 30);
        byte period = (byte) message("Period (1 - 30 Years): ", 1, 30);

        // mortgage total
        double mortgage = calculateMortgage(principle,rate,period);

        String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println(" ");
        System.out.print("MORTGAGE");
        System.out.print("--------");
        System.out.print("Mortgage: " + mortgageFormated);

        System.out.println(" ");
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for(short i = 0; i <= period*MONTH; i++){
            double balance = calculateBalance(principle, rate, period, i);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }



    public static double message(String message, double min, double max){
        Scanner scan = new Scanner(System.in);
        double input;

        while(  true){
            System.out.print(message);
            input = scan.nextFloat();
            if(input >= min && input <= max){
                break;
            }
            System.out.println("Please enter value between " + min + " and " + max);
        }

        return input;
    };

    public static double calculateBalance(int principle, float annualInterest, byte years, short numberOfPaymentsMade){
        float numberOfPayments = years * MONTH;
        float monthlyInterest = annualInterest / PERCENT / MONTH;

        double balance = principle
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    };

    public static double calculateMortgage(int principle, float annualInterest, byte years){
        float numberOfPayments = years * MONTH;
        float monthlyInterest = annualInterest / PERCENT / MONTH;

        double mortgage =  principle
                * (monthlyInterest * Math.pow(monthlyInterest + 1, numberOfPayments)
                / (Math.pow(monthlyInterest + 1, numberOfPayments) - 1 ));
        return mortgage;
    };
}
