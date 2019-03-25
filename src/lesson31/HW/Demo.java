package lesson31.HW;

public class Demo {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println("Symbol count:");
        System.out.println(Solution.countSymbols(null));
        System.out.println(Solution.countSymbols(""));
        System.out.println(Solution.countSymbols("sadf"));
        System.out.println(Solution.countSymbols("sadf1"));
        System.out.println(Solution.countSymbols("sadf alsdfksjada sdflasdkfas dlfasl dflasdkflasdf lasdf lasdkfasd"));

        System.out.println("");
        System.out.println("Word count:");
        System.out.println(Solution.words(null));
        System.out.println(Solution.words(""));
        System.out.println(Solution.words("sadf"));
        System.out.println(Solution.words("sad1f"));
        System.out.println(Solution.words("sadf alsdfksjada sdflasdkfas dlfas2l sadf dflasdkflasdf lasdf  sadf   la1sdkfasd q sd dsds dasda3sd kj&8"));
    }

}
