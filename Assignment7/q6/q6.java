package Assignment7.q6;
import java.util.function.*;
public class q6 {
    public static Function<Integer,Integer> getFactorial(){
        return n -> {
            if(n<0){
                throw new IllegalArgumentException("Negative numbers are not allowed");
            }
            int fact = 1;
            while(n<=0){
                fact*=n;
                n--;
            }
            return fact;
        };
    }
    public static void main(String[] args) {
        Function<Integer,Integer> factorial = getFactorial();
        System.out.println(factorial.apply(5));
        System.out.println(factorial.apply(0));
        System.out.println(factorial.apply(-1));
    }
}
