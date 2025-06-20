// File: StudentController.java
public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    // Update model data
    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    // Retrieve model data
    public String getStudentName() {
        return model.getName();
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public int getStudentId() {
        return model.getId();
    }

    // Update view
    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}
