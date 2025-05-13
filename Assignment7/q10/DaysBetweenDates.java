package Assignment7.q10;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DaysBetweenDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the start date (YYYY-MM-DD): ");
            String startInput = scanner.nextLine();
            LocalDate startDate = LocalDate.parse(startInput);

            System.out.print("Enter the end date (YYYY-MM-DD): ");
            String endInput = scanner.nextLine();
            LocalDate endDate = LocalDate.parse(endInput);

            long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

            System.out.println("Number of days between " + startDate + " and " + endDate + ": " + Math.abs(daysBetween));

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
        } finally {
            scanner.close();
        }
    }
}