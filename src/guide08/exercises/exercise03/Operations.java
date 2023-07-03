package guide08.exercises.exercise03;

import guide08.exercises.exercise03.entities.Operation;
import guide08.exercises.exercise03.services.OperationService;

public class Operations {
    public static void main(String[] args) {
        OperationService ops = new OperationService(); //Create an OperationService object
        Operation operation = ops.createOperation(); //Create an Operation object
        System.out.println("\nTHE OPERATIONS ARE: ");
        System.out.println("1. Sum: " + operation.getNumber1() + " + " + operation.getNumber2()
                + " = " + ops.sum(operation));
        System.out.println("2. Subtraction: " + operation.getNumber1() + " - " + operation.getNumber2()
                + " = " + ops.subtraction(operation));
        System.out.println("3. Multiplication: " + operation.getNumber1() + " * " + operation.getNumber2()
                + " = " + ops.multiplication(operation));
        System.out.println("4. Division: " + operation.getNumber1() + " / " + operation.getNumber2()
                + " = " + ops.division(operation));
    }
}
