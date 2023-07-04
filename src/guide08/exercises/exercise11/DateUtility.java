package guide08.exercises.exercise11;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateUtility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the day: ");
        int day = scanner.nextInt();

        System.out.print("Enter the month (1-12): ");
        int monthInput = scanner.nextInt();

        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        int month = monthInput - 1; // Adjust month value to align with Calendar constants

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        Date date = calendar.getTime();

        Date currentDate = new Date();

        System.out.println("Entered date: " + date);
        System.out.println("Current date: " + currentDate);

        int yearsPassed = calculateYearsPassed(date, currentDate);
        System.out.println("Years passed: " + yearsPassed);
    }

    public static int calculateYearsPassed(Date startDate, Date endDate) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        int startYear = startCalendar.get(Calendar.YEAR);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        int endYear = endCalendar.get(Calendar.YEAR);

        if (endCalendar.get(Calendar.DAY_OF_YEAR) < startCalendar.get(Calendar.DAY_OF_YEAR))
            endYear--;

        return endYear - startYear;
    }
}
