package guide08.exercises.exercise13.entities;

import lombok.Data;

@Data
public class CourseOperations {
    private int numberOfHoursPerDay;
    private int numberOfDaysPerWeek;
    private double pricePerHour;
}
