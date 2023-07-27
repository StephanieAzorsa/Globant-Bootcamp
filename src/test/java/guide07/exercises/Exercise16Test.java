package guide07.exercises;

import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

class Exercise16Test {
    /**
     * Method under test: {@link Exercise16#randomNumbers(int[])}
     */
    @Test
    void testRandomNumbers() {
        int[] numbers = new int[10];
        Exercise16.randomNumbers(numbers);

        // Check that all elements in the array are within the range [0, 99]
        for (int number : numbers) {
            assertTrue(number >= 0 && number < 100);
        }
    }

    /**
     * Method under test: {@link Exercise16#searchNumber(int[], int)}
     */
    @Test
    void testSearchNumber() {
        int[] numbers = {10, 1, 10, 1};

        // Test when the number is in the array
        int searchNumber = 10;
        Exercise16.searchNumber(numbers, searchNumber);

        // Test when the number is not in the array
        searchNumber = 5;
        Exercise16.searchNumber(numbers, searchNumber);
    }

    /**
     * Method under test: {@link Exercise16#searchNumber(int[], int)}
     */
    @Test
    void testSearchNumber2() {
        int[] numbers = {};

        // Test when the array is empty
        int searchNumber = 10;
        Exercise16.searchNumber(numbers, searchNumber);
    }
}

