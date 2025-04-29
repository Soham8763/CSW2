package Assignment2p1.q4;

public class Student implements Comparable<Student>{
    private String name;
    private int rollNumber;
    private double totalMark;

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

    public int compareTo(Student s){
        return Double.compare(this.totalMark, s.rollNumber);
    }

    public static Student findStudent(Student[] students,int rollNo){
        for (int i = 0; i < students.length; i++) {
            if(students[i].getRollNumber() == rollNo){
                return students[i];
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("Abhishek", 101, 95.5);
        students[1] = new Student("Chayan", 102, 88.0);
        students[2] = new Student("Prithwish", 103, 92.0);
        int searchRollNo = 102;
        Student searchStudent = findStudent(students,searchRollNo);
        System.out.println(searchStudent.toString());
    }
}
