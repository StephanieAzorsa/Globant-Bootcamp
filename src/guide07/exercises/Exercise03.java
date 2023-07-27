package guide07.exercises;

import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phrase = scanner.nextLine();

        String uppercase = phrase.toUpperCase();
        String lowercase = phrase.toLowerCase();

        System.out.println("Phrase in uppercase: " + uppercase);
        System.out.println("Phrase in lowercase: " + lowercase);
    }
}
