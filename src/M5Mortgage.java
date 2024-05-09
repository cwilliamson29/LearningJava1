import java.util.Scanner;

public class M5Mortgage {
    private final static byte PERCENT = 100;
    private final static byte MONTH = 12;

    private static int principle;
    private static float annualInterest;
    private static byte years;
    private static double mortgage;
    private static double balance;
    private static final Scanner scan = new Scanner(System.in);

    public static void setPrinciple(int a){
        principle = a;
    }
    public static void setAnnualInterest(float a){
        annualInterest = a;
    }
    public static void setYears(byte a){
        years = a;
    }
    public static byte getYears(){
        return years;
    }

    public static void setCalculateMortgage(){
        float numberOfPayments = years * MONTH;
        float monthlyInterest = annualInterest / PERCENT / MONTH;

        mortgage =  principle
                * (monthlyInterest * Math.pow(monthlyInterest + 1, numberOfPayments)
                / (Math.pow(monthlyInterest + 1, numberOfPayments) - 1 ));
    };

    public static double getMortgage(){
        return mortgage;
    }

    public static double calculateBalance(short numberOfPaymentsMade){
        float numberOfPayments = years * MONTH;
        float monthlyInterest = annualInterest / PERCENT / MONTH;

        double balance = principle
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;
    };

}
