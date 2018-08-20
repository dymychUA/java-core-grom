package lesson2;

public class SumAndDivision {
    public static void main(String[] args) {
        int a = 0;
        long sum = 0;
        while (a <= 1000) {
            a++;
            sum += a;
        }

        System.out.println(sum);
    }
}
