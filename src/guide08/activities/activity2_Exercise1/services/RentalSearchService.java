package guide08.activities.activity2_Exercise1.services;

import guide08.activities.activity2_Exercise1.entities.Rental;

import java.util.Scanner;

public class RentalSearchService {

    /**
     * Finds a rental for returning based on the film title.
     * If the film title is unique among the rentals, it directly finds the rental by film title.
     * Otherwise, it lists the rentals and prompts the user to enter the index of
     * the film to select the rental.
     *
     * @param filmTitle The title of the film to be returned.
     * @return The Rental object corresponding to the film title, if found.
     */
    Rental findFilmForRental(String filmTitle) {
        RentalService rentalService = new RentalService();
        Scanner scanner = new Scanner(System.in);
        if (isUniqueRentalTitle(filmTitle)) {
            return findRentalByFilmTitle(filmTitle);
        } else {
            rentalService.listRentals();
            System.out.print("Enter the index of the film: ");
            int index = scanner.nextInt();
            scanner.nextLine();
            return findRentalByFilmTitleAndIndex(filmTitle, index);
        }
    }

    /**
     * Checks if the rental name is unique among the rentals in the list.
     *
     * @param filmTitle The film name to check for uniqueness.
     * @return True if the film name is unique among the rentals, false otherwise.
     */
    boolean isUniqueRentalTitle(String filmTitle){
        long count = RentalService.getRental()
                .stream()
                .filter(rental -> rental.getFilm().getTitle().equals(filmTitle))
                .filter(rental -> !rental.getFilm().isAvailable())
                .count();
        return count == 1;
    }

    /**
     * Searches for a rental by the title of the film in the list of rentals.
     *
     * @param filmTitle The title of the movie to be searched.
     * @return The first rental found that matches the specified title.
     * If no match is found, it returns null.
     */
    Rental findRentalByFilmTitle(String filmTitle) {
        return RentalService.getRental()
                .stream()
                .filter(rental -> rental.getFilm().getTitle().equals(filmTitle))
                .findFirst()
                .orElse(null);
    }

    /**
     * Finds a rental by the film title and index in the list of rentals.
     *
     * @param filmTitle The title of the film to be searched.
     * @param index    The index of the rental to be searched.
     * @return The Rental object with the specified film title and index, if found.
     * Otherwise, returns null.
     */
    Rental findRentalByFilmTitleAndIndex(String filmTitle, int index) {
        return RentalService.getRental()
                .stream()
                .filter(rental -> rental.getFilm().getTitle().equals(filmTitle))
                .skip(index)
                .findFirst()
                .orElse(null);
    }
}
