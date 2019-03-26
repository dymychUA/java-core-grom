package lesson32.HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class Solution {

    public static void main(String[] args) throws IOException {
        readnumbers();
    }

    public static void readnumbers() throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        int attempt = 0;
        System.out.println("Please enter 10 numbers less then 100 separated with space. You have 3 attempts:");

        while (attempt <= 3) {

            String input = br.readLine();
            String[] numbers = input.split(" ");

            Integer sum = sumOfNumbers(numbers);

            if (sum != null) {
                System.out.println(sum);
                break;
            }

            attempt ++;
            if (attempt == 3) {
                System.out.println("Your numbers are wrong. Number of attempts exceeded");
                break;
            } else {
                System.out.println("Your numbers are wrong. You have " + (3 - attempt) + " attempts to try again");
            }
        }

        br.close();
        reader.close();

    }

    private static Integer sumOfNumbers(String[] numbers) {
        int sum = 0;

        if (numbers.length != 10) {
            return null;
        }

        try {
            for (String stringNumber : numbers) {
                int number = Integer.parseInt(stringNumber);
                if (number > 100) {
                    return null;
                } else {
                    sum += number;
                }
            }
        } catch (Exception e) {
            return null;
        }

        return sum;
    }

}
