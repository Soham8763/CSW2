package Assignment7.q5;
import java.util.function.Function;
public class q5 {
    public static Function<Integer, Integer> getSquare() {
        return x -> x * x;
    }
    public static void main(String[] args) {
        Function<Integer,Integer> square = getSquare();
        System.out.println(square.apply(3));
        System.out.println(square.apply(4));
        System.out.println(square.apply(5));
        System.out.println(square.apply(6));
    }
}
