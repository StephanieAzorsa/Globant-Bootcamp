package guide08.activities.activity2_Exercise1.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidateDates {
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Validates that the start of the date is later than or equal to the current date
     *
     * @return A LocalDate object representing the valid start date.
     */
    LocalDate validStarDate() {
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
    LocalDate validEndDate(LocalDate startDate) {
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
     * Validates that the return date is later than or equal to the start date.
     *
     * @param startDate The start date of the rental.
     * @return A LocalDate object representing the valid return date.
     */
    LocalDate validReturnDate(LocalDate startDate) {
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
