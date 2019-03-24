package lesson30.HW;

import java.util.HashSet;

public class FirmDAO {

    private HashSet<Firm> firms = new HashSet<>();

    public HashSet<Firm> getFirms() {
        return firms;
    }

    public Firm add(Firm firm) {
        firms.add(firm);
        return firm;
    }

    public void remove(Firm firm) {
        firms.remove(firm);
    }

}
