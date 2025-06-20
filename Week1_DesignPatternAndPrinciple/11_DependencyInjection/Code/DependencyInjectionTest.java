// File: DependencyInjectionTest.java
public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Inject the dependency
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        // Use the service
        service.showCustomerDetails(101);
    }
}
