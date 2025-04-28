package Assignment2p2.q8;
import java.util.*;
public class Anagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string");
        String s1 = sc.nextLine();
        System.out.println("Enter the second string");
        String s2 = sc.nextLine();
        System.out.println(isAnagram(s1,s2));
        sc.close();
    }
    public static boolean isAnagram(String s1,String s2){
        if(s1.length() != s2.length()){
            System.out.println("Not Anagrams");
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }else{
                map.put(ch, map.get(ch)+1);
            }
        }
        for (char ch : s2.toCharArray()) {
            if(!map.containsKey(ch)){
                return false;
            }
            map.put(ch, map.get(ch)-1);
            if(map.get(ch) == 0){
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }
}
