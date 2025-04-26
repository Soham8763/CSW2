package q4;
import java.util.*;
public class Stringbuilder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        StringBuilder stringbuilder = new StringBuilder(sc.nextLine());
        while(true){
            System.out.println("Enter your choice(6 to exit):");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the string to be inserted:");
                    String insString = sc.nextLine();
                    try{
                        System.out.println("Enter your index");
                        int index = sc.nextInt();
                        stringbuilder.insert(index,insString);
                    } catch(Exception error) {
                        error.printStackTrace();
                    }
                    break;
                case 2:
                    try{
                        System.out.println("Enter the indices to delete:");
                        int srtIndex = sc.nextInt();
                        int lstIndex = sc.nextInt();
                        try{
                            stringbuilder.delete(srtIndex,lstIndex);
                        }catch(Exception error){
                            error.printStackTrace();
                        }
                    }catch(Exception error){
                        error.printStackTrace();
                    }
                    break;
                case 3:
                    try{
                        System.out.println("Enter the index:");
                        int index = sc.nextInt();
                        System.out.println("Enter the character to be modified");
                        char character = sc.next().charAt(0);
                        try{
                            stringbuilder.setCharAt(index,character);
                        }catch(Exception error){
                            error.printStackTrace();
                        }
                    }catch(Exception error){
                        error.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Enter the string to be appended:");
                    String appString = sc.nextLine();
                    stringbuilder.append(appString);
                    break;
                case 5:
                    System.out.println(stringbuilder);
                    break;
                default:
                    sc.close();
                    System.out.println("Invalid choice entered");
                    break;
            }
        }
    }
}