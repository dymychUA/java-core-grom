package lesson17.hw3;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        String input = " Test       input string in  input  demo  input   i#n  in in   ";
        String input2 = " lk34 sdf( *()_ sd;f   789 -   789   ";

        //3
        System.out.println(mostCountedWord(input));
        System.out.println(mostCountedWord(input2));

    }

    //3
    public static String mostCountedWord(String input) {

        if (input.isEmpty()) {
            return null;
        }

        String[] words = input.split(" ");

        int maxCount = 0;
        String mostFrequent = null;

        for (String word : words) {
            int count = 0;
            for (String item : words) {
                if (word.equals(item) && word.length() > 0 && validateSymbols(item)) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                mostFrequent = word;
            }
        }

        return mostFrequent;
    }

    public static boolean validateSymbols(String input) {

        for (char symbol : input.toCharArray()) {
            if(!Character.isLetter(symbol))
                return false;
        }

        return !input.isEmpty();
    }

}
