package guide08.exercises.exercise09;

import guide08.exercises.exercise09.entities.Mathematics;
import guide08.exercises.exercise09.services.OperationService;

public class OperationMathematics {
    public static void main(String[] args) {

        OperationService ops = new OperationService();
        Mathematics mat = ops.createRandomNumbers();

        System.out.println(mat);

        System.out.println("\n1. Greater value: " + ops.returnGreater(mat));
        System.out.println("2. Power of the greater value raised to the smaller number: "
                + ops.calculatePower(mat));
        System.out.println("3. Square root of the smaller value: "
                + ops.calculateSquareRoot(mat));

    }
}
