package guide08.exercises.exercise12;

import guide08.exercises.exercise12.services.PersonService;

import java.util.Scanner;


public class PersonApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PersonService ps = new PersonService();

        int option;
        do {
            menu();
            System.out.print("\nEnter an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> ps.createPerson();
                case 2 -> ps.compareAgeWithOtherPersons();
                case 3 -> ps.displayPersonFromList();
                case 4 -> ps.displayAllPersons();
                case 5 -> ps.modifyPersonFromList();
                case 6 -> ps.sortPersonsByName();
                case 7 -> ps.deletePersonFromList();
                case 8 -> ps.deleteAllPersons();
                case 9 -> System.out.println("Exit...");
                default -> System.out.println("Invalid option.");
            }
        } while (option != 9);
    }

    public static void menu() {
        System.out.println("--------------------");
        System.out.println("Menu");
        System.out.println("1. Create person");
        System.out.println("2. Is younger than");
        System.out.println("3. Display person");
        System.out.println("4. Display all persons");
        System.out.println("5. Modify person");
        System.out.println("6. Sort persons by name");
        System.out.println("7. Delete person");
        System.out.println("8. Delete all persons");
        System.out.println("9. Exit program");
        System.out.println("--------------------");
    }
}
