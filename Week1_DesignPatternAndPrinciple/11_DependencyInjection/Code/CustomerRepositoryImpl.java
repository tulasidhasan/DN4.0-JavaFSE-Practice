// File: CustomerRepositoryImpl.java
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // In real apps, this would query a database
        return new Customer(id, "Tulasi Customer");
    }
}
