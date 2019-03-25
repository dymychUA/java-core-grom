package lesson30.HW;

import java.util.Collection;
import java.util.HashSet;

public class EmployeeDAO {

    private static HashSet<Employee> employees = new HashSet<>();
    private DepartmentDAO departmentDAO = new DepartmentDAO();

    public HashSet<Employee> getEmployees() {
        return employees;
    }

    public Employee add(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Collection<Employee> add(Collection<Employee> employeesCollection) {
        employees.addAll(employeesCollection);
        return employees;
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }
}
