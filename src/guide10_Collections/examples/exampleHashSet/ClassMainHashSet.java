package guide10_Collections.examples.exampleHashSet;

import java.util.Scanner;

public class ClassMainHashSet {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        PersonServiceHashSet newExecution = new PersonServiceHashSet(); // I call my SERVICE class to access the corresponding methods

        System.out.print("How many people will you load? ");
        byte quantity = leer.nextByte(); // For the user to tell me how many he wants to create

        for (int i = 0; i < quantity; i++) {
            newExecution.createPerson(); // I call the method to load the people
        }

        newExecution.printAll(); // I call the method to print all the people
        System.out.print("Enter the last name of the person you want to remove from the list: ");
        String varChosen = leer.next();
        varChosen = varChosen.toUpperCase();

        newExecution.removePerson(varChosen);// I call the method to remove the person from the list
        newExecution.printAll(); // I call the method to print all the people
    }
}