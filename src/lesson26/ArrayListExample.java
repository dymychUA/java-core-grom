package lesson26;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {

        int[] test = new int[5];
        test[0] = 10;

        int[] test1 = {1, 2, 3};


        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(12);
        list.add(7);
        System.out.println(list.toString());

        list.remove(0);
        System.out.println(list.toString());

        list.add(11);
        list.add(11);
        System.out.println(list.toString());

        list.add(2, 33);
        System.out.println(list.toString());

        ArrayList<Integer> list1 = new ArrayList<>();
        list.add(0);
        list.add(0);

        list.addAll(list1);
        System.out.println(list.toString());

        list.set(3, 555);
        System.out.println(list.toString());

        list.clear();
        System.out.println(list);
    }
}
