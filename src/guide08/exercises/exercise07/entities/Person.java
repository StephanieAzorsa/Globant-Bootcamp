package guide08.exercises.exercise07.entities;

import lombok.Data;

@Data
public class Person {
    private String name;
    private String lastName;
    private int age;
    private String gender;
    private float weight;
    private float height;

    public Person(String name, String lastName, int age, String gender, float weight, float height) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        setGender(gender); // Use the setter to validate the gender
        this.weight = weight;
        this.height = height;
    }

    public Person() {

    }

    public void setGender(String gender) {
        // Check if the gender is valid
        if (gender.equals("M") || gender.equals("F") || gender.equals("O"))
            this.gender = gender;
        else
            System.out.println("Error: Invalid gender.");
    }
}
