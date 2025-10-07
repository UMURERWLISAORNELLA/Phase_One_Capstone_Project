package labone;

public class GraduateStudent extends Student{

    public GraduateStudent(String name, String email, String studentId, int grade) {
        super(name, email, studentId, grade);
    }

    @Override
    public double calculateGPA() {
        return super.calculateGPA() - 0.2; // stricter grading for grads
    }

    @Override
    public String toString() {
        return "Graduate " + super.toString();
    }
}
