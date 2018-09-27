package lesson17.hw2;

public class Solution {
    public static void main(String[] args) {

        String input = " Test   inputa stringa7 input demo in ainput in a ";

        //2
        System.out.println(maxWord(input));
        System.out.println(minWord(input));

    }


    //2
    public static String maxWord(String input) {

        if (input.trim().isEmpty())
            return null;

        String[] words = input.trim().split(" ");
        String res = null;

        for (String word : words) {
            if (validateSymbols(word)) {
                if (res == null)
                    res = word;
                if (res.length() < word.length())
                    res = word;
            }
        }

        return res;
    }

    public static String minWord(String input) {

        if (input.trim().isEmpty())
            return null;

        String[] words = input.trim().split(" ");
        String res = null;

        for (String word : words) {
            if (validateSymbols(word)) {
                if (res == null)
                    res = word;
                if (res.length() > word.length())
                    res = word;
            }
        }

        return res;
    }

    public static boolean validateSymbols(String input) {

        if (input.isEmpty())
            return false;

        char[] arr = input.toCharArray();

        for (char symbol : arr) {
            if(!Character.isLetter(symbol))
                return false;
        }

        return true;
    }
}
