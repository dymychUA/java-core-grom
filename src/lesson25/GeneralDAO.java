package lesson25;

public class GeneralDAO<T> {

    private T[] dBase = (T[])new Object[10];

    private void print(Order order) {
        System.out.println("order is:" + order.toString());
    }

    public <T extends IdEntity> void validate(T t) throws Exception {
        if (t.getId() < 0) {
            throw new Exception("id can't be negative");
        }
    }

    public <K> void validate(K k) {
        if (k.equals(100)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public T save(T t) throws Exception {

        int index = 0;

        for (T entity : dBase) {
            if (entity == null) {
                dBase[index] = t;
                return dBase[index];
            }
            index++;
        }

        throw new Exception("No enough space in DBase");
    }

    public T[] getAll() {
        return dBase;
    }
}
