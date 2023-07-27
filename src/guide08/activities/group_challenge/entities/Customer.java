package guide08.activities.group_challenge.entities;

import lombok.Data;

@Data
public class Customer {
    private String id;
    private String name;
    private int age;
    private double height;
    private double weight;
    private String objective;

    public Customer() {
    }

    public Customer(String id, String name, int age, double height, double weight, String objective) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.objective = objective;
    }
}
