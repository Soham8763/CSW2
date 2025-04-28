package Assignment2p1.q1;
public class Student <T>{
    String name;
    T rollNumber;
    int age;
    public Student(String name,T rollNumber,int age){
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;
    }
    public void display(){
        System.out.println("Name: "+name+" Age: "+age+" RollNumber: "+rollNumber);
    }
    public static void main(String[] args) {
        Student<Integer> s1 = new Student<>("Soham", 28, 20);
        s1.display();
        Student<String> s2 = new Student<>("Soham", "28", 20);
        s2.display();
    }
}