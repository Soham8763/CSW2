package Assignment4.q5;

public class MemoryUsage {
    private static int num1;
    private static double num2;
    public MemoryUsage(int num1, double num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    public void getIntVal(){
        System.out.println(num1);
    }
    public void getDblVal(){
        System.out.println(num2);
    }
    public void setIntval(int num1){
        this.num1 = num1;
    }
    public void setDblval(double num2){
        this.num2 = num2;
    }
    public void displayValues(){
        System.out.println("Int val: "+num1);
        System.out.println("Double val: "+num2);
    }
    public static void calcMemoryUsage(){
        Runtime runtime = Runtime.getRuntime();
        long totMem = runtime.totalMemory();
        long freeMem = runtime.freeMemory();
        long usedMem = totMem-freeMem;
        System.out.println("Total memory: "+totMem+"\nFree memory: "+freeMem+"\nUsed memory: "+usedMem);
    }
    public static void main(String[] args) {
        calcMemoryUsage();
        MemoryUsage obj1 = new MemoryUsage(10, 20.5);
        MemoryUsage obj2 = new MemoryUsage(30, 40.8);
        obj1.setIntval(15); obj1.setDblval(25.5);
        obj2.setIntval(35); obj2.setDblval(45.5);
        System.out.print("\nObject 1: ");
        obj1.displayValues();
        System.out.print("Object 2: ");
        obj2.displayValues();
        System.out.println("Memory usage after Obj creation");
        calcMemoryUsage();
        System.gc();
        System.out.println("Memory usage after Garbage Collection");
        calcMemoryUsage();
    }
}