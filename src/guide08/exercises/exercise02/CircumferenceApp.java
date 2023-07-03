package guide08.exercises.exercise02;

import guide08.exercises.exercise02.entities.Circumference;
import guide08.exercises.exercise02.services.CircumferenceService;

public class CircumferenceApp {
    public static void main(String[] args) {
        CircumferenceService cs = new CircumferenceService(); //Create a CircumferenceService object
        Circumference circumference = cs.createCircumference(); //Create a Circumference object
        System.out.println("Area: " + cs.area(circumference)); //Print the area of the circumference
        System.out.println("Perimeter: " + cs.perimeter(circumference)); //Print the perimeter of the circumference
    }
}
