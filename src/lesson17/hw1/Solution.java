package lesson17.hw1;

public class Solution {
    public static void main(String[] args) {

        String input = " Test input1 _ string input demo in i$nput in q ";

        //1
        System.out.println(countWords(input));
    }

    //1
    public static int countWords(String input) {

        int res = 0;

        String[] words = input.split(" ");

        for (String word : words) {
            if (validateSymbols(word))
                res++;
        }

        return res;
    }

    public static boolean validateSymbols(String input) {

        for (char symbol : input.toCharArray()) {
            if(!Character.isLetter(symbol))
                return false;
        }

        return !input.equals("");
    }

}
