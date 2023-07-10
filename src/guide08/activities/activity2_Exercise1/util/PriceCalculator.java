package guide08.activities.activity2_Exercise1.util;

import guide08.activities.activity2_Exercise1.entities.Rental;
import guide08.activities.activity2_Exercise1.services.RentalSearchService;
import guide08.activities.activity2_Exercise1.services.RentalService;

import java.time.LocalDate;

public class PriceCalculator {
    double calculatePricePerDay(String filmTitle) {
        RentalSearchService rss = new RentalSearchService();
        Rental rental = rss.findRentalByFilmTitle(filmTitle);
        RentalService rs = new RentalService();
        int daysRented = rs.daysRented(rental.getStartDate(), rental.getEndDate());
        return rental.getPrice() * daysRented;
    }

    double calculatePricePerAdditionalDay(String filmTitle) {
        RentalSearchService rss = new RentalSearchService();
        Rental rental = rss.findRentalByFilmTitle(filmTitle);
        RentalService rs = new RentalService();
        int additionalDays = rs.daysRented(rental.getEndDate(), rental.getReturnDate());
        double pricePerDay = rental.getPrice() + (rental.getPrice() * rental.getInterest());
        return calculatePricePerDay(filmTitle) + (additionalDays * pricePerDay);
    }

    public void calculatePriceToPay(Rental rental, LocalDate returnDate, String filmTitle) {
        if (rental.getEndDate().equals(returnDate))
            System.out.println("Price to pay: " + calculatePricePerDay(filmTitle));

        if (rental.getEndDate().isBefore(returnDate))
            System.out.println("Price to pay: " + calculatePricePerAdditionalDay(filmTitle));
    }
}
