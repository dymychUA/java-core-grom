package lesson28;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {

    @Override
    public int compare(Capability o1, Capability o2) {

        if (compareFields(o1.getChannelName(), o2.getChannelName()) != 0)
            return compareFields(o1.getChannelName(), o2.getChannelName());
        else if (compareFields(o1.getFingerprint(), o2.getFingerprint()) != 0)
            return compareFields(o1.getFingerprint(), o2.getFingerprint());

        return compareFields(o1.getDateCreated(), o2.getDateCreated());
    }

    private <T extends Comparable<T>> int compareFields(T fieldCap1, T fieldCap2) {

        if (fieldCap1 == null) {
            return (fieldCap2 == null) ? 0 : 1;
        }

        if (fieldCap2 == null)
            return -1;

        if (!fieldCap1.equals(fieldCap2))
            return fieldCap1.compareTo(fieldCap2);

        return 0;
    }
}
