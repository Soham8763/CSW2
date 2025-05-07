package Assignment7.q2;

@FunctionalInterface
interface Calculator {
    double operate(double a, double b);
}

public class q2 {
    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> b != 0 ? a / b : Double.NaN;

        double x = 10, y = 0;

        System.out.println("Addition: " + add.operate(x, y));
        System.out.println("Subtraction: " + subtract.operate(x, y));
        System.out.println("Multiplication: " + multiply.operate(x, y));
        System.out.println("Division: " + divide.operate(x, y));
    }
}
