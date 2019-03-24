package lesson30.HW;

import java.util.Objects;

public class Project {

    private String name;
    private Customer customer;
    private Employee lead;

    public Project(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }

    public Project(String name, Customer customer, Employee lead) {
        this.name = name;
        this.lead = lead;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Employee getLead() {
        return lead;
    }

    public void setLead(Employee lead) {
        this.lead = lead;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", customer=" + customer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name) &&
                Objects.equals(customer, project.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, customer);
    }
}
