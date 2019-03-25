package lesson30.HW;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;
    private Date dateHired;
    private Position position;
    private Department department;
    private HashSet<Project> projects = new HashSet<>();

    public Employee(String firstName, String lastName, Date dateHired, Position position, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = dateHired;
        this.position = position;
        this.department = department;
    }

    public Employee(String firstName, String lastName, Date dateHired, Position position, Department department, HashSet<Project> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = dateHired;
        this.position = position;
        this.department = department;
        this.projects = projects;
    }


    public Employee(String firstName, String lastName, Date dateHired, Position position, Department department, Project project) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = dateHired;
        this.position = position;
        this.department = department;
        this.addProject(project);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public Position getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    public HashSet<Project> getProjects() {
        return projects;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setProjects(HashSet<Project> projects) {
        this.projects = projects;
    }

    public HashSet<Project> addProject(Project project) {

        if (project == null)
            return null;

        this.projects.add(project);
        return projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateHired=" + dateHired +
                ", position=" + position +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(dateHired, employee.dateHired) &&
                position == employee.position &&
                Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateHired, position, department);
    }
}
