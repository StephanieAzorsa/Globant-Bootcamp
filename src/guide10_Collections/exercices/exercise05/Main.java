package guide10_Collections.exercices.exercise05;

import guide10_Collections.exercices.exercise05.services.CountryService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CountryService countryService = new CountryService();

        boolean exit = false;
        do {
            countryService.createCountry();
            System.out.print("Do you want to add another one? (Y/N) ");
            String option = scanner.next().toUpperCase();
            if (option.equalsIgnoreCase("N")) {
                exit = true;
            }
        } while (!exit);

        countryService.printAllCountries();

        System.out.println("Enter the name of the country you want to delete: ");
        String name = scanner.next().toLowerCase().trim();
        countryService.deleteCountry(name);

        countryService.printAllCountries();
    }
}
