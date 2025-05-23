package Assignment7.q1;
interface StringProcessor{
    int length(String s);
}
public class q1 {
    public static void main(String[] args) {
        StringProcessor sp = (String s) -> s.length();
        System.out.println(sp.length("Hello"));
    }
}
