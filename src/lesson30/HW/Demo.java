package lesson30.HW;

public class Demo {

    public static void main(String[] args) {

        Initializer initializer = new Initializer();
        initializer.initialize();

        Controller controller = new Controller();

        System.out.println(controller.employeesByProject("CRM Oracle 1"));
        System.out.println(controller.projectsByEmployee(null));
        System.out.println(controller.employeesByDepartmentWithoutProject(DepartmentType.DESIGN_DEPARTMENT));
        System.out.println(controller.employeesWithoutProject());
        System.out.println(controller.employeesByTeamLead(null));
        System.out.println(controller.teamLeadsByEmployee(null));
        System.out.println(controller.employeesByProjectEmployee(null));
        System.out.println(controller.projectsByCustomer(null));
        System.out.println(controller.employeesByCustomerProjects(null));

    }

}
