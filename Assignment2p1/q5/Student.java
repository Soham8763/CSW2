package Assignment2p1.q5;

public class Student implements Comparable<Student>{
    private String name; private int rollNumber; private double totalMark;
    public Student(String name, int rollNumber, double totalMark) {
    this.name = name;
    this.rollNumber = rollNumber;
    this.totalMark = totalMark;
    }
    public String getName() {
        return name;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public double getTotalMark() {
        return totalMark;
    }
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", TotalMarks: " + totalMark;
    }
    public int compareTo(Student s) {
        return Double.compare(this.totalMark, s.rollNumber);
    }
    public static Student[] bubbleSortStudents(Student[] students){
        for (int i = 0; i < students.length-1; i++) {
            for (int j = 0; j < students.length-1-i; j++) {
                if(students[j].compareTo(students[j+1])>0){
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        return students;
    }
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("Sayantan", 102, 95.5);
        students[1] = new Student("Rounak", 103, 88.0);
        students[2] = new Student("Srinjoy", 101, 92.0);
        students = bubbleSortStudents(students);
        System.out.println("Sorted student details:");
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}