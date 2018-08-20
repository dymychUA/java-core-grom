package lesson4;

public class Comparer {
    public static void main(String[] args) {
        System.out.println(compareSums(2,11,12,15));
    }

    public static boolean compareSums(int a, int b, int c, int d) {

        /*long sum1 = sum(a, b);
        long sum2 = sum(c, d);*/

        //return sum1 > sum2 ? true : false;
        return sum(a, b) > sum(c, d) ? true : false;
    }

    public static long sum(int from, int to) {
        long sum = 0;
        for (int i = from; i <= to; i++) {
            sum += i;
        }
        return sum;
    }
}
