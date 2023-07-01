package guide08.activities.activity1_Exercise2.entities;

import guide08.activities.activity1_Exercise2.service.IGeometric;

public class Triangle implements IGeometric {
    private final double base;
    private final double height;
    private final double sideA;
    private final double sideB;
    private final double sideC;
    private double area;
    private double perimeter;

    public Triangle(double base, double height, double sideA, double sideB, double sideC) {
        this.base = base;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public void area() {
        area = (base * height) / 2;
    }

    @Override
    public void perimeter() {
        perimeter = sideA + sideB + sideC;
    }
}
