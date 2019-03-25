package lesson30.HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Initializer {

    private FirmDAO firmDAO = new FirmDAO();
    private CustomerDAO customerDAO = new CustomerDAO();
    private DepartmentDAO departmentDAO = new DepartmentDAO();
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private ProjectDAO projectDAO = new ProjectDAO();


    //TEST DATA
    public static Employee employeeForTest;
    public static Employee leadForTest;
    public static Customer customerForTest;


    public void initialize() {

        Department dep_design = new Department(DepartmentType.DESIGN_DEPARTMENT);
        Department dep_admin = new Department(DepartmentType.ADMINISTRATIVE_DEPARTMENT);
        Department dep_dev = new Department(DepartmentType.DEVELOPMENT_DEPARTMENT);
        Department dep_sale = new Department(DepartmentType.SALES_DEPARTMENT);
        Department dep_fin = new Department(DepartmentType.FINANCIAL_DEPARTMENT);
        departmentDAO.add(Arrays.asList(dep_admin, dep_design, dep_dev, dep_fin, dep_sale));

        Customer customerToyota = new Customer("TOYOTA", "Japan", 100_000);
        Customer customerIBM = new Customer("IBM", "USA", 400_000);
        Customer customerBNP = new Customer("BNP Paris Bank", "France", 750_000);
        customerDAO.add(Arrays.asList(customerToyota, customerIBM, customerBNP));

        Firm firm = new Firm(new Date(1970, 01, 01), "Microsoft Co", departmentDAO.getDepartments(), customerDAO.getCustomers());
        firmDAO.add(firm);

        Project project_1 = new Project("CRM Oracle 1", customerIBM);
        Project project_2 = new Project("MS AXAPTA", customerToyota);
        Project project_3 = new Project("SAP", customerBNP);
        Project project_4 = new Project("1C", customerToyota);
        Project project_5 = new Project("CRM Terrasoft", customerBNP);
        projectDAO.add(Arrays.asList(project_1, project_2, project_3, project_4, project_5));

        Employee employee_1 = new Employee("Asir", "Ahmat", new Date(2015, 12, 11), Position.DEVELOPER, dep_dev);
        Employee employee_2 = new Employee("Nick", "Vuichich", new Date(2015, 12, 11), Position.DEVELOPER, dep_dev);
        Employee employee_3 = new Employee("John", "Smith", new Date(2015, 12, 11), Position.DEVELOPER, dep_dev);
        Employee employee_4 = new Employee("Anna", "Petrova", new Date(2015, 12, 11), Position.FINANCE, dep_fin);
        Employee employee_5 = new Employee("Ihor", "Zhmot", new Date(2015, 12, 11), Position.MANAGER, dep_sale);
        Employee employee_6 = new Employee("Sara", "O'Connor", new Date(2015, 12, 11), Position.DESIGNER, dep_design);
        Employee employee_7 = new Employee("Vu", "Chong", new Date(2015, 12, 11), Position.DEVELOPER, dep_dev);
        Employee employee_8 = new Employee("Ali", "Ibn Abdul", new Date(2015, 12, 11), Position.DEVELOPER, dep_dev);
        Employee employee_9 = new Employee("Petro", "Soroka", new Date(2015, 12, 11), Position.DEVELOPER, dep_dev);
        Employee employee_lead_1 = new Employee("Semen", "Petlura", new Date(2015, 12, 11), Position.TEAM_LEAD, dep_dev);
        Employee employee_lead_2 = new Employee("Joe", "Cocker", new Date(2015, 12, 11), Position.TEAM_LEAD, dep_dev);
        employeeDAO.add(Arrays.asList(employee_1, employee_2, employee_3, employee_4, employee_5, employee_6, employee_7, employee_8, employee_9, employee_lead_1, employee_lead_2));

        dep_design.addEmployee(employee_6);
        dep_dev.addEmployee(Arrays.asList(employee_1, employee_2, employee_3, employee_7, employee_8, employee_9, employee_lead_1, employee_lead_2));
        dep_fin.addEmployee(employee_4);
        dep_sale.addEmployee(employee_5);

        employee_lead_1.addProject(project_1);
        employee_lead_1.addProject(project_2);
        employee_lead_1.addProject(project_3);
        employee_lead_2.addProject(project_4);
        employee_lead_2.addProject(project_5);

        employee_1.addProject(project_1);
        employee_1.addProject(project_2);
        employee_2.addProject(project_2);
        employee_2.addProject(project_3);
        employee_7.addProject(project_3);
        employee_8.addProject(project_3);
        employee_7.addProject(project_3);
        employee_8.addProject(project_4);
        employee_9.addProject(project_5);

        employeeForTest = employee_8;
        leadForTest = employee_lead_2;
        customerForTest = customerBNP;

    }

}