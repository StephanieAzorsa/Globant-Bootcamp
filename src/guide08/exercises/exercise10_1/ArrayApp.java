package guide08.exercises.exercise10_1;

import guide08.exercises.exercise10_1.entities.ArrayStructure;
import guide08.exercises.exercise10_1.services.ArrayService;

import java.util.Arrays;

public class ArrayApp {
    public static void main(String[] args) {
        ArrayService as = new ArrayService();
        ArrayStructure array = new ArrayService().createArray();

        System.out.println(array);
        System.out.println("Array B: " + Arrays.toString(as.createArrayB(array)));

    }
}
