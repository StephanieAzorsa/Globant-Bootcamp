package guide08.activities.activity1_Exercise2.service;

import guide08.activities.activity1_Exercise2.entities.*;

import java.util.Scanner;

public class GeometricService {
    Scanner sc = new Scanner(System.in);

    /**
     * This method is used to calculate the area and perimeter of a circle.
     */
    public void circle() {
        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();
        Circle circle = new Circle(radius);
        circle.area();
        circle.perimeter();
        System.out.println("Area of circle: " + circle.getArea());
        System.out.println("Perimeter of circle: " + circle.getPerimeter());
    }

    /**
     * This method is used to calculate the area and perimeter of a hexagon.
     */
    public void hexagon() {
        System.out.print("Enter side: ");
        double side = sc.nextDouble();
        System.out.print("Enter apothem: ");
        double apothem = sc.nextDouble();
        Hexagon hexagon = new Hexagon(side, apothem);
        hexagon.area();
        hexagon.perimeter();
        System.out.println("Area of hexagon: " + hexagon.getArea());
        System.out.println("Perimeter of hexagon: " + hexagon.getPerimeter());
    }

    /**
     * This method is used to calculate the area and perimeter of a pentagon.
     */
    public void pentagon() {
        System.out.print("Enter side: ");
        double side = sc.nextDouble();
        System.out.print("Enter apothem: ");
        double apothem = sc.nextDouble();
        Pentagon pentagon = new Pentagon(side, apothem);
        pentagon.area();
        pentagon.perimeter();
        System.out.println("Area of pentagon: " + pentagon.getArea());
        System.out.println("Perimeter of pentagon: " + pentagon.getPerimeter());
    }

    /**
     * This method is used to calculate the area and perimeter of a rectangle.
     */
    public void rectangle() {
        System.out.print("Enter base: ");
        double base = sc.nextDouble();
        System.out.print("Enter height: ");
        double height = sc.nextDouble();
        Rectangle rectangle = new Rectangle(base, height);
        rectangle.area();
        rectangle.perimeter();
        System.out.println("Area of rectangle: " + rectangle.getArea());
        System.out.println("Perimeter of rectangle: " + rectangle.getPerimeter());
    }

    /**
     * This method is used to calculate the area and perimeter of a rhombus.
     */
    public void rhombus() {
        System.out.print("Enter side: ");
        double side = sc.nextDouble();
        System.out.print("Enter diagonal 1: ");
        double diagonal1 = sc.nextDouble();
        System.out.print("Enter diagonal 2: ");
        double diagonal2 = sc.nextDouble();
        Rhombus rhombus = new Rhombus(side, diagonal1, diagonal2);
        rhombus.area();
        rhombus.perimeter();
        System.out.println("Area of rhombus: " + rhombus.getArea());
        System.out.println("Perimeter of rhombus: " + rhombus.getPerimeter());
    }

    /**
     * This method is used to calculate the area and perimeter of a square.
     */
    public void square() {
        System.out.print("Enter side: ");
        double side = sc.nextDouble();
        Square square = new Square(side);
        square.area();
        square.perimeter();
        System.out.println("Area of square: " + square.getArea());
        System.out.println("Perimeter of square: " + square.getPerimeter());
    }

    /**
     * This method is used to calculate the area and perimeter of a triangle.
     */
    public void triangle() {
        System.out.print("Enter base: ");
        double base = sc.nextDouble();
        System.out.print("Enter height: ");
        double height = sc.nextDouble();
        System.out.print("Enter side A: ");
        double sideA = sc.nextDouble();
        System.out.print("Enter side B: ");
        double sideB = sc.nextDouble();
        System.out.print("Enter side C: ");
        double sideC = sc.nextDouble();
        Triangle triangle = new Triangle(base, height, sideA, sideB, sideC);
        triangle.area();
        triangle.perimeter();
        System.out.println("Area of triangle: " + triangle.getArea());
        System.out.println("Perimeter of triangle: " + triangle.getPerimeter());
    }

    /**
     * This method is used to display the menu.
     */
    public void menu() {
        System.out.println("==================================");
        System.out.println("GeometricFigure Calculator");
        System.out.println("1. Circle");
        System.out.println("2. Hexagon");
        System.out.println("3. Pentagon");
        System.out.println("4. Rectangle");
        System.out.println("5. Rhombus");
        System.out.println("6. Square");
        System.out.println("7. Triangle");
        System.out.println("8. Exit");
        System.out.println("==================================");
        System.out.print("Enter your choice: ");
    }

    /**
     * This method is used to display the menu and calculate the area and perimeter of a geometric shape.
     */
    public void showMenu() {
        int choice;
        do {
            menu();
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> circle();
                case 2 -> hexagon();
                case 3 -> pentagon();
                case 4 -> rectangle();
                case 5 -> rhombus();
                case 6 -> square();
                case 7 -> triangle();
                case 8 -> System.out.println("Exit...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 8);
    }

}
