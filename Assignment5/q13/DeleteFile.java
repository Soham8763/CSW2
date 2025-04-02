package Assignment5.q13;

import java.io.File;
import java.util.Scanner;

public class DeleteFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file to delete:");
        String fileName = scanner.nextLine();
        scanner.close();
        
        File fileToDelete = new File(fileName);
        
        if (!fileToDelete.exists()) {
            System.out.println("The file does not exist!");
            return;
        }
        
        if (fileToDelete.delete()) {
            System.out.println("File deleted successfully!");
        } else {
            System.out.println("Failed to delete the file. It might be in use or protected.");
        }
    }
}