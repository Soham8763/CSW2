package Assignment7.q9;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
public class q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the StartDate (yyyy-mm-dd): ");
        String Date = sc.nextLine();
        System.out.println("Enter the intial principal amount");
        long principal = sc.nextLong();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(Date, formatter);
        final int rate = 8;
        LocalDate currDate = LocalDate.now();
        currDate.format(formatter);
        long numberOfDays = ChronoUnit.DAYS.between(startDate, currDate);
        double interest = (principal * rate * numberOfDays) / (100 * 365);
        System.out.println("Interest comes out to be: "+interest);
        sc.close();
    }
}
