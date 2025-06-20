// File: EmployeeSystemTest.java
public class EmployeeSystemTest {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee(1, "Alice", "Developer", 60000));
        manager.addEmployee(new Employee(2, "Bob", "Manager", 80000));
        manager.addEmployee(new Employee(3, "Charlie", "Tester", 50000));

        manager.listEmployees();

        System.out.println("\n🔍 Searching for employee with ID 2:");
        Employee e = manager.searchById(2);
        System.out.println(e != null ? e : "Not Found");

        System.out.println("\n❌ Deleting employee with ID 1:");
        manager.deleteById(1);

        manager.listEmployees();
    }
}
