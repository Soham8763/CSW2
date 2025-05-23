package Assignment7.q3;
import java.util.*;
public class q3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Java");
        list.add("Programming");
        list.add("Lambda");

        list.sort((s1,s2)->Integer.compare(s1.length(), s2.length()));
        for (String string : list) {
            System.out.println(string);
        }
    }
}
