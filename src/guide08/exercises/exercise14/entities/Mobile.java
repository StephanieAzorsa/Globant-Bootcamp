package guide08.exercises.exercise14.entities;

import lombok.Data;

@Data
public class Mobile {
    private String brand;
    private double price;
    private String model;
    private int memoryRAM;
    private double storage;
    private int[] code;
}
