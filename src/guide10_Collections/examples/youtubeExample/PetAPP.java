package guide10_Collections.examples.youtubeExample;

import guide10_Collections.examples.youtubeExample.util.Comparators;

import java.util.*;

public class PetAPP {
    public static void main(String[] args) {
        PetService petService = new PetService();

        petService.factoryPet(2);
        petService.printPet();

        System.out.println("\nUpdate the nickname of the pet in index 1");
        petService.updatePet(1);
        petService.printPet();

        System.out.println("\nDelete the pet in index 0");
        petService.deletePet(0);
        petService.printPet();

        System.out.println("\nAdding Beethoven's");
        petService.factoryBeethoven(2);
        petService.printPet();

        System.out.println("\nComparator -------------------------------------");
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Pet("Snoopy", "Snoop", "Dog", 14));
        pets.add(new Pet("Beethoven", "Beet", "Dog", 22));
        pets.add(new Pet("Maximus", "Max", "Dog", 20));
        pets.add(new Pet("Lassie", "Lass", "Dog", 18));

        Collections.sort(pets, Comparators.orderByNameDesc);

        for (Pet pet : pets) {
            System.out.println(pet);
        }

        Collections.shuffle(pets); // Randomize the order of the list.


        System.out.println("\nArray to List ---------------------------------");

        String[] names = {"Maria", "Juan"};
        List<String> namesList1 = new ArrayList<>(Arrays.asList(names));
        System.out.println(namesList1);

        List<String> namesList2 = new ArrayList<>();
        namesList2.addAll(0,namesList1);
        System.out.println(namesList2);

        System.out.println("\nSet ---------------------------------");
        Set<Pet> petsSet = new HashSet<>();
        petsSet.add(new Pet("Snoopy", "Snoop", "Dog", 14));
        petsSet.add(new Pet("Snoopy", "Snoop", "Dog", 14));
        petsSet.add(new Pet("Snoopy", "Snoop", "Dog", 14));
        petsSet.add(new Pet("Snoopy", "Snoop", "Dog", 14));
        petsSet.add(new Pet("Snoopy", "Snoop", "Dog", 14));
        petsSet.add(new Pet("Snoopy", "Snoop", "Dog", 14));
        System.out.println(petsSet);

        System.out.println("\nMap ---------------------------------");
        HashMap<String, Pet> petsMap = new HashMap<>();

        petsMap.put("1", new Pet("Snoopy", "Snoop", "Dog", 14));
        petsMap.put("2", new Pet("Lassie", "Lass", "Dog", 18));

        petsMap.remove("1");

        for (Map.Entry<String, Pet> aux : petsMap.entrySet()){
            String key = aux.getKey();
            Pet value = aux.getValue();
            System.out.println("key: " + key + "value: " + value);
        }
      }
}
