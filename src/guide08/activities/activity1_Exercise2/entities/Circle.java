package guide08.activities.activity1_Exercise2.entities;

import guide08.activities.activity1_Exercise2.service.IGeometric;

public class Circle implements IGeometric {

    private final double radio;
    private double area;
    private double perimeter;

    public Circle(double radio) {
        this.radio = radio;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public void area() {
        area = Math.PI * Math.pow(radio, 2);
    }

    @Override
    public void perimeter() {
        perimeter = 2 * Math.PI * radio;
    }
}
