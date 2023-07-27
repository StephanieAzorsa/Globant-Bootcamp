package guide07.exercises;

import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        System.out.println("Double: " + (2 * number));
        System.out.println("Triple: " + (3 * number));
        System.out.println("Square root: " + Math.sqrt(number));
    }
}
