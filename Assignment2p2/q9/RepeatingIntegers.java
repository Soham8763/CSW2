package Assignment2p2.q9;

import java.util.HashSet;

public class RepeatingIntegers {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 2, 6, 7, 1};
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> repeating = new HashSet<>();
        for (Integer elem : arr) {
            if(seen.contains(elem)){
                repeating.add(elem);
            }else{
                seen.add(elem);
            }
        }
        System.out.println("Repeating elements: "+repeating);
    }
}