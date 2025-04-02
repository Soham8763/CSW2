package Assignment5.q12;

import java.io.File;
import java.util.Scanner;

public class ListFilesAndDirectories {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path to list files and subdirectories:");
        String directoryPath = scanner.nextLine();
        scanner.close();
        
        File directory = new File(directoryPath);
        
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The specified directory does not exist!");
            return;
        }
        
        File[] filesAndDirs = directory.listFiles();
        
        if (filesAndDirs == null || filesAndDirs.length == 0) {
            System.out.println("The directory is empty.");
            return;
        }
        
        System.out.println("Contents of directory: " + directoryPath);
        System.out.println("---------------------");
        
        for (File fileOrDir : filesAndDirs) {
            String type = fileOrDir.isDirectory() ? "[DIR]" : "[FILE]";
            System.out.println(type + " " + fileOrDir.getName());
        }
        
        System.out.println("---------------------");
    }
}