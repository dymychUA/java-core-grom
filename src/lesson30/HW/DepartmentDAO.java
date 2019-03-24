package lesson30.HW;

import java.util.HashSet;

public class DepartmentDAO {

    private HashSet<Department> departments = new HashSet<>();

    public HashSet<Department> getDepartments() {
        return departments;
    }

    public Department add(Department department) {
        departments.add(department);
        return department;
    }

    public void remove(Department department) {
        departments.remove(department);
    }

}
