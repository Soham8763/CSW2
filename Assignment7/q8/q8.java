package Assignment7.q8;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class q8 {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTime.format(formatter));
    }
}
