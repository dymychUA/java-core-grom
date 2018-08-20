package lesson3;

public class FindOdd {
    public static void main(String[] args) {
        int a = 0;
        int sum = 0;

        while (a <= 1000) {
            if (a % 2 != 0) {
                sum += a;
                System.out.println("Found");
            }
            a++;
        }

        if (sum * 5 > 5000)
            System.out.println("Bigger");
        else
            System.out.println("Smaller or equal");
    }
}
