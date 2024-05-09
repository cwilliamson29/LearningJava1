import java.util.Scanner;

public class M5Main {
    public static final Scanner scan = new Scanner(System.in);

    public static void m5Main(){
        System.out.println("inside mortgage five");

        int principle = (int) readNumber("Principal ($1k - $1m): ", 1000, 1_000_000);
        M5Mortgage.setPrinciple(principle);

        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        M5Mortgage.setAnnualInterest(annualInterest);

        byte years = (byte) readNumber("Period (1 - 30 Years): ", 1, 30);
        M5Mortgage.setYears(years);

        // mortgage total
        M5Mortgage.setCalculateMortgage();

        // Print totals
        M5MessageOutput.printMortgage();
        M5MessageOutput.printPaymentSchedule();

    }
    public static double readNumber(String message, double min, double max){
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
}
