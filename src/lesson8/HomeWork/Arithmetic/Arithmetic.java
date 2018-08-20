package lesson8.HomeWork.Arithmetic;

import java.util.Arrays;

public class Arithmetic {

    boolean check(int[] array) {
        if (array.length == 0)
            return false;
        //if (array.length == 1)
        //    return array[0] > 100;
        Arrays.sort(array);
        return array[0] + array[array.length - 1] > 100;
    }
}
