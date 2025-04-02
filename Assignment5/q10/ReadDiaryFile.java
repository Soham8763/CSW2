package Assignment5.q10;

import java.io.*;

public class ReadDiaryFile {
    public static void main(String[] args) {
        try {
            File diaryFile = new File("diary.txt");
            
            if (!diaryFile.exists()) {
                System.out.println("The file diary.txt does not exist!");
                return;
            }
            
            BufferedReader reader = new BufferedReader(new FileReader(diaryFile));
            String line;
            System.out.println("Contents of diary.txt:");
            System.out.println("---------------------");
            
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            System.out.println("---------------------");
            reader.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}