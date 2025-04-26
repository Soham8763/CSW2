package q11;
import java.util.*;
import java.io.*;
import java.time.*;
public class AppendContent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the entry you want to enter in a file");
        String entry = sc.nextLine();
        File diary = new File("diary.txt");
        try{
            FileWriter writer = new FileWriter(diary,true);
            LocalDateTime dt = LocalDateTime.now();
            writer.write(dt.toString()+"\n");
            writer.write(entry);
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        sc.close();
    }
}
