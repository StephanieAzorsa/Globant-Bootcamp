package guide08.activities.activity1_Exercise2.entities;

import guide08.activities.activity1_Exercise2.service.IGeometric;

public class Rhombus implements IGeometric {
    private final double side;
    private final double diagonal1;
    private final double diagonal2;
    private double area;
    private double perimeter;

    public Rhombus(double side, double diagonal1, double diagonal2) {
        this.side = side;
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public void area() {
        area = (diagonal1 * diagonal2) / 2;
    }

    @Override
    public void perimeter() {
        perimeter = 4 * side;
    }
}
