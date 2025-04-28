package Assignment2p2.q6;
import java.util.*;
public class Tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < 4; i++) {
            tree.add(i);
        }
        for(Integer elem:tree){
            System.out.println(elem);
        }
        System.out.println("Enter a number");
        int number = sc.nextInt();
        if(tree.contains(number)){
            System.out.println("exists");
        }else{
            System.out.println("Doesn't exists");
        }
        System.out.println("Enter a number you want to remove");
        int numberDelete = sc.nextInt();
        tree.remove(numberDelete);
        for(Integer elem:tree){
            System.out.println(elem);
        }
        sc.close();
    }
}