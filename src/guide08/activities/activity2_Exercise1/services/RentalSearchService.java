package guide08.activities.activity2_Exercise1.services;

import guide08.activities.activity2_Exercise1.entities.Rental;

import java.util.Scanner;

public class RentalSearchService {
    private final Scanner scanner = new Scanner(System.in);

    Rental findFilmForRental(String filmTitle) {
        RentalService rentalService = new RentalService();
        if (isUniqueRentalTitle(filmTitle)) {
            return findRentalByFilmTitle(filmTitle);
        } else {
            rentalService.listAllRentals();
            System.out.print("Enter the index of the film: ");
            int index = scanner.nextInt();
            scanner.nextLine();
            return findRentalByFilmTitleAndIndex(filmTitle, index);
        }
    }

    Rental findFilmForReturn(String filmTitle) {
        RentalService rentalService = new RentalService();
        if (isUniqueRentalTitle(filmTitle)) {
            return findRentalByFilmTitle(filmTitle);
        } else {
            rentalService.listRentalsSameName(filmTitle);
            System.out.print("Enter the index of the film: ");
            int index = scanner.nextInt();
            scanner.nextLine();
            return findRentalByFilmTitleAndIndex(filmTitle, index);
        }
    }

    boolean isUniqueRentalTitle(String filmTitle){
        long count = RentalService.getRental()
                .stream()
                .filter(rental -> rental.getFilm().getTitle().equals(filmTitle))
                .filter(rental -> !rental.getFilm().isAvailable())
                .count();
        return count == 1;
    }

    public Rental findRentalByFilmTitle(String filmTitle) {
        return RentalService.getRental()
                .stream()
                .filter(rental -> rental.getFilm().getTitle().equals(filmTitle))
                .findFirst()
                .orElse(null);
    }

    Rental findRentalByFilmTitleAndIndex(String filmTitle, int index) {
        return RentalService.getRental()
                .stream()
                .filter(rental -> rental.getFilm().getTitle().equals(filmTitle))
                .skip(index)
                .findFirst()
                .orElse(null);
    }
}
