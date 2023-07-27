package guide07.exercises;

import java.util.Scanner;

public class Exercise08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a phrase or word: ");
        String input = scanner.nextLine();

        if (lengthChecker(input))
            System.out.println("CORRECT!");
        else
            System.out.println("INCORRECT!");
    }

    public static boolean lengthChecker(String phrase) {
        return phrase.length() == 8;
    }
}
