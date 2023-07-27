package guide10_Collections.exercices.exercise01;

import guide10_Collections.exercices.exercise01.services.DogService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        DogService dogService = new DogService();

        boolean exit = false;
        do {
            dogService.createDog();
            System.out.print("Do you want to add another dog? (Y/N) ");
            String option = scanner.next().toUpperCase();
            if (option.equalsIgnoreCase("N")) {
                exit = true;
            }
        } while (!exit);

        System.out.println("\nThe list of dogs is: ");
        dogService.printDog();

        scanner.close();
    }
}
