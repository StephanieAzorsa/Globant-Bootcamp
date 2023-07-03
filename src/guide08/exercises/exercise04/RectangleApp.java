package guide08.exercises.exercise04;

import guide08.exercises.exercise04.entities.Rectangle;
import guide08.exercises.exercise04.services.RectangleService;

public class RectangleApp {
    public static void main(String[] args) {
        RectangleService rs = new RectangleService();

        Rectangle rectangle = rs.createRectangle();

        System.out.println("\nTHE SURFACE IS: " + rs.calculateSurface(rectangle));
        System.out.println("THE PERIMETER IS: " + rs.calculatePerimeter(rectangle));
        System.out.println("\nTHE RECTANGLE IS: ");
        rs.printRectangle(rectangle);
    }
}
