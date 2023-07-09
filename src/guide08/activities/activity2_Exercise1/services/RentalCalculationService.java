package guide08.activities.activity2_Exercise1.services;

import guide08.activities.activity2_Exercise1.entities.Rental;

import java.time.LocalDate;

public class RentalCalculationService {

    /**
     * Calculates the price to pay for a rental based on the number of days rented.
     *
     * @param filmTitle The name of the movie to be rented.
     * @return The price to pay for the rental.
     */
    double calculatePricePerDay(String filmTitle) {
        RentalSearchService rss = new RentalSearchService();
        Rental rental = rss.findRentalByFilmTitle(filmTitle);
        RentalService rs = new RentalService();
        int daysRented = rs.daysRented(rental.getStartDate(), rental.getEndDate());
        return rental.getPrice() * daysRented;
    }

    /**
     * Calculates the price to pay for a rental based on the number of days rented and the interest (10% per additional day).
     *
     * @param filmTitle The name of the movie to be rented.
     * @return The price to pay for the rental.
     */
    double calculatePricePerAdditionalDay(String filmTitle) {
        RentalSearchService rss = new RentalSearchService();
        Rental rental = rss.findRentalByFilmTitle(filmTitle);
        RentalService rs = new RentalService();
        int additionalDays = rs.daysRented(rental.getEndDate(), rental.getReturnDate());
        double pricePerDay = rental.getPrice() + (rental.getPrice() * rental.getInterest());
        return calculatePricePerDay(filmTitle) + (additionalDays * pricePerDay);
    }

    /**
     * Calculates and displays the price to pay for a rental based on the return date and film title.
     * If the return date matches the end date of the rental, it calculates and displays the price per day.
     * If the return date is after the end date, it calculates and displays the price per additional day.
     *
     * @param rental The Rental object
     * @param returnDate The return date of the rental.
     * @param filmTitle The title of the film being returned.
     */
    void calculatePriceToPay(Rental rental, LocalDate returnDate, String filmTitle) {
        if (rental.getEndDate().equals(returnDate))
            System.out.println("Price to pay: " + calculatePricePerDay(filmTitle));

        if (rental.getEndDate().isBefore(returnDate))
            System.out.println("Price to pay: " + calculatePricePerAdditionalDay(filmTitle));
    }
}
