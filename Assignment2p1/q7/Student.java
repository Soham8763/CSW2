package Assignment2p1.q7;
import java.util.*;
public class Student {
    String name;
    int rollNo;
    int age;
    Student(String name, int rollNo, int age) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
    }
    public String toString() {
        return "Name: " + name + ", Roll No.: " + rollNo + ", Age: " + age;
    }
    public static void main(String[] args) {
        Student[] students = {
            new Student("Ankan", 3, 20),
            new Student("Sayan", 2, 22),
            new Student("Rudranil", 1, 21)
        };
        System.out.println("\nStudents sorted on basis of Age");
        Arrays.sort(students,new Comparator<Student>(){
            public int compare(Student s1,Student s2){
                return Integer.compare(s1.age, s2.age);
            }
        });
        for (Student student : students) {
            System.out.println(student.toString());
        }
        System.out.println("\nStudents sorted on basis of RollNo");
        Arrays.sort(students,new Comparator<Student>(){
            public int compare(Student s1,Student s2){
                return Integer.compare(s1.rollNo, s2.rollNo);
            }
        });
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}