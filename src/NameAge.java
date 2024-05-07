import java.util.Calendar;
import java.util.Scanner;

public class NameAge {
    public static void nameAge(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scan.nextLine().trim();
        System.out.print("Year of Birth: ");
        String yearStr = scan.nextLine().trim();
        int birthYear = Integer.parseInt(yearStr);

        //Determine Age
        Calendar today = Calendar.getInstance();
        int date = Integer.parseInt(String.valueOf(today.get(Calendar.YEAR)));
        int age = date - birthYear;

        String message = "Your name is " + name + ", and you are " + age + " years old.";
        int len = message.length();

        for (int i = 0; i < len; i++){
            System.out.print("*");
            if(i == len - 1){
                System.out.println(" ");
            }
        }

        System.out.println(message);
    }
}
