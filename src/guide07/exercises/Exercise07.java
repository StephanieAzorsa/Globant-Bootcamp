package guide07.exercises;

import java.util.Scanner;

public class Exercise07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String keyword = scanner.nextLine();

        if (isEureka(keyword))
            System.out.println("The word '" + keyword + "' is correct.");
        else
            System.out.println("The word '" + keyword + "' is incorrect.");
    }

    public static boolean isEureka(String keyword) {
        String word = "eureka";
        return word.equals(keyword);
    }
}
