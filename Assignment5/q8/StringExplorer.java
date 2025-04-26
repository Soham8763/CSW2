package q8;
import java.util.*;
public class StringExplorer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String str = sc.nextLine();
        System.out.println("Enter the choice");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.println(str.toLowerCase());
                break;
            case 2:
                System.out.println(str.toUpperCase());
                break;
            case 3:
                System.out.println("Enter the character you want to search;");
                char ch = sc.next().charAt(0);
                for (int i = 0; i < str.length(); i++) {
                    if(str.charAt(i) == ch){
                        System.out.println("Element found in index: "+i);
                        break;
                    }else{
                        System.out.println("Not found");
                    }
                }
                break;
            case 4:
                System.out.println("Enter the index you want to search");
                try{
                    int index = sc.nextInt();
                    System.out.println(str.charAt(index));
                }catch(Exception error){
                    error.printStackTrace();
                }
                break;
            case 5:
                System.out.println("Enter the string you want to concatenate");
                String string = sc.nextLine();
                System.out.println(str+string);
            default:
                System.out.println("Invalid index entered");
                sc.close();
                break;
        }
    }
}