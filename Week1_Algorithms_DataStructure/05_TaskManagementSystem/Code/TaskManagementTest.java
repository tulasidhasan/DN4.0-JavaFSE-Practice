// File: TaskManagementTest.java
public class TaskManagementTest {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task(1, "Design Module", "Pending"));
        taskList.addTask(new Task(2, "Code Review", "In Progress"));
        taskList.addTask(new Task(3, "Testing", "Not Started"));

        taskList.listTasks();

        System.out.println("\n🔍 Searching Task with ID 2:");
        Task t = taskList.searchTask(2);
        System.out.println(t != null ? t : "Not Found");

        System.out.println("\n🧹 Deleting Task with ID 1:");
        taskList.deleteTask(1);

        taskList.listTasks();
    }
}
