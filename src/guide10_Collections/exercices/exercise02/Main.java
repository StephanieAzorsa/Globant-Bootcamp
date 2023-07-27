package guide10_Collections.exercices.exercise02;

import guide10_Collections.exercices.exercise02.services.DogService;

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


        System.out.println("\nDelete a dog by name: ");
        System.out.print("Enter the name of the dog: ");
        String name = scanner.next();
        if (dogService.deleteDog(name)) {
            System.out.println("The dog was deleted successfully");
        } else {
            System.out.println("The dog was not found");
        }

        System.out.println("\nSorted list of dogs: ");
        dogService.sortDog();
        dogService.printDog();
    }
}
