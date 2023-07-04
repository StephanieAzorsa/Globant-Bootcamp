package guide08.exercises.exercise05.entities;

import lombok.Data;

@Data
public class Account {
    private int accountNumber;
    private long dni;
    private double currentBalance;
}
