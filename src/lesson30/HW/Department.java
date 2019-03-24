package lesson30.HW;

import java.util.HashSet;
import java.util.Objects;

public class Department {

    private DepartmentType type;

    private HashSet<Employee> employees;

    public Department(DepartmentType type, Employee lead, HashSet<Employee> employees) {
        this.type = type;
        this.employees = employees;
    }
    public Department(DepartmentType type, Employee lead, Employee employee) {
        this.type = type;
        this.employees.add(employee);
    }

    public DepartmentType getType() {
        return type;
    }

    public HashSet<Employee> getEmployees() {
        return employees;
    }

    public HashSet<Employee> addEmployee(Employee employee) {

        if (employee == null)
            return null;

        this.employees.add(employee);
        return employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "type=" + type +
                ", employees=" + employees +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
