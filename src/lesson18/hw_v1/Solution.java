package lesson18.hw_v1;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findNumbers("as 23 2123 23 kj32  32k 23 1111111  &6786^  ((   ^%$  678")));
    }

    public static int[] findNumbers(String text) {
        int countOfNumbers = 0;

        for (String word : text.split(" ")) {
            try {
                int number = Integer.parseInt(word);
                countOfNumbers++;
            } catch (Exception e) {
                System.out.println("not a number");
            }
        }

        int index = 0;
        int[] res = new int[countOfNumbers];
        for (String word : text.split(" ")) {
            try {
                int number = Integer.parseInt(word);
                res[index] = number;
                index++;
            } catch (Exception e) {}
        }

        return res;
    }
}
