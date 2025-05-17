package Assignment8.q3;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BiFunction;

public class q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(4);

        BiFunction<Double, Double, Double> addOperation = (a, b) -> {
            try {
                Thread.sleep(1000);
                return a + b;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return 0.0;
            }
        };

        BiFunction<Double, Double, Double> subtractOperation = (a, b) -> {
            try {
                Thread.sleep(1000);
                return a - b;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return 0.0;
            }
        };

        BiFunction<Double, Double, Double> multiplyOperation = (a, b) -> {
            try {
                Thread.sleep(1000);
                return a * b;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return 0.0;
            }
        };

        BiFunction<Double, Double, Double> divideOperation = (a, b) -> {
            try {
                Thread.sleep(1000);
                if (b == 0) {
                    throw new ArithmeticException("Division by zero!");
                }
                return a / b;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return 0.0;
            }
        };

        while (true) {
            System.out.println("\nSimple Calculator (Enter 'exit' to quit)");
            System.out.println("Enter first number:");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                double num1 = Double.parseDouble(input);
                System.out.println("Enter second number:");
                double num2 = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter operation (+, -, *, /):");
                String operation = scanner.nextLine();

                Future<Double> result = null;

                switch (operation) {
                    case "+":
                        result = executor.submit(() -> addOperation.apply(num1, num2));
                        break;
                    case "-":
                        result = executor.submit(() -> subtractOperation.apply(num1, num2));
                        break;
                    case "*":
                        result = executor.submit(() -> multiplyOperation.apply(num1, num2));
                        break;
                    case "/":
                        result = executor.submit(() -> divideOperation.apply(num1, num2));
                        break;
                    default:
                        System.out.println("Invalid operation!");
                        continue;
                }

                if (result != null) {
                    System.out.println("Result: " + result.get());
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter valid numbers.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        executor.shutdown();
        scanner.close();
    }
}
