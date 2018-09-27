package lesson17;

public class Solution {
    public static void main(String[] args) {

        String input = "Test input string input demo in input in";

        //1
        System.out.println(countWords(input));

        //2
        System.out.println(maxWord(input));
        System.out.println(minWord(input));

        //3
        System.out.println(mostCountedWord(input));

        //4
        System.out.println(validate("https://ukr.net"));
        System.out.println(validate("www.spb.ru"));
    }


    //1
    public static int countWords(String input) {
        return deleteNotWords(input).split(" ").length;
    }


    //2
    public static String maxWord(String input) {

        if (input.equals(""))
            return "";

        String[] words = deleteNotWords(input).split(" ");
        String res = words[0];

        for (String word : words) {
            if (res.length() < word.length())
                res = word;
        }

        return res;
    }

    public static String minWord(String input) {

        if (input.equals(""))
            return "";

        String[] words = deleteNotWords(input).split(" ");
        String res = words[0];

        for (String word : words) {
            if (res.length() > word.length())
                res = word;
        }

        return res;
    }


    //3
    public static String mostCountedWord(String input) {

        if (input == null || input.equals(""))
            return null;

        String[] words = deleteNotWords(deleteDuplicates(input)).split(" ");
        int[] counters = countDuplicates(input, words);

        int maxIndex = 0;
        int maxValue = counters[0];
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] > maxValue) {
                maxIndex = i;
                maxValue = counters[i];
            }
        }

        return words[maxIndex];
    }


    //4
    public static boolean validate(String address) {

        String[] protocols = {"http://", "https://"};
        String[] domains = {".com", ".org", ".net"};

        return validateProtocol(address, protocols) && validateDomains(address, domains) && validateSymbols(address);
    }



    public static int[] countDuplicates(String input, String[] words) {

        String[] strings = input.split(" ");
        int[] res = new int[words.length];

        for (String string : strings) {
            for (int i = 0; i < words.length; i++) {
                if (string.equals(words[i]))
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

    public static boolean validateProtocol(String address, String[] protocols) {

        for (String protocol : protocols) {
            if (address.startsWith(protocol))
                return true;
        }

        return false;
    }

    public static boolean validateDomains(String address, String[] domains) {

        for (String domain : domains) {
            if (address.endsWith(domain))
                return true;
        }

        return false;
    }

    public static boolean validateSymbols(String input) {

        char[] arr = input.toCharArray();

        for (char symbol : arr) {
            if(!Character.isLetter(symbol))
                return false;
        }

        /*for (String symbol : symbols) {
            if (input.contains(symbol))
                return false;
        }*/

        return true;
    }

}
