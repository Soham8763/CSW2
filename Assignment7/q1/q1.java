package Assignment7.q1;

@FunctionalInterface
interface StringProcessor {
    int process(String str);
}

public class q1 {
    public static void main(String[] args) {
        StringProcessor lengthProcessor = s -> s.length();

        String test = "Hello, world!";
        int len = lengthProcessor.process(test);

        System.out.println("Length of the string: " + len);
    }
}
