package lesson5;

public class FindUnique {
    public static void main(String[] args) {
        int[] array = {11, 12, 10, 5, 4, 44, 100, 11, 10, 11};
        System.out.println(uniqueCount(array));
    }

    public static int uniqueCount(int[] array) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == array[i]) {
                    count++;
                    break;
                }
            }
        }

        return array.length - count;
    }
}
