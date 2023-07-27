package guide07.exercises;

import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Centigrade to Fahrenheit conversion");
        System.out.print("Enter degrees Celsius: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = (1.8 * celsius) + 32;

        System.out.println("In Fahrenheit: " + fahrenheit + "°F");
    }
}
