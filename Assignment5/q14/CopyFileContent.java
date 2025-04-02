package Assignment5.q14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyFileContent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter source file path:");
        String sourcePath = scanner.nextLine();
        
        System.out.println("Enter destination file path:");
        String destinationPath = scanner.nextLine();
        
        File sourceFile = new File(sourcePath);
        File destinationFile = new File(destinationPath);
        
        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist!");
            scanner.close();
            return;
        }
        
        if (destinationFile.exists()) {
            System.out.println("Destination file already exists. Overwrite? (y/n)");
            String response = scanner.nextLine();
            
            if (!response.equalsIgnoreCase("y")) {
                System.out.println("Copy operation cancelled.");
                scanner.close();
                return;
            }
        }
        
        scanner.close();
        
        try (FileInputStream inStream = new FileInputStream(sourceFile);
             FileOutputStream outStream = new FileOutputStream(destinationFile)) {
            
            byte[] buffer = new byte[1024];
            int length;
            
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }
            
            System.out.println("File copied successfully!");
            
        } catch (IOException e) {
            System.out.println("An error occurred during the copy operation.");
            e.printStackTrace();
        }
    }
}