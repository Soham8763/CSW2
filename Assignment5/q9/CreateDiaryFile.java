import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CreateDiaryFile {
    public static void main(String[] args) {
        try {
            File diaryFile = new File("diary.txt");
            
            if (diaryFile.exists()) {
                System.out.println("The file diary.txt already exists!");
                return;
            }
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your diary entry:");
            String entry = scanner.nextLine();
            scanner.close();
            
            FileWriter writer = new FileWriter(diaryFile);
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDate = now.format(formatter);
            
            writer.write(formattedDate + "\n" + entry);
            writer.close();
            
            System.out.println("Diary entry saved successfully!");
            
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }
}