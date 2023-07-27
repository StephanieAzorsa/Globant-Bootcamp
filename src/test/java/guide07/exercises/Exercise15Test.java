package guide07.exercises;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class Exercise15Test {
    /**
     * Method under test: {@link Exercise15#enterNumbers(int[])}
     */
    @Test
    void testEnterNumbers() {
        int[] expectedNumbers = new int[100];
        for (int i = 0; i < expectedNumbers.length; i++)
            expectedNumbers[i] = i + 1;

        int[] numbers = new int[100];
        Exercise15.enterNumbers(numbers);

        assertArrayEquals(expectedNumbers, numbers);
    }

    /**
     * Method under test: {@link Exercise15#reversePrintNumbers(int[])}
     */
    @Test
    void testReversePrintNumbers() {
        // Prepare to capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        int[] numbers = new int[100];
        Exercise15.enterNumbers(numbers);

        StringBuilder expectedOutput = new StringBuilder();
        for (int i = numbers.length - 1; i >= 0; i--)
            expectedOutput.append(numbers[i]).append(" ");

        // Call the method that prints to console
        Exercise15.reversePrintNumbers(numbers);

        // Retrieve the console output
        String actualOutput = outputStream.toString();

        assertEquals(expectedOutput.toString(), actualOutput);
    }
}

