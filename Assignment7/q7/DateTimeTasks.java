package Assignment7.q7;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeTasks {
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);

        LocalDate dateAfterTwoWeeks = LocalDate.now().plusWeeks(2);
        System.out.println("Date After 2 Weeks: " + dateAfterTwoWeeks);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = LocalDate.now().format(formatter);
        System.out.println("Formatted Current Date: " + formattedDate);
    }
}
