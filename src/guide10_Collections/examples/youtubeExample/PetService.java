package guide10_Collections.examples.youtubeExample;

import java.util.ArrayList;
import java.util.Scanner;

public class PetService {
    private final Scanner scanner;
    private final ArrayList<Pet> pets;

    public PetService() {
        this.scanner = new Scanner(System.in).useDelimiter("\n");
        this.pets = new ArrayList<>();
    }

    public Pet createPet() {
        System.out.print("Enter the name of the pet: ");
        String name = scanner.next();
        System.out.print("Enter the nickname of the pet: ");
        String nickname = scanner.next();
        System.out.print("Enter the type of the pet: ");
        String type = scanner.next();
        return new Pet(name, nickname, type);
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void factoryPet(int quantity) {
        for (int i = 0; i < quantity; i++) {
            addPet(createPet());
        }
    }

    public void factoryBeethoven(int quantity) {
        for (int i = 0; i < quantity; i++) {
            pets.add(new Pet("Beethoven", "Beet", "Dog"));
        }
    }

    public void updatePet(int index) {
        Pet pet = pets.get(index);
        pet.setNickname("Puppy");
    }

    public void updatePet2(int index) {
        if (index <= pets.size() - 1) {
            Pet pet = createPet();
            pets.set(index, pet);
        } else {
            System.out.println("The index is out of range.");
        }
    }

    public void updatePetByName(String name, String newName) {
        for (int i = 0; i < pets.size(); i++) {
            Pet pet = pets.get(i);
            if (pet.getName().equals(name)) {
                pet.setName(newName);
            }
        }
    }

    public void deletePet(int index) {
        try {
            pets.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The index is out of range.");
        }
    }

    public void deletePetByName(String name) {
//        pets.removeIf(pet -> pet.getName().equals(name));
        for (int i = 0; i < pets.size(); i++) {
            Pet pet = pets.get(i);
            if (pet.getName().equals(name)) {
                pets.remove(pet);
            }
        }
    }

    public void printPet() {
        System.out.println("Pets: ");
        for (Pet pet : pets) {
            System.out.println(pet.toString());
        }
        System.out.println("Quantity of pets: " + pets.size());
    }

}
