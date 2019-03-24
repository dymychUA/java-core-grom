package lesson30.HW;

import java.util.HashSet;

public class EmployeeDAO {

    private HashSet<Employee> employees = new HashSet<>();

    public HashSet<Employee> getEmployees() {
        return employees;
    }

    public Employee add(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }
}
