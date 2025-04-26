package q3;
import java.util.*;
public class Buffer {
    public static void main(String[] args) {
        StringBuffer textBuffer = new StringBuffer("Hello world");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your options");
        int options = sc.nextInt();
        switch(options){
            case 1:
                System.out.println("Enter the string to be appended:");
                String appString = sc.nextLine();
                textBuffer.append(appString);
                break;
            case 2:
                System.out.println("Enter the string to be inserted:");
                String insString = sc.nextLine();
                System.out.println("Enter the index:");
                int index = sc.nextInt();
                if(index > textBuffer.length()){
                    System.out.println("Invalid index");
                    break;
                }
                try{
                    textBuffer.insert(index, insString);
                } catch(Exception error) {
                    error.printStackTrace();
                }
                break;
            case 3:
                System.out.println("Enter the starting and ending indices to be deleted from the string");
                int stIndex = sc.nextInt();
                int lstIndex = sc.nextInt();
                if(stIndex < 0 || lstIndex>textBuffer.length()) {
                    System.out.println("Invalid indices");
                    break;
                }
                try{
                    textBuffer.delete(stIndex, lstIndex);
                } catch(Exception error) {
                    error.printStackTrace();
                }
                break;
            case 4:
                textBuffer.reverse();
                break;
            case 5:
                System.out.println("Enter the starting and ending indices:");
                int startIndex = sc.nextInt();
                int lastIndex = sc.nextInt();
                System.out.println("Enter the string to be replaced");
                String replacedString = sc.nextLine();
                if(startIndex < 0 || lastIndex>textBuffer.length()) {
                    System.out.println("Invalid indices");
                    break;
                }
                try{
                    textBuffer.replace(startIndex, lastIndex, replacedString);
                } catch(Exception error) {
                    error.printStackTrace();
                }
            break;
            default:
                System.out.println("Invalid option selected");
                break;
        }
        System.out.println(textBuffer);
        sc.close();
    }
}