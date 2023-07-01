package guide08.exercises.exercise10_2.services;

import guide08.exercises.exercise10_2.entities.ArrayStructure;

import java.util.Arrays;

public class ArrayService {

    /**
     * Creates and returns an ArrayStructure object with array A and array B initialized with random values.
     *
     * @return The ArrayStructure object with array A and array B
     */
    public ArrayStructure createArray() {
        ArrayStructure as = new ArrayStructure();
        int[] arrayA = new int[20];
        int[] arrayB = new int[10];

        for (int i = 0; i < arrayA.length; i++)
            arrayA[i] = (int) (Math.random() * 100);

        for (int i = 0; i < arrayB.length; i++)
            arrayB[i] = (int) (Math.random() * 100);

        as.setArrayA(arrayA);
        as.setArrayB(arrayB);

        return as;
    }

    /**
     * Sorts the arrays A and B in ascending order and prints the sorted arrays.
     *
     * @param as The ArrayStructure object containing arrays A and B
     */
    public static void sortArray(ArrayStructure as) {
        int[] arrayA = as.getArrayA();
        int[] arrayB = as.getArrayB();

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        System.out.println("Sorted Array A: " + Arrays.toString(arrayA));
        System.out.println("Sorted Array B: " + Arrays.toString(arrayB));
    }

    /**
     * Merges arrays A and B from the ArrayStructure object and returns the merged array.
     *
     * @param as The ArrayStructure object containing arrays A and B
     * @return The merged array of A and B
     */
    public static int[] mergeArrays(ArrayStructure as) {
        int[] arrayA = as.getArrayA();
        int[] arrayB = as.getArrayB();

        int borrowedArrayB = arrayB.length - 5; // 5 is the number of elements to be removed from arrayB
        int borrowedArrayA = arrayA.length;

        int[] arrayC = new int[borrowedArrayA + borrowedArrayB];

        System.arraycopy(arrayA, 0, arrayC, 0, borrowedArrayA);
        System.arraycopy(arrayB, 0, arrayC, arrayA.length, borrowedArrayB);

        return arrayC;
    }

}
