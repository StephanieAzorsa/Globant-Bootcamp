package guide07.examples;

import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        String answer;

        do {
            System.out.println("Do you want to continue?");
            answer = leer.nextLine();
        } while (answer.equalsIgnoreCase("Y"));

    }
}
