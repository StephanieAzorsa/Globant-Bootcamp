package guide08.activities.activity1_Exercise1.entities;

public class Vehicle {
    private String brand;
    private String model;
    private int year;
    private String type;
    private int distance = 0;

    public Vehicle() {
    }

    public Vehicle(String brand, String model, int year, String type, int distance) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.type = type;
        this.distance = distance;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", type='" + type + '\'' +
                ", distance=" + distance +
                '}';
    }
}
