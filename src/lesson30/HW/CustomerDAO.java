package lesson30.HW;

import java.util.HashSet;

public class CustomerDAO {

    private HashSet<Customer> customers = new HashSet<>();

    public HashSet<Customer> getCustomers() {
        return customers;
    }

    public Customer add(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public void remove(Customer customer) {
        customers.remove(customer);
    }
}
