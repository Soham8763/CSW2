package q10;

import java.io.File;
import java.io.FileReader;

public class reader {
    public static void main(String[] args) {
        File diary =  new File("diary.txt");
        if(!diary.exists()){
            System.out.println("Diary doesn't exists");
            return;
        }
        try{
            FileReader reader = new FileReader(diary);
            int ch;
            while((ch = reader.read()) == -1){
                System.out.print((char)ch);
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}