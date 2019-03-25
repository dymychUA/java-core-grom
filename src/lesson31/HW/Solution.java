package lesson31.HW;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static Map<Character, Integer> countSymbols(String text) {

        if (text == null || text.isEmpty())
            return null;

        Map<Character, Integer> map = new TreeMap<>();

        for (Character symbol : text.toCharArray()) {
            if (Character.isLetter(symbol)) {
                map.put(symbol, symbolCountInString(text, symbol));
            }
        }

        return map;
    }


    public static Map<String, Integer> words(String text) {

        if (text == null || text.isEmpty())
            return null;

        Map<String, Integer> map = new HashMap<>();

        for (String currentWord : text.split(" ")) {
            if (validateWord(currentWord)) {
                map.put(currentWord, wordCountInString(text, currentWord));
            }
        }

        return map;
    }

    private static int symbolCountInString(String text, Character symbol) {
        int count = 0;

        for (Character currentSymbol : text.toCharArray()) {
            if (symbol.equals(currentSymbol))
                count++;
        }

        return count;
    }

    private static int wordCountInString(String text, String word) {
        int count = 0;

        for (String currentWord : text.split(" ")) {
            if (word.equals(currentWord))
                count++;
        }

        return count;
    }

    private static boolean validateWord(String word) {

        if (word.length() < 2)
            return false;

        for (char symbol : word.toCharArray()) {
            if (!Character.isLetter(symbol))
             return false;
        }

        return true;
    }

}
