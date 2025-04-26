package Assignment3.q10;
import java.io.*;
class FileReadPermissionException extends Exception {
    public FileReadPermissionException(String message) {
        super(message);
    }
}
public class Files {
    public static void main(String[] args) {
        try {
            if (args.length == 0 || args[0] == null)
                throw new FileNotFoundException("File path is null. Please provide a valid file path.");
            File file = new File(args[0]);
            if (!file.exists())
                throw new FileNotFoundException("File not found: " + args[0]);
            if (!file.canRead())
                throw new FileReadPermissionException("Permission denied: Cannot read the file " + args[0]);
            System.out.println("File exists and can be read: " + args[0]);
        } catch (FileNotFoundException | FileReadPermissionException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}