package guide10_Collections.examples.exampleArrayList;

import java.util.Scanner;

public class ClassMainArrayList {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        PersonServiceArrayList personService = new PersonServiceArrayList();

        System.out.print("Welcome to the program, how many people do you want to create? ");
        byte quantity = leer.nextByte();
        for (int i = 0; i < quantity; i++)
            personService.createPerson();
        personService.printAll();

        System.out.print("\nEnter the lastname of the person you want to delete: ");
        String chosenVar = leer.next();
        chosenVar = chosenVar.toUpperCase();
        personService.delete(chosenVar);

        System.out.println("\nThe list sorted by lastname is: ");
        personService.sortLastname();
        personService.printAll();
    }
}