package lesson15.cast;

public class Demo {

    public static void main(String[] args) {

        InternetProvider internetProvider = (InternetProvider) test();
        FoodProvider foodProvider = (FoodProvider) test();


        System.out.println(internetProvider);

    }

    private static Provider test() {
        return new InternetProvider();
    }

    private static Provider testFood() {
        return new InternetProvider();
    }
}
