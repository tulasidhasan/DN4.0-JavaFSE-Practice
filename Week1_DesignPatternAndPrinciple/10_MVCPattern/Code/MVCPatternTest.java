// File: MVCPatternTest.java
public class MVCPatternTest {
    public static void main(String[] args) {
        // Create model
        Student student = new Student("Tulasi", 113, "A");

        // Create view
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Display initial data
        controller.updateView();

        // Update model data
        controller.setStudentName("Tulasi S");
        controller.setStudentGrade("A+");

        // Display updated data
        controller.updateView();
    }
}
