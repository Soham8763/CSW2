package Assignment2p2.q4;
import java.util.*;
public class Student {
    private String name;
    private int age;
    private double mark;
    public Student(String name,int age,double mark){
        this.name = name;
        this.age = age;
        this.mark = mark;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getMark() {
        return mark;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setMark(double mark) {
        this.mark = mark;
    }
    public boolean equals(Student obj){
        if(this == obj){
            return true;
        }
        if(obj == null && getClass()!= obj.getClass()){
            return false;
        }
        Student student = (Student) obj;
        return age == student.age && Double.compare(student.mark,mark) == 0 && name.equals(student.name);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Student> students = new LinkedList<>();
        students.add(new Student("Soham", 19, 89));
        students.add(new Student("Ankush", 20, 90));
        students.add(new Student("Kushan", 29, 98));
        students.add(new Student("Satish", 20, 87));
        for(Student student: students){
            System.out.println(student);
        }
        System.out.println("Enter a student detail to check");
        System.out.println("Enter the name");
        String nameCheck = sc.nextLine();
        System.out.println("Enter the age");
        int ageCheck = sc.nextInt();
        System.out.println("Enter the mark");
        double markCheck = sc.nextDouble();
        Student searchStudent = new Student(nameCheck, ageCheck, markCheck);
        if(students.contains(searchStudent)){
            System.out.println("Exists");
        }else{
            System.out.println("Doesn't Exists");
        }
        System.out.println("\nEnter the Student you want to delete");
        System.out.println("Enter the name");
        String nameDelete = sc.nextLine();
        System.out.println("Enter the age");
        int ageDelete = sc.nextInt();
        System.out.println("Enter the mark");
        double markDelete = sc.nextDouble();
        Student deleteStudent = new Student(nameDelete, ageDelete, markDelete);
        students.remove(deleteStudent);
        System.out.println("Size of the Student list");
        students.size();
        sc.close();
    }
}