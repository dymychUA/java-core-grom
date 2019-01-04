package lesson27.HW.LinkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

    public static LinkedList<Order> useList() {

        String[] shops = {"Rozetka", "Sokol", "Allo", "Comfy", "Foxtrot", "Eldorado", "Metro"};
        String[] goods = {"Nokia 3310", "Lenovo Yoga", "SD Card 32 Gb", "IPhone X", "Logitech M235", "Samsung TV 55", "Cooper&Hunter"};

        LinkedList<Order> list = new LinkedList<>();
        LinkedList<Order> list1 = new LinkedList<>();

        list1.add(new Order(1, 1000, "UAH", "Black Box", "Rozetka"));
        list1.add(new Order(2, 2000, "UAH", "White Box", "Eldorado"));

        for (int i = 0; i < 6; i++) {
            list.add(new Order(i, 100 * i, "UAH", goods[i], shops[i]));
        }

        Order order = list.get(0);

        list.add(0, list1.get(0));

        list.remove(1);

        list.remove(list1.get(0));

        list.addAll(list1);

        List<Order> list2 = list.subList(2, 4);

        list.set(0, list1.get(1));

        boolean isConatain = list.contains(list1.get(0));

        Object[] arr = list.toArray();

        list.clear();

        list.addAll(list1);
        list.addAll(list1);
        list.add(order);

        return list;
    }
}
