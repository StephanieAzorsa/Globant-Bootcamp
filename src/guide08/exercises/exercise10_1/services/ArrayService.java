package guide08.exercises.exercise10_1.services;

import guide08.exercises.exercise10_1.entities.ArrayStructure;

import java.util.Arrays;

public class ArrayService {

    /**
     * Creates and returns an ArrayStructure object with array A initialized with random values.
     *
     * @return The ArrayStructure object with array A
     */
    public ArrayStructure createArray() {
        ArrayStructure as = new ArrayStructure();
        double[] arrayA = new double[50];

        for (double i = 0; i < arrayA.length; i++)
            arrayA[(int) i] = Math.random() * 100;

        as.setArrayA(arrayA);

        return as;
    }

    /**
     * Create array B with the first 10 sorted elements of array A
     * and the other 10 elements as 1's.
     *
     * @param as ArrayStructure object containing array A
     * @return Array B with sorted elements and 1's
     */
    public double[] createArrayB(ArrayStructure as) {
        double[] arrayA = as.getArrayA();

        Arrays.sort(arrayA); // Sort array A

        double[] arrayB = new double[20];

        System.arraycopy(arrayA, 0, arrayB, 0, 10); // Copy the first 10 sorted elements of array A to array B
        Arrays.fill(arrayB, 10, 20, 0.5); // Fill the other 10 elements of array B with 0.5's

        return arrayB;
    }
}
