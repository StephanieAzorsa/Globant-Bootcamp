package guide10_Collections.examples.exampleHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PersonServiceHashMap {
    private final HashMap<Integer,PersonaHashMap> newMap;
    private final Scanner leer;

    public PersonServiceHashMap() {
        this.newMap = new HashMap<>(); // I create the MAP memory space
        this.leer = new Scanner(System.in).useDelimiter("\n");// When the class is invoked, it enables data flow.
    }

    public void createPerson() {
        System.out.print("Enter the name: ");
        String nameInput = leer.next();
        nameInput = nameInput.toUpperCase();
        System.out.print("Enter the lastname: ");
        String lastnameInput = leer.next();
        lastnameInput = lastnameInput.toUpperCase();
        System.out.print("Ingrese el DNI");
        Integer dniInput = leer.nextInt();

        // In this way we add elements to a map. Note that the first term corresponds to KEY
        newMap.put(dniInput,new PersonaHashMap(dniInput, nameInput, lastnameInput));
    }

    public void printAllPerson() {
        // entry.getKey gets the key and entry.getValue gets the values of the map, i.e. all its attributes.
        for (Map.Entry<Integer, PersonaHashMap> entry : newMap.entrySet())
            System.out.println("Document = " + entry.getKey()
                    + ", Person's Data = " + entry.getValue());
    }

    public void deletePerson(Integer chosenVar) {
        newMap.remove(chosenVar);
    }
}
