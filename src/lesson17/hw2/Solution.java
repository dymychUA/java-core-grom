package lesson17.hw2;

public class Solution {
    public static void main(String[] args) {

        String input = " Test         inputa stringa7 input demo in ainput in a4 ";

        //2
        System.out.println(maxWord(input));
        System.out.println(minWord(input));

    }


    //2
    public static String maxWord(String input) {

        input = input == null ? "" : input.trim();

        String[] words = input.split(" ");
        String res = "";

        for (String word : words) {
            if (validateSymbols(word)) {
                if (res.length() < word.length())
                    res = word;
            }
        }

        return res.isEmpty() ? null : res;
    }

    public static String minWord(String input) {

        input = input == null ? "" : input.trim();

        String[] words = input.split(" ");
        String res = input;

        for (String word : words) {
            if (validateSymbols(word)) {
                if (res.length() > word.length())
                    res = word;
            }
        }

        return validateSymbols(res) ? res : null;
    }

    public static boolean validateSymbols(String input) {

        for (char symbol : input.toCharArray()) {
            if(!Character.isLetter(symbol))
                return false;
        }

        return !input.isEmpty();
    }
}
