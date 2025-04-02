package Assignment5.q15;

import java.io.*;
import java.util.*;

public class RenameFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter current file name:");
        String currentFileName = scanner.nextLine();
        
        System.out.println("Enter new file name:");
        String newFileName = scanner.nextLine();
        
        scanner.close();
        
        File currentFile = new File(currentFileName);
        File newFile = new File(newFileName);
        
        if (!currentFile.exists()) {
            System.out.println("The file does not exist!");
            return;
        }
        
        if (newFile.exists()) {
            System.out.println("A file with the new name already exists!");
            return;
        }
        
        if (currentFile.renameTo(newFile)) {
            System.out.println("File renamed successfully!");
        } else {
            System.out.println("Failed to rename the file. It might be in use or protected.");
        }
    }
}