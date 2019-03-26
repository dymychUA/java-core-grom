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
                if (map.containsKey(symbol)) {
                    map.put(symbol , map.get(symbol) + 1);
                } else {
                    map.put(symbol, 1);
                }

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
                if (map.containsKey(currentWord)) {
                    map.put(currentWord , map.get(currentWord) + 1);
                } else {
                    map.put(currentWord, 1);
                }
            }
        }

        return map;
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
