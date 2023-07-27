package guide07.exercises;

import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number % 2 == 0)
            System.out.println("The number " + number + " it's even");
        else
            System.out.println("The number " + number + " it's odd");
    }
}
