package Assignment2p2.q10;

import java.util.*;

public class Missing {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int elem = missingNumber(arr);
        if(elem == -1){
            System.out.println("No missing numbers in the given array");
        }else{
            System.out.println("The missing number is : "+elem);
        }
    }
    public static int missingNumber(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int elem : arr) {
            map.put(elem, 1);
        }
        for (int i = 1; i <=10 ; i++) {
            if(!map.containsKey(i)){
                return i;
            }
        }
        return -1;
    }
}
