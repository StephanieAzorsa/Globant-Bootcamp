package guide07.exercises;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Exercise07Test {
    /**
     * Method under test: {@link Exercise07#isEureka(String)}
     */
    @Test
    void testIsEureka() {
        assertFalse(Exercise07.isEureka("Keyword"));
        assertTrue(Exercise07.isEureka("eureka"));
    }
}

