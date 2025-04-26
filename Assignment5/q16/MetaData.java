package q16;
import java.util.*;
import java.io.*;
public class MetaData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file name");
        File file = new File(sc.nextLine());
        if(file.exists()){
            try{
                System.out.println(file.getName());
                System.out.println(file.getAbsolutePath());
                System.out.println(file.length());
                System.out.println(file.canRead());
                System.err.println(file.canWrite());
                System.out.println(file.canExecute());
                System.out.println(file.lastModified());
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Wrong filename entered");
        }
        sc.close();
    }
}