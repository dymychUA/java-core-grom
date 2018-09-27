package lesson17.hw3;

public class Solution {
    public static void main(String[] args) {

        String input = " Test       input string   input  demo in  input   i#n  in in   ";
        String input2 = " lk34 sdf( *()_ sd;f   789 -   789    ";

        //3
        System.out.println(mostCountedWord(input));
        System.out.println(mostCountedWord(input2));

    }

    //3
    public static String mostCountedWord(String input) {

        if (input.trim().isEmpty())
            return null;

        String[] words = deleteDuplicates(input.trim()).split(" ");
        if (words.length == 0)
            return null;

        int[] counters = countDuplicates(input, words);

        int maxIndex = -1;
        int maxValue = -1;

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] != 0 && counters[i] > maxValue) {
                maxIndex = i;
                maxValue = counters[i];
            }
        }

        if (maxIndex == -1)
            return null;

        return words[maxIndex];
    }


    public static int[] countDuplicates(String input, String[] words) {

        String[] strings = input.trim().split(" ");
        int[] res = new int[words.length];

        for (String string : strings) {
            for (int i = 0; i < words.length; i++) {
                if (validateSymbols(words[i]) && string.equals(words[i]))
                    res[i]++;
            }
        }

        return res;
    }

    public static String deleteDuplicates(String input) {

        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j]))
                    words[j] = "";
            }
        }

        String res = "";

        for (String word : words) {
            res += word;

            if (! word.isEmpty())
                res += " ";
        }

        return res;
    }

    public static boolean validateSymbols(String input) {

        if (input.trim().isEmpty())
            return false;

        char[] arr = input.toCharArray();

        for (char symbol : arr) {
            if(!Character.isLetter(symbol))
                return false;
        }

        return true;
    }

}
