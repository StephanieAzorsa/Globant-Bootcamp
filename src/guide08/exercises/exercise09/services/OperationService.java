package guide08.exercises.exercise09.services;

import guide08.exercises.exercise09.entities.Mathematics;

public class OperationService {

    public Mathematics createRandomNumbers() {
        Mathematics mat = new Mathematics();
        mat.setNum1(Math.random() * 10);
        mat.setNum2(Math.random() * 10);
        return mat;
    }

    /**
     * Return the greater value between two numbers.
     *
     * @param mat Mathematics object
     * @return greater value between two numbers
     */
    public double returnGreater(Mathematics mat) {
        return Math.max(mat.getNum1(), mat.getNum2());
    }

    /**
     * Calculate the power of the greater value in the class raised to the smaller number.
     * Both values should be rounded before the calculation.
     *
     * @param mat Mathematics object
     * @return power of the greater value in the class raised to the smaller number
     */
    public double calculatePower(Mathematics mat) {
        double roundedNum1 = Math.round(mat.getNum1());
        double roundedNum2 = Math.round(mat.getNum2());
        return Math.pow(Math.max(roundedNum1, roundedNum2), Math.min(roundedNum1, roundedNum2));
    }

    /**
     * Calculate the square root of the smaller value in the class.
     * Before calculating the square root, the absolute value of the number should be obtained.
     *
     * @param mat Mathematics object
     * @return square root of the smaller value in the class
     */
    public double calculateSquareRoot(Mathematics mat) {
        double absNum1 = Math.abs(mat.getNum1());
        double absNum2 = Math.abs(mat.getNum2());
        return Math.sqrt(Math.min(absNum1, absNum2));
    }
}