package guide08.exercises.exercise03.services;

import guide08.exercises.exercise03.entities.Operation;

import java.util.Scanner;

public class OperationService {
    Scanner scanner = new Scanner(System.in);

    public Operation createOperation() {

        Operation operation = new Operation(); // CreCreates an operation object

        System.out.print("Enter the first number: ");
        operation.setNumber1(scanner.nextFloat()); // Sets the first number to the operation object

        System.out.print("Enter the second number: ");
        operation.setNumber2(scanner.nextFloat()); // Sets the second number to the operation object

        return operation;
    }

    public float sum(Operation operation) {
        return operation.getNumber1() + operation.getNumber2();
    }

    public float subtraction(Operation operation) {
        return operation.getNumber1() - operation.getNumber2();
    }

    public float multiplication(Operation operation) {
        if (operation.getNumber1() == 0 || operation.getNumber2() == 0) {
            System.out.println("Multiplication by zero is not allowed");
            return 0;
        } else {
            return operation.getNumber1() * operation.getNumber2();
        }
    }

    public float division(Operation operation) {
        if (operation.getNumber1() == 0 || operation.getNumber2() == 0) {
            System.out.println("Division by zero is not allowed");
            return 0;
        } else {
            return operation.getNumber1() / operation.getNumber2();
        }
    }

}
