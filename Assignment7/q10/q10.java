package Assignment7.q10;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
public class q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Starting date (yyyy-mm-dd): ");
        String start = sc.nextLine();
        System.out.println("Enter the Ending date (yyyy-mm-dd): ");
        String end = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate startDate = LocalDate.parse(start,formatter);
        LocalDate endDate = LocalDate.parse(end,formatter);

        long days = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("Number of days between the two dates: " + days);
        sc.close();
    }
}
