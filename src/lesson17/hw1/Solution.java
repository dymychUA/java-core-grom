package lesson17.hw1;

public class Solution {
    public static void main(String[] args) {

        String input = "Test input string input demo in input in";

        //1
        System.out.println(countWords(input));
    }

    //1
    public static int countWords(String input) {
        return deleteNotWords(input).split(" ").length;
    }

    public static String deleteNotWords(String input) {

        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (!validateSymbols(words[i]))
                words[i] = "";
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

        char[] arr = input.toCharArray();

        for (char symbol : arr) {
            if(!Character.isLetter(symbol))
                return false;
        }

        return true;
    }

}
