// File: EmployeeManager.java
public class EmployeeManager {
    private Employee[] employees;
    private int count;

    public EmployeeManager(int size) {
        employees = new Employee[size];
        count = 0;
    }

    // Add Employee
    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count++] = emp;
            System.out.println("✅ Added: " + emp.name);
        } else {
            System.out.println("❌ Array is full. Cannot add more employees.");
        }
    }

    // Search by ID
    public Employee searchById(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id)
                return employees[i];
        }
        return null;
    }

    // Traverse all employees
    public void listEmployees() {
        System.out.println("\n📋 Employee List:");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete by ID
    public void deleteById(int id) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                // Shift left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                found = true;
                System.out.println("🗑️ Deleted employee ID: " + id);
                break;
            }
        }
        if (!found) {
            System.out.println("❌ Employee not found.");
        }
    }
}
