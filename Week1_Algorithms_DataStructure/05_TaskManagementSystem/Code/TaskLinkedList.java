// File: TaskLinkedList.java
public class TaskLinkedList {
    private Node head;

    // Node class
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Add task to end
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        System.out.println("✅ Added: " + task.taskName);
    }

    // Search by ID
    public Task searchTask(int id) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.taskId == id)
                return temp.task;
            temp = temp.next;
        }
        return null;
    }

    // Traverse all tasks
    public void listTasks() {
        System.out.println("\n📋 Task List:");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    // Delete task by ID
    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("❌ No tasks to delete.");
            return;
        }

        if (head.task.taskId == id) {
            head = head.next;
            System.out.println("🗑️ Deleted task ID: " + id);
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.task.taskId == id) {
                current.next = current.next.next;
                System.out.println("🗑️ Deleted task ID: " + id);
                return;
            }
            current = current.next;
        }

        System.out.println("❌ Task not found.");
    }
}
