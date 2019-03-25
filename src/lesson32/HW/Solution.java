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

            if (validateNumbers(numbers)) {
                System.out.println(sumOfNumbers(numbers));
                br.close();
                reader.close();
                break;
            }

            attempt ++;
            if (attempt == 3) {
                System.out.println("Your numbers are wrong. Number of attempts exceeded");
                br.close();
                reader.close();
                break;
            } else {
                System.out.println("Your numbers are wrong. You have " + (3 - attempt) + " attempts to try again");
            }
        }

    }

    private static boolean validateNumbers(String[] numbers) {

        if (numbers.length != 10) {
            return false;
        }

        try {
            for (String stringNumber : numbers) {
                int number = Integer.parseInt(stringNumber);
                if (number > 100) {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private static int sumOfNumbers(String[] numbers) {
        int sum = 0;

        for (String stringNumber : numbers) {
            sum += Integer.parseInt(stringNumber);
        }

        return sum;
    }

}
