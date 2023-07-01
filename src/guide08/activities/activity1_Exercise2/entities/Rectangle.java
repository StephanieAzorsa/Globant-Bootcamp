package guide08.activities.activity1_Exercise2.entities;

import guide08.activities.activity1_Exercise2.service.IGeometric;

public class Rectangle implements IGeometric {
    private final double base;
    private final double height;
    private double area;
    private double perimeter;

    public Rectangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public void area() {
        area = base * height;
    }

    @Override
    public void perimeter() {
        perimeter = 2 * (base + height);
    }
}
