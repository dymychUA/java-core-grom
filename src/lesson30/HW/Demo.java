package lesson30.HW;

public class Demo {

    public static void main(String[] args) {

        Initializer initializer = new Initializer();
        initializer.initialize();

        Controller controller = new Controller();

        System.out.println("");

        System.out.println("employeesByProject:");
        System.out.println(controller.employeesByProject("CRM Oracle 1"));
        System.out.println("-------------------------------------------------------");
        System.out.println("");

        System.out.println("projectsByEmployee:");
        System.out.println(controller.projectsByEmployee(Initializer.employeeForTest));
        System.out.println("-------------------------------------------------------");
        System.out.println("");

        System.out.println("employeesByDepartmentWithoutProject:");
        System.out.println(controller.employeesByDepartmentWithoutProject(DepartmentType.DEVELOPMENT_DEPARTMENT));
        System.out.println("-------------------------------------------------------");
        System.out.println("");

        System.out.println("employeesWithoutProject:");
        System.out.println(controller.employeesWithoutProject());
        System.out.println("-------------------------------------------------------");
        System.out.println("");

        System.out.println("employeesByTeamLead:");
        System.out.println(controller.employeesByTeamLead(Initializer.leadForTest));
        System.out.println("-------------------------------------------------------");
        System.out.println("");

        System.out.println("teamLeadsByEmployee:");
        System.out.println(controller.teamLeadsByEmployee(Initializer.employeeForTest));
        System.out.println("-------------------------------------------------------");
        System.out.println("");

        System.out.println("employeesByProjectEmployee:");
        System.out.println(controller.employeesByProjectEmployee(Initializer.employeeForTest));
        System.out.println("-------------------------------------------------------");
        System.out.println("");

        System.out.println("projectsByCustomer:");
        System.out.println(controller.projectsByCustomer(Initializer.customerForTest));
        System.out.println("-------------------------------------------------------");
        System.out.println("");

        System.out.println("employeesByCustomerProjects:");
        System.out.println(controller.employeesByCustomerProjects(Initializer.customerForTest));
        System.out.println("-------------------------------------------------------");
        System.out.println("");

    }

}
