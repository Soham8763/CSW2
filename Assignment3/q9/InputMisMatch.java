package Assignment3.q9;

import java.util.*;

public class InputMisMatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter an integer");
            int num = sc.nextInt();
            System.out.println(num);
        }catch(InputMismatchException e){
            e.printStackTrace();
        }
    }
}