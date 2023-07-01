package guide08.exercises.exercise12.services;

import guide08.exercises.exercise12.entities.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Service class for managing person-related operations.
 */
public class PersonService {
    private final Scanner scanner = new Scanner(System.in);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private final List<Person> persons = new ArrayList<>();

    /**
     * Create a person and add it to the list.
     */
    public void createPerson() {
        Person person = new Person();

        System.out.print("Enter the person's name: ");
        person.setName(scanner.nextLine());

        System.out.print("Enter the birth date (in format dd/MM/yyyy): ");
        String birthDateStr = scanner.nextLine();

        try {
            Date birthDate = dateFormat.parse(birthDateStr);
            person.setBirthDate(birthDate);
            persons.add(person);
            System.out.println("The person's age is: " + calculateAge(person));
        } catch (ParseException e) {
            System.out.println("Error. The date should be in the format dd/MM/yyyy.");
        }
    }

    /**
     * Calculate the age of a person based on their birthdate.
     *
     * @param person the person
     * @return the age of the person
     */
    public int calculateAge(Person person) {
        Calendar currentDate = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(person.getBirthDate());

//      calendar.add(Calendar.YEAR, -birthDate.get(Calendar.YEAR))
        int age = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

        if (currentDate.get(Calendar.MONTH) < birthDate.get(Calendar.MONTH))
            age--;
        else if (currentDate.get(Calendar.MONTH) == birthDate.get(Calendar.MONTH)
                && currentDate.get(Calendar.DAY_OF_MONTH) < birthDate.get(Calendar.DAY_OF_MONTH))
            age--;

        return age;
//      return calendar.get(Calendar.YEAR);
    }

    /**
     * Compare the age of a person with other persons in the list.
     */
    public void compareAgeWithOtherPersons() {
        int index = validateIndex();
        if (index != -1) {
            Person personToCompare = persons.get(index);
            for (Person p : persons)
                if (p != personToCompare)
                    System.out.println(p.getName() + " is younger than " + personToCompare.getName() + "? "
                            + calculateAge(p) + " < " + calculateAge(personToCompare) + " = "
                            + isYoungerThan(p, calculateAge(personToCompare)));
        }
    }

    /**
     * Check if a person is younger than a specified age.
     *
     * @param person the person
     * @param age    the age to compare
     * @return true if the person is younger than the specified age, false otherwise
     */
    public boolean isYoungerThan(Person person, int age) {
        int currentAge = calculateAge(person);
        return currentAge < age;
    }

    /**
     * Display the details of a person from the list.
     */
    public void displayPersonFromList() {
        int displayIndex = validateIndex();
        if (displayIndex != -1)
            displayPerson(persons.get(displayIndex));
    }

    /**
     * Display the details of a person.
     *
     * @param person the person to display
     */
    public void displayPerson(Person person) {
        System.out.println("Name: " + person.getName());
        System.out.println("Birthdate: " + dateFormat.format(person.getBirthDate()));
        System.out.println("Age: " + calculateAge(person));
    }

    /**
     * Display all the persons in the list.
     */
    public void displayAllPersons() {
        if (persons.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        for (Person person : persons) {
            displayPerson(person);
            System.out.println();
        }
    }

    /**
     * Modify a person's details in the list.
     */
    public void modifyPersonFromList() {
        int modifyIndex = validateIndex();
        if (modifyIndex != -1)
            modifyPerson(persons.get(modifyIndex));
    }

    /**
     * Modify a person's details.
     *
     * @param person the person to modify
     */
    public void modifyPerson(Person person) {
        System.out.println("Current name: " + person.getName());
        System.out.print("Enter the new name: ");
        String newName = scanner.nextLine();
        person.setName(newName);

        System.out.println("Current birth date: " + dateFormat.format(person.getBirthDate()));
        System.out.print("Enter the new birth date (in format dd/MM/yyyy): ");
        String newBirthDateStr = scanner.nextLine();

        try {
            Date newBirthDate = dateFormat.parse(newBirthDateStr);
            person.setBirthDate(newBirthDate);
        } catch (ParseException e) {
            System.out.println("Error. The date should be in the format dd/MM/yyyy.");
        }
    }

    /**
     * Delete a person from the list.
     */
    public void deletePersonFromList() {
        int deleteIndex = validateIndex();
        if (deleteIndex != -1)
            deletePerson(persons.get(deleteIndex));
    }

    /**
     * Delete a person.
     *
     * @param person the person to delete
     */
    public void deletePerson(Person person) {
        persons.remove(person);
        System.out.println("Person deleted.");
    }

    /**
     * Delete all persons from the list.
     */
    public void deleteAllPersons() {
        persons.clear();
        System.out.println("All persons deleted.");
    }

    /**
     * Validate the index entered by the user.
     *
     * @return the validated index, or -1 if it is invalid
     */
    public int validateIndex() {
        if (persons.isEmpty()) {
            System.out.println("Please create a person first.");
            return -1;
        }

        System.out.print("Enter the index of the person (0-" + (persons.size() - 1) + "): ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 0 || index >= persons.size()) {
            System.out.println("Invalid index.");
            return -1;
        }

        return index;
    }

    /**
     * Sort the persons in the list by name.
     */
    public void sortPersonsByName() {
        persons.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
        System.out.println("Persons sorted by name.");
    }

}