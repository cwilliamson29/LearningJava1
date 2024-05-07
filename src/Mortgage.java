import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {
    public static void mortgage(){
        final byte PERCENT = 100;
        final byte MONTH = 12;

        Scanner scan = new Scanner(System.in);

        // principle amount aka 100k
        System.out.print("Principal: ");
        int principle = Integer.parseInt(scan.nextLine().trim());

        // APR aka interest rate
        System.out.print("Annual Interest Rate: ");
        float rate = Float.parseFloat(scan.nextLine().trim());

        // period aka loan term months
        System.out.print("Period (Years): ");
        int period = Integer.parseInt(scan.nextLine().trim());

        // mortgage total
        int totalMonths = period * 12;
        float interest = (rate / PERCENT) / MONTH;

        double mortgage = principle * ((interest*(Math.pow(interest+1,totalMonths))) / (Math.pow(interest+1,totalMonths)-1));

        String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormated);

    }
}
