package Assignment3.q4;
import java.util.*;
public class Sqrt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = sc.nextInt();
        try{
            if(num<0){
                throw new ArithmeticException("Negative number hai chomu");
            }else{
                System.out.println(Math.sqrt(num));
            }
        }catch(ArithmeticException e){
            e.printStackTrace();
        }finally{
            sc.close();
        }
    }
}