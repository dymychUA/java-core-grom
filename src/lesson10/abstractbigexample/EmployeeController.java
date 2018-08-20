package lesson10.abstractbigexample;

public class EmployeeController {
    private Employee[] employees = new Employee[100];

    void paySalaryToEmployee() {
        for (Employee employee : employees) {
            employee.paySallary();
            System.out.println("Salary was paid successfully to " + employee.getName() + "employee");
        }
    }
}
