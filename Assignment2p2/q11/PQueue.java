package Assignment2p2.q11;

import java.util.PriorityQueue;

public class PQueue {
    public static void main(String[] args) {
        int[] arr = {1, 2, 10, 8, 7, 3, 4, 6, 5, 9};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int j = 0; j < arr.length; j++) {
            minHeap.add(j);
        }
        while(!minHeap.isEmpty()){
            System.err.println(minHeap.poll());
        }
    }
}