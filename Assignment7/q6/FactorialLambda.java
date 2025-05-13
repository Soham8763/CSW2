package Assignment7.q6;
import java.util.function.Function;

public class FactorialLambda {
    public static Function<Integer, Long> getFactorialFunction() {
        return (Integer n) -> {
            long fact = 1;
            for (int i = 2; i <= n; i++) {
                fact *= i;
            }
            return fact;
        };
    }

    public static void main(String[] args) {
        Function<Integer, Long> factorial = getFactorialFunction();
        int number = 5;
        long result = factorial.apply(number);
        System.out.println("Factorial of " + number + " is " + result);
    }
}
