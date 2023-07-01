package guide08.exercises.exercise10_2;

import guide08.exercises.exercise10_2.entities.ArrayStructure;
import guide08.exercises.exercise10_2.services.ArrayService;

import java.util.Arrays;

public class ArrayApp {
    public static void main(String[] args) {
        ArrayStructure as = new ArrayService().createArray();
        System.out.println(as);

        ArrayService.sortArray(as);
        System.out.printf("Array C: %s%n", Arrays.toString(ArrayService.mergeArrays(as)));
    }
}
