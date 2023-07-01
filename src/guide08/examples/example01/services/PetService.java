package guide08.examples.example01.services;

import guide08.examples.example01.entities.Pet;

import java.util.Scanner;

public class PetService {
    private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public Pet createPet() {
        System.out.println("Enter the name of the pet: ");
        String name = scanner.next();

        System.out.println("Enter the nickname of the pet: ");
        String nickname = scanner.next();

        System.out.println("Enter the type of the pet: ");
        String type = scanner.next();

        return new Pet(name, nickname, type);

    }
}
