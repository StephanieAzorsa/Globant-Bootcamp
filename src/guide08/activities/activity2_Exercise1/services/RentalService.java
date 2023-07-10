package guide08.activities.activity2_Exercise1.services;

import guide08.activities.activity2_Exercise1.entities.Rental;
import guide08.activities.activity2_Exercise1.entities.Film;
import guide08.activities.activity2_Exercise1.util.DateUtil;
import guide08.activities.activity2_Exercise1.util.PriceCalculator;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalService {
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final List<Rental> rentals = new ArrayList<>();
    private final FilmSearchService fss = new FilmSearchService();
    private final RentalSearchService rss = new RentalSearchService();
    private final DateUtil validDate = new DateUtil();
    private final PriceCalculator priceCalculator = new PriceCalculator();

    public void createRental() {
        System.out.println("\nRENTAL DATA ENTRY");
        if (FilmService.getFilms().isEmpty()) {
            System.out.println("No film registered!");
            return;
        }

        System.out.print("Enter the title of the film: ");
        String filmTitle = scanner.nextLine().trim();

        Film film = fss.findFilmForRental(filmTitle);
        if (film == null) {
            System.out.println("Film not found!");
            return;
        }

        System.out.print("Enter the price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter start date (dd/mm/yyyy): ");
        LocalDate startDate = validDate.validStarDate();
        System.out.print("Enter end date (dd/mm/yyyy): ");
        LocalDate endDate = validDate.validEndDate(startDate);
        System.out.println("Day's rented: " + daysRented(startDate, endDate));
        Rental rental = new Rental(film, startDate, endDate, price);

        film.setAvailable(false);
        rentals.add(rental);
    }

    public int daysRented(LocalDate startDate, LocalDate endDate) {
        return (int) startDate.datesUntil(endDate.plusDays(1)).count();
    }

    public static List<Rental> getRental() {
        return rentals;
    }

    public void listAllRentals() {
        System.out.println("\nRENTALS LIST");
        listRental(rentals);
    }

    public void listRentalsSameName(String filmTitle) {
        System.out.println("\nLIST RENTALS SAME NAME");
        List<Rental> searchResults = rentals.stream()
                .filter(rental -> rental.getFilm().getTitle().equals(filmTitle))
                .toList();
        listRental(searchResults);
    }

    public void searchByCriteria(String criteria) {
        System.out.println("\nSEARCH BY " + criteria.toUpperCase());
        if (rentals.isEmpty()) {
            System.out.println("No film rented!");
            return;
        }
        System.out.print("Enter the " + criteria.toLowerCase() + ": ");
        String searchTerm = scanner.nextLine();

        List<Rental> searchResults = rentals.stream()
                .filter(rental -> matchesCriteria(rental, criteria, searchTerm))
                .toList();
        listRental(searchResults);
    }

    private boolean matchesCriteria(Rental rental, String criteria, String searchTerm) {
        return switch (criteria) {
            case "date" -> rental.getStartDate().equals(LocalDate.parse(searchTerm, formatter));
            case "title" -> rental.getFilm().getTitle().equalsIgnoreCase(searchTerm);
            default -> false;
        };
    }

    public void listRental(List<Rental> rentals) {
        if (rentals.isEmpty() || rentals.get(0).getFilm() == null) {
            System.out.println("No film rented!");
            return;
        }

        int index = 0;
        for (Rental rental : rentals) {
            System.out.printf("DATA FILM: [Title=%-8s Genre=%-8s Year=%-10s Duration=%-3s Available=%-10s " +
                            "] DATA RENT: [Start date=%-10s End date=%-10s price=%.1f Date rental=%-10s " +
                            " Interest=%.1f ] Index:%d%n",
                    rental.getFilm().getTitle(), rental.getFilm().getGenre(), rental.getFilm().getYear(),
                    rental.getFilm().getDuration(), rental.getFilm().isAvailable(),
                    rental.getStartDate(), rental.getEndDate(), rental.getPrice(), rental.getReturnDate(),
                    rental.getInterest(), index++);
        }
    }

    public void returnMovie() {
        System.out.println("\nRETURN MOVIE");
        if (rentals.isEmpty()) {
            System.out.println("No rental found!");
            return;
        }

        System.out.print("Enter the name of the film: ");
        String filmTitle = scanner.nextLine();

        Rental rental = rss.findFilmForReturn(filmTitle);
        if (rental == null) {
            System.out.println("No rental found for the film: " + filmTitle);
            return;
        }

        System.out.print("Enter the return date (dd/mm/yyyy): ");
        LocalDate returnDate = validDate.validReturnDate(rental.getStartDate());
        rental.setReturnDate(returnDate);
        priceCalculator.calculatePriceToPay(rental, returnDate, filmTitle);

        rental.getFilm().setAvailable(true);
        rentals.remove(rental);
    }
}
