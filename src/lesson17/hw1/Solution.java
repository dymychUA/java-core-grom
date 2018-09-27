package lesson17.hw1;

public class Solution {
    public static void main(String[] args) {

        String input = "Test input1 string input demo in i$nput in";

        //1
        System.out.println(countWords(input));
    }

    //1
    public static int countWords(String input) {

        int res = 0;

        String[] words = input.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (validateSymbols(words[i]))
                res++;
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
