package guide08.exercises.exercise04.services;

import guide08.exercises.exercise04.entities.Rectangle;

import java.util.Scanner;

public class RectangleService {
    Scanner scanner = new Scanner(System.in);

    public Rectangle createRectangle() {
        Rectangle rectangle = new Rectangle();

        System.out.print("Enter the base: ");
        rectangle.setBase(scanner.nextFloat());

        System.out.print("Enter the height: ");
        rectangle.setHeight(scanner.nextFloat());

        return rectangle;
    }

    public float calculateSurface(Rectangle rectangle) {
        return rectangle.getBase() * rectangle.getHeight();
    }

    public float calculatePerimeter(Rectangle rectangle) {
        return (rectangle.getBase() * 2) + (rectangle.getHeight() * 2);
    }

    public void printRectangle(Rectangle rectangle) {
        for (int i = 0; i < rectangle.getBase(); i++) {
            for (int j = 0; j < rectangle.getHeight(); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
