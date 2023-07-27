package guide10_Collections.exercices.exercise01.services;

import guide10_Collections.exercices.exercise01.entities.Dog;

import java.util.ArrayList;
import java.util.Scanner;

public class DogService {
    private final Scanner scanner;
    private final ArrayList<Dog> dogs;

    public DogService() {
        this.scanner = new Scanner(System.in).useDelimiter("\n");
        this.dogs = new ArrayList<>();
    }

    public void createDog() {
        System.out.print("Enter the name of the dog: ");
        String name = scanner.next();
        System.out.print("Enter the breed of the dog: ");
        String breed = scanner.next();
        dogs.add(new Dog(name, breed));
    }

    public void printDog() {
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
    }
}
