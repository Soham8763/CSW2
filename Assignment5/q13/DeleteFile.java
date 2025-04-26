package q13;
import java.util.*;
import java.io.*;
public class DeleteFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file you want to delete");
        String fileName = sc.nextLine();
        File fileToDelete = new File(fileName);
        if(fileToDelete.exists()){
            try{
                if(fileToDelete.delete()){
                    System.out.println("File deleted successfully");
                }else{
                    System.out.println("Error occured while deleting file");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("File doesnt exists");
        }
        sc.close();
    }
}
