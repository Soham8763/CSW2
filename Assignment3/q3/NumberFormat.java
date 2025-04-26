package Assignment3.q3;
import java.util.*;
public class NumberFormat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        String str = sc.nextLine();
        try{
            int string = Integer.parseInt(str);
        }catch(NumberFormatException e){
            System.out.println("Invalid number, try again");
        }
        sc.close();
    }
}