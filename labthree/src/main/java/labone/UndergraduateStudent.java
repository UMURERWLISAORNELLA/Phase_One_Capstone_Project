package labone;

public class UndergraduateStudent extends Student{

    public UndergraduateStudent(String name, String email, String studentId, int grade) {
        super(name, email, studentId, grade);
    }

    @Override
    public double calculateGPA() {
        return super.calculateGPA() + 0.3; // undergrads get a small GPA boost
    }

    @Override
    public String toString() {
        return "Undergraduate " + super.toString();
    }
}
