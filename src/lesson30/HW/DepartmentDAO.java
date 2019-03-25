package lesson30.HW;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO {

    private static HashSet<Department> departments = new HashSet<>();

    public HashSet<Department> getDepartments() {
        return departments;
    }

    public Department add(Department department) {
        departments.add(department);
        return department;
    }

    public Collection<Department> add(Collection<Department> departmentsCollection) {
        departments.addAll(departmentsCollection);
        return departments;
    }

    public void remove(Department department) {
        departments.remove(department);
    }

}
