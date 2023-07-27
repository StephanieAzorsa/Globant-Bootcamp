package guide10_Collections.exercices.exercise02.services;

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

    public boolean deleteDog(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("The name cannot be null or empty");

        String nameLowerCase = name.toLowerCase().trim();

        boolean dogExists = dogs.stream()
                .anyMatch(dog -> dog.getName().toLowerCase().equals(nameLowerCase));

        if (!dogExists) return false;

        return dogs.removeIf(dog -> dog.getName().toLowerCase().equals(nameLowerCase));
    }

    public void sortDog() {
        if (dogs.isEmpty()) return;

        dogs.sort((dog1, dog2) -> dog1.getName().compareToIgnoreCase(dog2.getName()));
    }


}
