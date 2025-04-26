package q12;
import java.util.*;
import java.io.*;
public class dirPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directory = sc.nextLine();
        File folder = new File(directory);
        try{
            if(folder.exists() && folder.isDirectory()){
                String[] content = folder.list();
                for(String files:content){
                    System.out.println(files);
                }
            }else{
                System.out.println("No such folder exists");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        sc.close();
    }
}