package guide07.exercises;

// Declare four integer variables A, B, C and D and assign a different value to each
// one. Then perform the necessary instructions so that: B take the value of C, C
// take the value of A, A take the value of D, and D take the value of B.
// Display the initial values and the final values of each variable.
// Use only one auxiliary variable.

public class Exercise02 {
    public static void main(String[] args) {
        int aux;
        int valueA = 1;
        int valueB = 2;
        int valueC = 3;
        int valueD = 4;

        System.out.println("Initial values: ");
        System.out.println(" Value of A: " + valueA +
                "\n Value of B: " + valueB +
                "\n Value of C: " + valueC +
                "\n Value of D: " + valueD);

        aux = valueB;
        valueB = valueC;
        valueC = valueA;
        valueA = valueD;
        valueD = aux;

        System.out.println("\nFinal values: ");
        System.out.println(" Value of A: " + valueA +
                "\n Value of B: " + valueB +
                "\n Value of C: " + valueC +
                "\n Value of D: " + valueD);
    }
}
