package guide08.activities.activity2_Exercise1;

import guide08.activities.activity2_Exercise1.services.FilmService;
import guide08.activities.activity2_Exercise1.services.RentalService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FilmService ps = new FilmService();
        RentalService rs = new RentalService();

        int option;
        do {
            menu();
            System.out.print("\nChoose an option: ");
            option = scanner.nextInt();
            switch (option) {
                case 1 -> ps.createFilm();
                case 2 -> rs.createRental();
                case 3 -> ps.listAllFilms();
                case 4 -> ps.listFilmsAvailable();
                case 5 -> rs.listAllRentals();
                case 6 -> ps.searchByCriteria("title");
                case 7 -> ps.searchByCriteria("genre");
                case 8 -> rs.searchByCriteria("date");
                case 9 -> rs.returnMovie();
                case 10 -> System.out.println("Exit...");
                default -> System.out.println("Invalid option");
            }
        } while (option != 10);
    }

    private static void menu(){
        System.out.println("\n\t\tMENU");
        System.out.println("1. Create movie");
        System.out.println("2. Create rental");
        System.out.println("3. List all movies");
        System.out.println("4. List movie available");
        System.out.println("5. List rental movies");
        System.out.println("6. Search movie by title");
        System.out.println("7. Search movie by genre");
        System.out.println("8. Search rental movie by date");
        System.out.println("9. Return movie");
        System.out.println("10. Exit program");
    }
}
