import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageTwo {
    public static void mortgageTwo(){
        final byte PERCENT = 100;
        final byte MONTH = 12;

        int principle;
        float rate;
        int period;

        Scanner scan = new Scanner(System.in);

        // principle amount aka 100k
        while(true){
            System.out.print("Principal ($1k - $1m): ");
            principle = Integer.parseInt(scan.nextLine().trim());
            if(principle > 999 && principle <= 1_000_000){
                break;
            }
            System.out.println("Please enter value between 1000 and 1000000");
        }


        // APR aka interest rate
        while(true){
            System.out.print("Annual Interest Rate: ");
            rate = Float.parseFloat(scan.nextLine().trim());
            if(rate > 0 && rate <= 30){
                break;
            }
            System.out.println("Please enter a value greater than 0 less than 30");
        }


        // period aka loan term months
        while(true){
            System.out.print("Period (1 - 30 Years): ");
            period = Integer.parseInt(scan.nextLine().trim());
            if(period >=1 && period <= 30){
                break;
            }
            System.out.println("Enter a  value between 1 and 30");
        }


        // mortgage total
        int totalMonths = period * 12;
        float interest = (rate / PERCENT) / MONTH;

        double mortgage = principle * ((interest*(Math.pow(interest+1,totalMonths))) / (Math.pow(interest+1,totalMonths)-1));

        String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormated);
    }

}
