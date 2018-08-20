package lesson4;

public class StringsConc {
    public static void main(String[] args) {
        System.out.println(concat("This ", "is ", "concat"));
    }

    public static String concat (String str1, String str2, String str3) {
        return str1 + str2 + str3;
    }
}
