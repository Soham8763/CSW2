package Assignment4.q7;

public class Student {
    private static String name;
    private static String subject;
    public Student(String name,String subject){
        this.name = name;
        this.subject = subject;
    }
    public static void displayStudentDetails(){
        System.out.println("Student Name: " + name + ", Course Name: " +subject);
    }
    public static void calcMemoryUsage(String message){
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long usedMemory = totalMemory-freeMemory;
        System.out.println(message);
        System.out.println("Total memory: "+totalMemory+"\nFree memory: "+freeMemory+"\nUsed Memory:"+usedMemory);
    }
    public static void main(String[] args) {
        calcMemoryUsage("Initial memory usage");
        Student s1 = new Student("Soham","Maths");
        Student s2 = new Student("Falhana","Dhimkana");
        s1.displayStudentDetails();
        s2.displayStudentDetails();
        calcMemoryUsage("Memory usage after Object creation");
        s1 = null;s2 = null;
        System.gc();
        calcMemoryUsage("Memory usage after Garbage Collection");
    }
}