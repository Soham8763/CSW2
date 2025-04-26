package q9;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
public class diaryEntry {
    public static void main(String[] args){
        File diary = new File("diary.txt");
        System.out.println("Enter the entry you want in diary.txt file");
        Scanner sc = new Scanner(System.in);
        String diaryEntry = sc.nextLine();
        try{
            if(!diary.exists()){
                diary.createNewFile();
            }else{
                System.out.println("Diary file already exists");
            }
            FileWriter writer = new FileWriter(diary,true);
            LocalDate date = LocalDate.now();
            writer.write(date.toString());
            writer.write(diaryEntry);
            writer.close();
        }catch(Exception e){
            System.out.println(e);
        }finally{
            sc.close();
        }
    }
}
