package lesson30.HW;

import java.util.Collection;
import java.util.HashSet;

public class ProjectDAO {

    private static HashSet<Project> projects = new HashSet<>();

    public HashSet<Project> getProjects() {
        return projects;
    }

    public Project add(Project project) {
        projects.add(project);
        return project;
    }

    public Collection<Project> add(Collection<Project> projectsCollection) {
        projects.addAll(projectsCollection);
        return projects;
    }

    public void remove(Project project) {
        projects.remove(project);
    }

}
