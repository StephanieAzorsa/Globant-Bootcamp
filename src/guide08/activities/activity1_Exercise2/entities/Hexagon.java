package guide08.activities.activity1_Exercise2.entities;

import guide08.activities.activity1_Exercise2.service.IGeometric;

public class Hexagon implements IGeometric {
    private final double side;
    private final double apothem;
    private double area;
    private double perimeter;

    public Hexagon(double side, double apothem) {
        this.side = side;
        this.apothem = apothem;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public void area() {
        area = (6 * side * apothem) / 2;
    }

    @Override
    public void perimeter() {
        perimeter = 6 * side;
    }
}
