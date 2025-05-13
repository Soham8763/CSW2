package Assignment7.q9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Enter start date (yyyy-MM-dd): ");
        String inputDate = sc.nextLine();
        LocalDate startDate = LocalDate.parse(inputDate, formatter);
        LocalDate currentDate = LocalDate.now();

        System.out.print("Enter initial amount: ");
        double principal = sc.nextDouble();

        long daysBetween = ChronoUnit.DAYS.between(startDate, currentDate);
        double rate = 8.0;
        double interest = (principal * rate * daysBetween) / (100 * 365);
        double totalAmount = principal + interest;

        System.out.println("Total amount after interest: " + totalAmount);
        sc.close();
    }
}
