package guide08.exercises.exercise08.services;

import guide08.exercises.exercise08.entities.Text;

import java.util.Scanner;

public class TextAnalyserService {
    private final Scanner scanner = new Scanner(System.in);

    public Text readPhrase() {
        Text text = new Text();
        System.out.print("Enter a phrase: ");
        text.setPhrase(scanner.nextLine());
        return text;
    }

    public int countVocals(Text text) {
        int vocals = 0;
        for (int i = 0; i < text.getPhrase().length(); i++) {
            if (text.getPhrase().charAt(i) == 'a'
                    || text.getPhrase().charAt(i) == 'e'
                    || text.getPhrase().charAt(i) == 'i'
                    || text.getPhrase().charAt(i) == 'o'
                    || text.getPhrase().charAt(i) == 'u')
                vocals++;
        }
        return vocals;
    }

    public void reverse(Text text) {
        StringBuilder reversedPhrase = new StringBuilder();
        for (int i = text.getPhrase().length() - 1; i >= 0; i--) {
            reversedPhrase.append(text.getPhrase().charAt(i));
        }
        System.out.println("Reversed phrase: " + reversedPhrase);
    }

    public void timesRepeated(Text text, String letter) {
        int times = 0;
        for (int i = 0; i < text.getPhrase().length(); i++) {
            if (text.getPhrase().charAt(i) == letter.charAt(0))
                times++;
        }
        System.out.println("The letter " + letter + " is repeated " + times + " times.");
    }

    public void compareLength(Text text, String anotherText) {
        if (text.getPhrase().length() > anotherText.length())
            System.out.println("The first text is longer than the second one.");
        else if (text.getPhrase().length() < anotherText.length())
            System.out.println("The second text is longer than the first one.");
        else
            System.out.println("Both texts have the same length.");
    }

    public void joinPhrase(Text text, String anotherText) {
        String joinedPhrase = text.getPhrase().concat(anotherText);
        System.out.println("Resulting phrase: " + joinedPhrase);
//        text.setPhrase(joinedPhrase); // If you want to modify the original text
    }

    public void replace(Text text, char letter, char anotherLetter) {
        String replacedPhrase = text.getPhrase().replace(letter, anotherLetter);
        System.out.println("Resulting phrase: " + replacedPhrase);
    }

    public boolean content(Text text, String letter) {
        return text.getPhrase().contains(letter);
    }

    public void showMenu(Text text) {
        int choice;
        do {
            menu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> System.out.println("The phrase has " + countVocals(text) + " vocals.");
                case 2 -> reverse(text);
                case 3 -> {
                    System.out.print("Enter a letter: ");
                    String letter = scanner.nextLine();
                    timesRepeated(text, letter);
                }
                case 4 -> {
                    System.out.print("Enter another text: ");
                    String anotherText = scanner.nextLine();
                    compareLength(text, anotherText);
                }
                case 5 -> {
                    System.out.print("Enter another text: ");
                    String anotherText = scanner.nextLine();
                    joinPhrase(text, anotherText);
                }
                case 6 -> {
                    System.out.print("Enter a letter: ");
                    char letter = scanner.nextLine().charAt(0);
                    System.out.print("Enter another letter: ");
                    char anotherLetter = scanner.nextLine().charAt(0);
                    replace(text, letter, anotherLetter);
                }
                case 7 -> {
                    System.out.print("Enter a letter: ");
                    String letter = scanner.nextLine();
                    if (content(text, letter))
                        System.out.println("The phrase contains the letter " + letter);
                    else
                        System.out.println("The phrase does not contain the letter " + letter);
                }
            }
        } while (choice != 8);
    }

    public void menu() {
        System.out.println("================================");
        System.out.println("               MENU");
        System.out.println("1. Count vocals");
        System.out.println("2. Reverse phrase");
        System.out.println("3. Times repeated");
        System.out.println("4. Compare length");
        System.out.println("5. Join phrase");
        System.out.println("6. Replace letter");
        System.out.println("7. Check content");
        System.out.println("8. Exit");
        System.out.println("================================");
    }

}
