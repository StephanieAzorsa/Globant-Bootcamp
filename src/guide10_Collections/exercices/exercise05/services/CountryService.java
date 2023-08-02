package guide10_Collections.exercices.exercise05.services;

import guide10_Collections.exercices.exercise05.entities.Country;

import java.util.HashSet;
import java.util.Scanner;

public class CountryService {
    private final Scanner scanner;
    private final HashSet<Country> countries;

    public CountryService(){
        this.scanner = new Scanner(System.in);
        this.countries = new HashSet<>();
    }

    public void createCountry(){
        Country country = new Country();

        System.out.print("Enter the name: ");
        country.setName(scanner.nextLine().toLowerCase().trim());

        if (country.getName().isEmpty()){
            System.out.println("Name cannot be empty.");
            return;
        }

        if (countries.contains(country)){
            System.out.println("Country already exists with the same name.");
            return;
        }

        countries.add(country);
    }

    public void printAllCountries(){
        if (countries.isEmpty()){
            System.out.println("No movies added");
            return;
        }

        countries.forEach(country -> System.out.printf("| Name: %-10s | %n",
                country.getName()));
    }

    public void deleteCountry(String name){
        countries.removeIf(country -> country.getName().equalsIgnoreCase(name));

/*
        Iterator<Country> iterator = countries.iterator();
        while (iterator.hasNext())
            if (iterator.next().equals(name))
                iterator.remove();
*/
    }
}
