package Assignment4.q6;

import java.util.*;

public class MemoryIntense {
    public static void calcMemoryUsage(String message){
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long usedMemory = totalMemory-freeMemory;
        System.out.println(message);
        System.out.println("Total memory: "+totalMemory+"\nFree memory: "+freeMemory+"\nUsed Memory:"+usedMemory);
    }
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        try{
            for (int i = 0; i < 1000; i++) {
                list.add(new String(""));
                if(i%500 == 0){
                    calcMemoryUsage("Memory used after: "+i+" object creation");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.gc();
        calcMemoryUsage("final");
    }
}