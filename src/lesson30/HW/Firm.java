package lesson30.HW;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

public class Firm {

    private Date dateFounded;
    private String name;
    private HashSet<Department> departments;
    private HashSet<Customer> customers;

    public Firm(Date dateFounded, String name) {
        this.dateFounded = dateFounded;
        this.name = name;
    }

    public Firm(Date dateFounded, String name, HashSet<Department> departments, HashSet<Customer> customers) {
        this.dateFounded = dateFounded;
        this.name = name;
        this.departments = departments;
        this.customers = customers;
    }

    public Firm(Date dateFounded, String name, HashSet<Department> departments, Customer customer) {
        this.dateFounded = dateFounded;
        this.name = name;
        this.departments = departments;
        this.addCustomer(customer);
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public String getName() {
        return name;
    }

    public HashSet<Department> getDepartments() {
        return departments;
    }

    public HashSet<Customer> getCustomers() {
        return customers;
    }

    public void setDepartments(HashSet<Department> departments) {
        this.departments = departments;
    }

    public void setCustomers(HashSet<Customer> customers) {
        this.customers = customers;
    }

    public HashSet<Department> addDepartment(Department department) {

        if (department == null)
            return null;

        this.departments.add(department);
        return this.departments;
    }

    public HashSet<Customer> addCustomer(Customer customer) {

        if (customer == null)
            return null;

        this.customers.add(customer);
        return this.customers;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "dateFounded=" + dateFounded +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Firm firm = (Firm) o;
        return Objects.equals(dateFounded, firm.dateFounded) &&
                Objects.equals(name, firm.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateFounded, name);
    }
}

