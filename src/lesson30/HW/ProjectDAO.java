package lesson30.HW;

import java.util.HashSet;

public class ProjectDAO {

    private HashSet<Project> projects = new HashSet<>();

    public HashSet<Project> getProjects() {
        return projects;
    }

    public Project add(Project project) {
        projects.add(project);
        return project;
    }

    public void remove(Project project) {
        projects.remove(project);
    }

}
