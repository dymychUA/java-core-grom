package lesson2;

public class SumOfNumbers {
    public static void main(String[] args) {
        int a = 0;
        long sum = 0;
        while (a <= 1000) {
            a++;
            sum += a;
        }

        long div = sum / 1234;
        long mod = sum % 1234;

        boolean res = mod > div;

        System.out.println(res);
    }
}
