package guide08.exercises.exercise02.services;

import guide08.exercises.exercise02.entities.Circumference;

import java.util.Scanner;

public class CircumferenceService {
    private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    /**
     * Creates a circumference object
     *
     * @return circumference
     */
    public Circumference createCircumference() {
        Circumference circumference = new Circumference();

        System.out.print("Enter the radius of the circumference: ");
        circumference.setRadius(scanner.nextFloat());

        return circumference;
    }

    /**
     * Calculates the area of a circumference
     *
     * @return area
     */
    public float area(Circumference circumference) {
        return (float) (Math.PI * Math.pow(circumference.getRadius(), 2));
    }

    /**
     * Calculates the perimeter of a circumference
     *
     * @return perimeter
     */
    public float perimeter(Circumference circumference) {
        return (float) (2 * Math.PI * circumference.getRadius());
    }
}
