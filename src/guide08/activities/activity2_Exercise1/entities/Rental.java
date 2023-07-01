package guide08.activities.activity2_Exercise1.entities;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Rental {
    private final Film film;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final double price;
    private LocalDate returnDate;
    private double interest = 0.10;
}
