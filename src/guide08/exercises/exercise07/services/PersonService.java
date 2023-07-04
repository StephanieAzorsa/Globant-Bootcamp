package guide08.exercises.exercise07.services;

import guide08.exercises.exercise07.entities.Person;

import java.util.Scanner;

public class PersonService {
    private final Scanner scanner = new Scanner(System.in);

    public Person createPerson() {
        Person p1 = new Person();
        System.out.print("Enter name: ");
        p1.setName(scanner.nextLine());
        System.out.print("Enter last name: ");
        p1.setLastName(scanner.nextLine());
        System.out.print("Enter age: ");
        p1.setAge(scanner.nextInt());

        scanner.nextLine(); // Consume the remaining newline character
        isValidGender(p1);

        System.out.print("Enter weight in Kg.: ");
        p1.setWeight(scanner.nextFloat());
        System.out.print("Enter height in mt.: ");
        p1.setHeight(scanner.nextFloat());

        return p1;
    }

    /**
     * Checks whether the gender entered is correct, i.e., M, F or O.
     *
     * @param p1 Person object
     */
    public void isValidGender(Person p1) {
        boolean validGender = false;
        while (!validGender) {
            System.out.print("Enter gender ('M' for male, 'F' for female, 'O' for other): ");
            String genderInput = scanner.nextLine().toUpperCase();
            p1.setGender(genderInput);
            if (p1.getGender() != null)
                validGender = true;
        }
    }

    /**
     * Calculate the IMC of a person
     *
     * @param p1 Person object
     * @return -1 if the person is underweight, 0 if the person's weight is normal, 1 if the person is overweight
     */
    public int calculateIMC(Person p1) {
        float imc = p1.getWeight() / (p1.getHeight() * p1.getHeight());
        if (imc < 20)
            return -1; // The person is underweight
        else if (imc >= 20 && imc <= 25)
            return 0; // The person's weight is normal
        else
            return 1; // The person is overweight
    }

    /**
     * Check if the person is an adult
     *
     * @param p1 Person object
     * @return true if the person is an adult, false otherwise
     */
    public boolean isAdult(Person p1) {
        return p1.getAge() >= 18;
    }

}
