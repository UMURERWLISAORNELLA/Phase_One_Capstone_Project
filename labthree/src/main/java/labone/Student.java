
package labone;

public class Student extends Person{


    private String studentId;
    private int grade; // number between 0–100

    public Student(String name, String email, String studentId, int grade) {
        super(name, email);
        this.studentId = studentId;
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }

    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    // This will be overridden (polymorphism)
    public double calculateGPA() {
        return grade / 20.0; // simple base calculation
    }

    public String toString() {
        return "Student [" + super.toString() +
                ", Student ID: " + studentId +
                ", Grade: " + grade +
                ", GPA: " + calculateGPA() + "]";
    }
}
