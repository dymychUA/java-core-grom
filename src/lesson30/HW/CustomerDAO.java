package lesson30.HW;

import java.util.Collection;
import java.util.HashSet;

public class CustomerDAO {

    private static HashSet<Customer> customers = new HashSet<>();

    public HashSet<Customer> getCustomers() {
        return customers;
    }

    public Customer add(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public Collection<Customer> add(Collection<Customer> customersCollection) {
        customers.addAll(customersCollection);
        return customers;
    }

    public void remove(Customer customer) {
        customers.remove(customer);
    }
}
