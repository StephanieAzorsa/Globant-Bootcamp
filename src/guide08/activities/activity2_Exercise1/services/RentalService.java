package guide08.activities.activity2_Exercise1.services;

import guide08.activities.activity2_Exercise1.entities.Rental;
import guide08.activities.activity2_Exercise1.entities.Film;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalService {
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final List<Rental> rentals = new ArrayList<>();
    private final ValidateDates validateDate = new ValidateDates();
    private final FilmService filmService = new FilmService();
    private final  FilmSearchService fss = new FilmSearchService();
    private final  RentalSearchService rss = new RentalSearchService();
    private final  RentalCalculationService rcs = new RentalCalculationService();


    /**
     * Creates a rental for a film.
     * This method prompts the user to enter rental data, including the film title, price, start date, and end date.
     * It creates a new Rental object with the entered data and adds it to the rental list.
     */
    public void createRental() {
        System.out.println("\nRENTAL DATA ENTRY");
        System.out.print("Enter the title of the film: ");
        String filmTitle = scanner.nextLine();

        Film film;

        if (fss.isUniqueFilmTitle(filmTitle)) {
            film = fss.findFilmByTitle(filmTitle);
        } else {
            filmService.listFilmsAvailableAndSameTitle(filmTitle);
            System.out.print("Enter the index of the film: ");
            int index = scanner.nextInt();
            scanner.nextLine();
            film = fss.findFilmByTitleAndIndex(filmTitle, index);
        }

        if (film == null) {
            System.out.println("Film not found!");
            return;
        }

        System.out.print("Enter the price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter start date (dd/mm/yyyy): ");
        LocalDate startDate = validateDate.validStarDate();

        System.out.print("Enter end date (dd/mm/yyyy): ");
        LocalDate endDate = validateDate.validEndDate(startDate);
        System.out.println("Day's rented: " + daysRented(startDate, endDate));
        Rental rental = new Rental(film, startDate, endDate, price);

        film.setAvailable(false);
        rentals.add(rental);
    }

    /**
     * Calculates the number of days between two dates.
     *
     * @param startDate The start date of the rental.
     * @param endDate   The end date of the rental.
     * @return The number of days between the start date and the end date.
     */
    int daysRented(LocalDate startDate, LocalDate endDate) {
        return (int) startDate.datesUntil(endDate.plusDays(1)).count();
    }

    public static List<Rental> getRental() {
        return rentals;
    }

    /**
     * Displays the list of rentals.
     */
    public void listRentals() {
        System.out.println("\nRENTALS LIST");
        if (rentals.isEmpty() || rentals.get(0).getFilm() == null) {
            System.out.println("No film rented!");
            return;
        }

        for (int i = 0; i < rentals.size(); i++) {
            Rental rental = rentals.get(i);
            System.out.printf("DATA FILM: [Title=%-8s Genre=%-8s Year=%-10s Duration=%-3s Available=%-5s " +
                            "] DATA RENT: [Start date=%-10s End date=%-10s price=%.1f Interest=%.1f " +
                            "] Index:%d%n",
                    rental.getFilm().getTitle(), rental.getFilm().getGenre(), rental.getFilm().getYear(),
                    rental.getFilm().getDuration(), rental.getFilm().isAvailable(),
                    rental.getStartDate(), rental.getEndDate(), rental.getPrice(), rental.getInterest(), i);
        }
    }

    /**
     * Searches and displays rentals based on the start date.
     * This method prompts the user to enter a start date and searches for rentals with the specified start date
     * It displays the details of the rentals found.
     */
    public void searchRentalByStarDate() {
        System.out.println("\nSEARCH RENTAL BY START DATE");
        if (rentals.isEmpty()) {
            System.out.println("No film rented");
            return;
        }

        System.out.print("Enter the start date (dd/mm/yyyy): ");
        String dateStr = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(dateStr, formatter);
        for (Rental rental : rentals) {
            if (rental.getStartDate().equals(startDate)) {
                System.out.println(rental);
            }
        }
    }

    /**
     * This method allows the user to return a rented movie. It prompts the user to enter the name of the movie.
     * It then finds the corresponding rental based on the movie name.
     * The user is prompted to enter the return date, and the rental's return date is updated accordingly.
     * Depending on whether the returnDate matches the end date or is after it, the method calculates and displays the price to pay.
     * If the returnDate is after the end date, the user needs to pay a 10% interest.
     */
    public void returnMovie() {
        System.out.println("\nRETURN MOVIE");
        if (rentals.isEmpty()) {
            System.out.println("No film rented");
            return;
        }

        System.out.print("Enter the name of the film: ");
        String filmTitle = scanner.nextLine();

        Rental rental = rss.findFilmForRental(filmTitle);

        if (rental == null) {
            System.out.println("No rental found for the film: " + filmTitle);
            return;
        }

        System.out.print("Enter the return date (dd/mm/yyyy): ");
        LocalDate returnDate = validateDate.validReturnDate(rental.getStartDate());
        rental.setReturnDate(returnDate);

        rcs.calculatePriceToPay(rental, returnDate, filmTitle);

        rental.getFilm().setAvailable(true);
        rentals.remove(rental);
    }
}
