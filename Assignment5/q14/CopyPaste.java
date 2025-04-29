package q14;
import java.io.*;
import java.util.*;
public class CopyPaste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the source path");
        String src = sc.nextLine();
        System.out.println("Enter the destination path");
        String dest = sc.nextLine();

        File source = new File(src);
        File destination = new File(dest);

        if(!source.exists()){
            System.out.println("Invalid source path");
        }
        if(destination.exists()){
            try(FileReader reader = new FileReader(src);FileWriter writer = new FileWriter(destination);){
                System.out.println("Enter your confirmation(y/n)");
                String choice = sc.next();
                if(!choice.equalsIgnoreCase("y")){
                    System.out.println("Copying cancelled");
                    return;
                }else{
                    int ch;
                    while((ch = reader.read()) != -1){
                        writer.write(ch);
                    }
                }
                writer.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        sc.close();
    }
}
