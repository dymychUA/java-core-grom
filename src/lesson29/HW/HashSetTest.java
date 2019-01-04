package lesson29.HW;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetTest {

    public static Set<Order> useHashSet() {

        String[] shops = {"Rozetka", "Sokol", "Allo", "Comfy", "Foxtrot", "Eldorado", "Metro"};
        String[] goods = {"Nokia 3310", "Lenovo Yoga", "SD Card 32 Gb", "IPhone X", "Logitech M235", "Samsung TV 55", "Cooper&Hunter"};

        Set<Order> set = new HashSet<>();
        Set<Order> set1 = new HashSet<>();

        Order order1 = new Order(1, 1000, "UAH", "Black Box", "Rozetka");
        Order order2 = new Order(2, 2000, "UAH", "White Box", "Eldorado");
        Order order3 = new Order(3, 3000, "UAH", "Pink Box", "Allo");
        Order order4 = new Order(4, 4000, "UAH", "Blue Box", "Foxtrot");
        Order order5 = new Order(5, 5000, "UAH", "Green Box", "Rozetka");

        for (int i = 0; i < 6; i++) {
            set.add(new Order(i, 100 * i, "UAH", goods[i], shops[i]));
        }

        set1.add(order1);
        set1.add(order2);
        set1.add(order3);
        set1.add(order4);
        set1.add(order5);

        set.addAll(set1);
        set.retainAll(set1);

        set.add(order2);
        set.remove(1);
        set.remove(order2);

        Object[] arr = set.toArray();

        set.clear();

        set.addAll(set1);
        int size = set.size();
        set.addAll(set1);
        size = set.size();
        set.add(order1);

        return set;
    }
}
