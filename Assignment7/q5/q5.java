package Assignment7.q5;

@FunctionalInterface
interface NumberOperation {
    int operate(int number);
}

public class q5 {
    public static NumberOperation getSquareFunction() {
        return (number) -> number * number;
    }

    public static void main(String[] args) {
        NumberOperation squareFunction = getSquareFunction();

        int[] numbers = {2, 5, 8, 10};

        System.out.println("Calculating squares using returned function:");
        for (int num : numbers) {
            int square = squareFunction.operate(num);
            System.out.println("Square of " + num + " is: " + square);
        }
    }
}