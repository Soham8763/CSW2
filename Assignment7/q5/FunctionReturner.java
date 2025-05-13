package Assignment7.q5;

import java.util.function.Function;

public class FunctionReturner {
    public static Function<Integer, Integer> getSquareFunction() {
        return (number) -> number * number;
    }

    public static void main(String[] args) {
        Function<Integer, Integer> squareFunction = getSquareFunction();

        int[] numbers = {2, 5, 8, 10};

        System.out.println("Calculating squares using returned function:");
        for (int num : numbers) {
            int square = squareFunction.apply(num);
            System.out.println("Square of " + num + " is: " + square);
        }
    }
}