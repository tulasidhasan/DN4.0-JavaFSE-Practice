// File: Student.java
public class Student {
    private String name;
    private int id;
    private String grade;

    // Constructor
    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters and Setters
    public String getName() { return name; }
    public int getId() { return id; }
    public String getGrade() { return grade; }

    public void setName(String name) { this.name = name; }
    public void setGrade(String grade) { this.grade = grade; }
}
