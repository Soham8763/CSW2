package Assignment7.q3;

import java.util.*;

public class q3 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
            "ankush",
            "soham",
            "prabhu",
            "zuniad",
            "parth"
        );

        System.out.println("Original list:");
        for (String str : strings) {
            System.out.println(str);
        }

        strings.sort((s1, s2) -> Integer.compare(s2.length(), s1.length()));

        System.out.println("\nSorted list (by length in descending order):");
        for (String str : strings) {
            System.out.println(str);
        }
    }
} 