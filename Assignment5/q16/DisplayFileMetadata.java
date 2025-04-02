package Assignment5.q16;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.*;

public class DisplayFileMetadata {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter file name:");
            String fileName = scanner.nextLine();
            scanner.close();
            
            File file = new File(fileName);
            
            if (!file.exists()) {
                System.out.println("The file does not exist!");
                return;
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            System.out.println("File Metadata for: " + fileName);
            System.out.println("---------------------");
            System.out.println("File name: " + file.getName());
            System.out.println("Path: " + file.getAbsolutePath());
            System.out.println("Size: " + file.length() + " bytes");
            System.out.println("Last modified: " + sdf.format(new Date(file.lastModified())));
            System.out.println("Is directory: " + file.isDirectory());
            System.out.println("Is file: " + file.isFile());
            System.out.println("Is hidden: " + file.isHidden());
            System.out.println("Can read: " + file.canRead());
            System.out.println("Can write: " + file.canWrite());
            System.out.println("Can execute: " + file.canExecute());
            
            Path path = Paths.get(fileName);
            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
            
            System.out.println("Creation time: " + sdf.format(new Date(attr.creationTime().toMillis())));
            System.out.println("Last access time: " + sdf.format(new Date(attr.lastAccessTime().toMillis())));
            System.out.println("---------------------");
            
        } catch (Exception e) {
            System.out.println("An error occurred while retrieving file metadata.");
            e.printStackTrace();
        }
    }
}