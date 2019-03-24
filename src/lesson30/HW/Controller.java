package lesson30.HW;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Controller {

    private FirmDAO firmDAO = new FirmDAO();
    private CustomerDAO customerDAO = new CustomerDAO();
    private DepartmentDAO departmentDAO = new DepartmentDAO();
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private ProjectDAO projectDAO = new ProjectDAO();

    public Controller() {

    }

    public List<Employee> employeesByProject(String projectName) {

        if (projectName.isEmpty() || projectName == null)
            return null;

        List<Employee> employees = new ArrayList<>();

        for (Employee employee : employeeDAO.getEmployees()) {
            for (Project project : employee.getProjects()) {
                if (projectName.equals(project.getName()))
                    employees.add(employee);
            }
        }

        return employees.size() == 0 ? null : employees;
    }

    public List<Project> projectsByEmployee(Employee employee) {

        if (employee == null)
            return null;

        List<Project> projects = new ArrayList<>();

        for (Employee currentEmployee : employeeDAO.getEmployees()) {
            if (employee.equals(currentEmployee)) {
                projects.addAll(employee.getProjects());
            }
            break;
        }

        return projects.size() == 0 ? null : projects;
    }

    public List<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {

        if (departmentType == null)
            return null;

        List<Employee> employees = new ArrayList<>();

        for (Department currentDepartment : departmentDAO.getDepartments()) {
            if (departmentType.equals(currentDepartment.getType())) {
                for (Employee currentEmployee : currentDepartment.getEmployees()) {
                    if (currentEmployee.getProjects().isEmpty())
                        employees.add(currentEmployee);
                }
            }
            break;
        }

        return employees.size() == 0 ? null : employees;
    }

    public List<Employee> employeesWithoutProject() {
        List<Employee> employees = new ArrayList<>();

        for (Employee currentEmployee : employeeDAO.getEmployees()) {
            if (currentEmployee.getProjects().isEmpty())
                employees.add(currentEmployee);
        }

        return employees.size() == 0 ? null : employees;
    }

    public Set<Employee> employeesByTeamLead(Employee lead) {

        if (lead == null)
            return null;

        Set<Employee> employees = new HashSet<>();

        for (Project project : projectDAO.getProjects()) {
            if (lead.equals(project.getLead())) {
                for (Employee employee : employeeDAO.getEmployees()) {
                    if (employee.getProjects().contains(project))
                        employees.add(employee);
                }
            }
        }

        return employees.size() == 0 ? null : employees;
    }

    public Set<Employee> teamLeadsByEmployee(Employee employee) {

        if (employee == null)
            return null;

        Set<Employee> employees = new HashSet<>();

        for (Project project : employee.getProjects()) {
            employees.add(project.getLead());
        }

        return employees.size() == 0 ? null : employees;
    }


    public Set<Employee> employeesByProjectEmployee(Employee employee) {

        if (employee == null)
            return null;

        Set<Employee> employees = new HashSet<>();

        for (Project project : employee.getProjects()) {
            employees.addAll(employeesByProject(project.getName()));
        }
        employees.remove(employee);

        return employees.size() == 0 ? null : employees;
    }

    public List<Project> projectsByCustomer(Customer customer) {

        if (customer == null)
            return null;

        List<Project> projects = new ArrayList<>();

        for (Project project : projectDAO.getProjects()) {
            if (customer.equals(project.getCustomer())) {
                projects.add(project);
            }
        }

        return projects.size() == 0 ? null : projects;
    }

    public Set<Employee> employeesByCustomerProjects(Customer customer) {

        if (customer == null)
            return null;

        Set<Employee> employees = new HashSet<>();

        for (Project project : projectsByCustomer(customer)) {
            employees.addAll(employeesByProject(project.getName()));
        }

        return employees.size() == 0 ? null : employees;
    }

}
