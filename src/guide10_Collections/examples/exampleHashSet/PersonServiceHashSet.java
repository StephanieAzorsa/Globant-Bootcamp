package guide10_Collections.examples.exampleHashSet;

import java.util.HashSet;
import java.util.Scanner;


public class PersonServiceHashSet {
    private final HashSet<PersonaHashSet> newMap;
    private final Scanner scanner;

    public PersonServiceHashSet() {
        this.newMap = new HashSet<>(); // I create the LIST memory space
        this.scanner = new Scanner(System.in).useDelimiter("\n"); // When the class is invoked, it enables data flow.
    }

    public void createPerson(){
        System.out.print("Enter the name: ");
        String nameEnter = scanner.next();
        nameEnter = nameEnter.toUpperCase();
        System.out.print("Enter the last name: ");
        String lastnameEnter = scanner.next();
        lastnameEnter = lastnameEnter.toUpperCase();
        System.out.print("Enter the DNI: ");
        Integer dniEnter = scanner.nextInt();

        // If I don't create my HashCode and Equals methods, it will allow me to load repeated data.
        newMap.add(new PersonaHashSet(dniEnter,nameEnter,lastnameEnter));
    }

    public void printAll(){
        for (PersonaHashSet unitPerson : newMap)
            System.out.println(unitPerson.toString());
    }

    public void removePerson(String varChosen) {
        newMap.removeIf(personaHashSet -> personaHashSet.getLastname().equals(varChosen));
    }
}
