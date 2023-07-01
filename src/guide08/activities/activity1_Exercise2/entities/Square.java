package guide08.activities.activity1_Exercise2.entities;

import guide08.activities.activity1_Exercise2.service.IGeometric;

public class Square implements IGeometric {
    private final double side;
    private double area;
    private double perimeter;

    public Square(double side) {
        this.side = side;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public void area() {
        area = side * side;
    }

    @Override
    public void perimeter() {
        perimeter = side * 4;
    }
}
