package lesson24.exercise;

public class SystemDAO {

    private Sys[] systems = new Sys[5];

    public Sys save(Sys system) {

        int index = 0;

        for (Sys sys : systems) {
            if (sys == null) {
                systems[index] = system;
                return systems[index];
            }
            index++;
        }

        return null;
    }
}
