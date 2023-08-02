package guide10_Collections.extras.exercise04.services;

import guide10_Collections.extras.exercise04.entities.City;

import java.util.HashMap;
import java.util.Scanner;

public class PostalCodeService {
    private final Scanner scanner;
    private final HashMap<String, City> cities;

    public PostalCodeService(){
        this.scanner = new Scanner(System.in).useDelimiter("\n");
        this.cities = new HashMap<>();
    }

    public void createPostalCode(){
        System.out.print("Enter the name of the city: ");
        String name = scanner.nextLine().toLowerCase().trim();
        System.out.print("Enter the postal code: ");
        int postalCode = scanner.nextInt();
        scanner.nextLine();

        if (cities.containsKey(name)) {
            System.out.println("City already exists with the same name.");
            return;
        }

        City city = new City();
        city.setName(name);
        city.setPostalCode(postalCode);
        cities.put(name, city);
    }

    public HashMap<String, City> getCities(){
        return cities;
    }

    public void getCity(int postalCode){
        for (City city : cities.values()) {
            if (city.getPostalCode() == postalCode){
                System.out.println(city.getName());
                return;
            }
        }
        System.out.println("City not found.");
    }

    public void deleteCity(String name){
        cities.remove(name);
    }
}
