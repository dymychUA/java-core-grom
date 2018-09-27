package lesson17.hw2;

public class Solution {
    public static void main(String[] args) {

        String input = "Test input string input demo in input in";

        //2
        System.out.println(maxWord(input));
        System.out.println(minWord(input));

    }


    //2
    public static String maxWord(String input) {

        if (input.equals(""))
            return "";

        String[] words = input.split(" ");
        String res = words[0];

        for (String word : words) {
            if (validateSymbols(word) && res.length() < word.length())
                res = word;
        }

        return res;
    }

    public static String minWord(String input) {

        if (input.equals(""))
            return "";

        String[] words = input.split(" ");
        String res = words[0];

        for (String word : words) {
            if (validateSymbols(word) && res.length() > word.length())
                res = word;
        }

        return res;
    }

    public static boolean validateSymbols(String input) {

        if (input.equals(""))
            return false;

        char[] arr = input.toCharArray();

        for (char symbol : arr) {
            if(!Character.isLetter(symbol))
                return false;
        }

        return true;
    }
}
