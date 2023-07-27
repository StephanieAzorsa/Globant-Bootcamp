package guide07.examples;

// Make a program that reads 4 numbers (between 1 and 20) and prints
// the entered number followed by as many asterisks as indicated by its value.
// For example:
// 5 *****
// 3 ***
// 11 ***********
// 2 **

import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        int[] numbers = new int[4];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            while (true) {
                System.out.print("Enter a number between 1 and 20: ");
                int number = scanner.nextInt();
                if (number >= 1 && number <= 20) {
                    numbers[i] = number;
                    break;
                } else {
                    System.out.println("The entered number is not within the valid range. Please try again.");
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.print(numbers[i] + " ");
            for (int j = 0; j < numbers[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
