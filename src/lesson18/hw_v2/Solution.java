package lesson18.hw_v2;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findNumbers("as 23 2123 23 kj32  32k 23 1111111  &6786^  ((   ^%$  678")));
    }

    public static int[] findNumbers(String text) {
        int countOfNumbers = 0;

        for (String word : text.split(" ")) {
            if (isNumber(word)) {
                int number = Integer.parseInt(word);
                countOfNumbers++;
            } else {
                System.out.println("not a number");
            }
        }

        int index = 0;
        int[] res = new int[countOfNumbers];
        for (String word : text.split(" ")) {
            if (isNumber(word)) {
                int number = Integer.parseInt(word);
                res[index] = number;
                index++;
            }
        }

        return res;
    }

    public static boolean isNumber(String input) {

        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch))
                return false;
        }

        return !input.isEmpty();
    }
}
