package guide10_Collections.examples.exampleHashMap;

import java.util.Scanner;

public class ClassMainHashMap {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        PersonServiceHashMap newExecution = new PersonServiceHashMap();

        System.out.println("Welcome to the program, how many people do you want to create?");
        byte quantity = leer.nextByte(); // I ask the user how many people he wants to create

        for (int i = 0; i < quantity; i++)
            newExecution.createPerson(); // I call the method to create people as many times as the user wants

        newExecution.printAllPerson();
        System.out.println("Enter the DNI of the person you want to delete");
        Integer chosenVar = leer.nextInt();

        newExecution.deletePerson(chosenVar);
        newExecution.printAllPerson();
    }
}
