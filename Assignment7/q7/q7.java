package Assignment7.q7;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class q7 {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + dateTime);

        System.out.println(dateTime.plusWeeks(2));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println(dateTime.format(formatter));

    }
}
