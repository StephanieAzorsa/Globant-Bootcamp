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
    private static final List<Rental> rentals = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Creates a rental for a film.
     * This method prompts the user to enter rental data, including the film title, price, start date, and end date.
     * It creates a new Rental object with the entered data and adds it to the rental list.
     */
    public void createRental() {
        System.out.println("\n RENTAL DATA ENTRY");
        System.out.print("Enter the title of the film: ");
        String filmName = scanner.nextLine();

        Film film = findFilmByTitle(filmName);
        if (film == null) {
            System.out.println("Film not found!");
            return;
        }

        System.out.print("Enter the price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter start date (dd/mm/yyyy): ");
        LocalDate startDate = validStarDate();

        System.out.print("Enter end date (dd/mm/yyyy): ");
        LocalDate endDate = validEndDate(startDate);
        System.out.println("Day's rented: " + daysRented(startDate, endDate));
        Rental rental = new Rental(film, startDate, endDate, price);

        film.setAvailable(false);
        rentals.add(rental);
    }

    /**
     * Searches for a rental by the title of the film in the list of rentals.
     *
     * @param movieName The title of the movie to be searched.
     * @return The first rental found that matches the specified title.
     * If no match is found, it returns null.
     */
    //TODO: Implement when there are more than one movie with the same name in the Rentals list
    private Rental findRentalByFilmTitle(String movieName) {
        return rentals.stream()
                .filter(rental -> rental.getFilm().getTitle().equals(movieName))
                .findFirst()
                .orElse(null);
    }


    /**
     * Searches for a film by its title in the list of films.
     *
     * @param movieName The title of the movie to be searched.
     * @return The first film found that matches the specified title and isAvailable is true.
     * If no match is found, it returns null.
     */
    //TODO: Implement when there are more than one movie with the same name in the Films list
    private Film findFilmByTitle(String movieName) {
        return FilmService.getFilm()
                .stream()
                .filter(film -> film.getTitle().equals(movieName))
                .filter(Film::isAvailable)
                .findFirst()
                .orElse(null);
    }

    /**
     * Validates that the start of the date is later than or equal to the current date
     *
     * @return A LocalDate object representing the valid start date.
     */
    private LocalDate validStarDate() {
        while (true) {
            String dateStr = scanner.nextLine();
            LocalDate date = LocalDate.parse(dateStr, formatter);
            if (date.isBefore(LocalDate.now())) {
                System.out.println("Start date must be greater than or equal to the current date ("
                        + LocalDate.now().format(formatter) + ")");
            } else {
                return date;
            }
            System.out.print("Enter a star valid date: ");
        }
    }

    /**
     * Validates that the end date is later than or equal to the start date.
     *
     * @param startDate The start date of the rental.
     * @return A LocalDate object representing the valid end date.
     */
    private LocalDate validEndDate(LocalDate startDate) {
        while (true) {
            String dateStr = scanner.nextLine();
            LocalDate date = LocalDate.parse(dateStr, formatter);
            if (date.isBefore(startDate)) {
                System.out.println("End date must be greater than or equal to the start date ("
                        + startDate.format(formatter) + ")");
            } else {
                return date;
            }
            System.out.print("Enter a end valid date: ");
        }
    }

    /**
     * Calculates the number of days between two dates.
     *
     * @param startDate The start date of the rental.
     * @param endDate   The end date of the rental.
     * @return The number of days between the start date and the end date.
     */
    private int daysRented(LocalDate startDate, LocalDate endDate) {
        return (int) startDate.datesUntil(endDate.plusDays(1)).count();
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

        for (Rental rental : rentals)
            System.out.println(rental.toString());
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
        LocalDate startDate = LocalDate.parse(scanner.nextLine());

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
        String movieName = scanner.nextLine();

        Rental rental = findRentalByFilmTitle(movieName);

        if (rental == null) {
            System.out.println("No rental found for the film " + movieName);
            return;
        }

        System.out.print("Enter the return date (dd/mm/yyyy): ");
        LocalDate returnDate = validReturnDate(rental.getStartDate());
        rental.setReturnDate(returnDate);

        if (rental.getEndDate().equals(returnDate)) {
            System.out.println("Price to pay: " + calculatePricePerDay(movieName));
        }

        if (rental.getEndDate().isAfter(returnDate)) {
            System.out.println("Price to pay: " + calculatePricePerAdditionalDay(movieName));
        }

        rental.getFilm().setAvailable(true);
        rentals.remove(rental);
    }

    /**
     * Calculates the price to pay for a rental based on the number of days rented.
     *
     * @param movieName The name of the movie to be rented.
     * @return The price to pay for the rental.
     */
    public double calculatePricePerDay(String movieName) {
        Rental rental = findRentalByFilmTitle(movieName);
        int daysRented = daysRented(rental.getStartDate(), rental.getEndDate());
        return rental.getPrice() * daysRented;
    }

    /**
     * Calculates the price to pay for a rental based on the number of days rented and the interest (10% per additional day).
     *
     * @param movieName The name of the movie to be rented.
     * @return The price to pay for the rental.
     */
    public double calculatePricePerAdditionalDay(String movieName) {
        Rental rental = findRentalByFilmTitle(movieName);
        int additionalDays = daysRented(rental.getEndDate(), rental.getReturnDate());
        double pricePerDay = rental.getPrice() + (rental.getPrice() * rental.getInterest());
        return calculatePricePerDay(movieName) + (additionalDays * pricePerDay);
    }

    /**
     * Validates that the return date is later than or equal to the start date.
     *
     * @param startDate The start date of the rental.
     * @return A LocalDate object representing the valid return date.
     */
    private LocalDate validReturnDate(LocalDate startDate) {
        while (true) {
            String dateStr = scanner.nextLine();
            LocalDate date = LocalDate.parse(dateStr, formatter);
            if (date.isBefore(startDate)) {
                System.out.println("Return date must be greater than or equal to the start date ("
                        + startDate.format(formatter) + ")");
            } else {
                return date;
            }
            System.out.print("Enter a return valid date: ");
        }
    }

}
