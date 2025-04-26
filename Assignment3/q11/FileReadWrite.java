package Assignment3.q11;
import java.util.*;
import java.io.*;
public class FileReadWrite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter source file name");
        File sourceFile = new File(sc.nextLine());
        System.out.println("Enter dest file name");
        File destFile = new File(sc.nextLine());
        try (FileReader reader = new FileReader(sourceFile);
             FileWriter writer = new FileWriter(destFile);) {
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            sc.close();
        }
    }
}