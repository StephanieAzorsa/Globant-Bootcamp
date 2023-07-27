package guide10_Collections.examples.exampleArrayList;

import java.util.*;

public class PersonServiceArrayList {
    private final ArrayList<PersonArrayList> newList;
    private final Scanner scanner;

    public PersonServiceArrayList() {
        this.newList = new ArrayList<>();
        this.scanner = new Scanner(System.in).useDelimiter("\n");
    }

    public void createPerson() {
        System.out.print("Enter the name: ");
        String nameInput = scanner.next();
        nameInput = nameInput.toUpperCase();
        System.out.print("Enter the lastname: ");
        String lastnameInput = scanner.next();
        lastnameInput = lastnameInput.toUpperCase();
        System.out.print("Enter the DNI: ");
        Integer dniInput = scanner.nextInt();

        newList.add(new PersonArrayList(dniInput, nameInput, lastnameInput));
    }

    public void printAll() {
        for (PersonArrayList person : newList) {
            System.out.println(person.toString());
        }
    }

    public void delete(String chosenVar) {
        newList.removeIf(personArrayList -> personArrayList.getLastname().equals(chosenVar));
    }

    public void sortLastname(){
        newList.sort(Comparator.comparing(PersonArrayList::getLastname));
    }

}
