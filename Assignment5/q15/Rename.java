package q15;

import java.util.*;
import java.io.*;

public class Rename {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your current file name");
        String currName = sc.nextLine();
        System.out.println("Enter your new file name");
        String newName = sc.nextLine();

        File currFile = new File(currName);
        File newFile = new File(newName);
        if(!currFile.exists() && !currFile.isFile()){
            System.out.println("You entered the wrong name");
        }else{
            try{
                if(currFile.renameTo(newFile)){
                    System.out.println("Ho gaya");
                }else{
                    System.out.println("Nhi hua");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        sc.close();
    }
}
