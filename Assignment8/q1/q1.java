package Assignment8.q1;

public class q1 {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();

        MultiplicationThread multThread = new MultiplicationThread(5); 
        multThread.start();

        try {
            sumThread.join();
            multThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("\nBoth threads have completed their tasks!");
    }
}

class SumThread extends Thread {
    @Override
    public void run() {
        System.out.println("Starting sum calculation...");
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
            try {
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                System.out.println("Sum thread interrupted: " + e.getMessage());
                return;
            }
        }
        System.out.println("Sum of first 100 natural numbers: " + sum);
    }
}

class MultiplicationThread extends Thread {
    private int number;

    public MultiplicationThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Starting multiplication table for " + number + "...");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Multiplication thread interrupted: " + e.getMessage());
                return;
            }
        }
    }
}
