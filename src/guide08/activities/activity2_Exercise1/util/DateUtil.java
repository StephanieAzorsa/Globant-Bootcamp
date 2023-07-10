package guide08.activities.activity2_Exercise1.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateUtil {
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public LocalDate validStarDate() {
        while (true) {
            String dateStr = scanner.nextLine().trim();
            try {
                LocalDate date = LocalDate.parse(dateStr, formatter);
                if (date.isBefore(LocalDate.now()))
                    System.out.println("Start date must be greater than or equal to the current date ("
                            + LocalDate.now().format(formatter) + ")");
                else return date;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter a valid date (e.g., "
                        + LocalDate.now().format(formatter) + ").");
            }
            System.out.print("Enter a valid date: ");
        }
    }

    public LocalDate validEndDate(LocalDate startDate) {
        while (true) {
            String dateStr = scanner.nextLine().trim();
            try {
                LocalDate date = LocalDate.parse(dateStr, formatter);
                if (date.isBefore(startDate))
                    System.out.println("End date must be greater than or equal to the start date ("
                            + startDate.format(formatter) + ")");
                else return date;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter a valid date (e.g., "
                        + startDate.format(formatter) + ").");
            }
            System.out.print("Enter a end valid date: ");
        }
    }

    public LocalDate validReturnDate(LocalDate startDate) {
        while (true) {
            String dateStr = scanner.nextLine().trim();
            try {
                LocalDate date = LocalDate.parse(dateStr, formatter);
                if (date.isBefore(startDate))
                    System.out.println("Return date must be greater than or equal to the start date ("
                            + startDate.format(formatter) + ")");
                else return date;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter a valid date (e.g., "
                        + startDate.format(formatter) + ").");
            }
            System.out.print("Enter a return valid date: ");
        }
    }
}
