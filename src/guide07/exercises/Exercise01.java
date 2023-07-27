package guide07.exercises;

import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        int numberA, numberB;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        numberB = scanner.nextInt();
        System.out.print("Enter the second number: ");
        numberA = scanner.nextInt();

        System.out.println(numberA + " + " + numberB + " = " + (numberA + numberB));
    }
}
