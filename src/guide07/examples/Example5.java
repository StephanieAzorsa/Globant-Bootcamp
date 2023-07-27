package guide07.examples;

import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce your age: ");
        int age = leer.nextInt();

        System.out.println("Introduce your name: ");
        String name = leer.nextLine();

        System.out.println("Introduce your lastname: ");
        String lastname = leer.nextLine();

        System.out.println("Name: " + name  +
                "\nLastname: " + lastname +
                "\nAge: " + age);
    }
}
