package Assignment5.q11;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AppendToDiaryFile {
    public static void main(String[] args) {
        try {
            File diaryFile = new File("diary.txt");
            
            if (!diaryFile.exists()) {
                System.out.println("The file diary.txt does not exist. Creating a new file.");
            }
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your new diary entry:");
            String entry = scanner.nextLine();
            scanner.close();
            
            FileWriter writer = new FileWriter(diaryFile, true);
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDate = now.format(formatter);
            
            writer.write("\n\n" + formattedDate + "\n" + entry);
            writer.close();
            
            System.out.println("Diary entry appended successfully!");
            
        } catch (IOException e) {
            System.out.println("An error occurred while appending to the file.");
            e.printStackTrace();
        }
    }
}