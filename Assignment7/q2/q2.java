package Assignment7.q2;
@FunctionalInterface
interface Calculator{
    double oprerate(double a, double b);
}
public class q2 {
    public static void main(String[] args) {
        Calculator add = (a,b)-> a+b;
        System.out.println(add.oprerate(10, 20));
        Calculator subtract = (a,b)-> a-b;
        System.out.println(subtract.oprerate(10, 20));
        Calculator multiply = (a,b)-> a*b;
        System.out.println(multiply.oprerate(10, 20));
        Calculator divide = (a,b)-> a/b;
        System.out.println(divide.oprerate(10, 20));
    }
}
