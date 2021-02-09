package oldfashionpound.operations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link OldFashionPoundOperations}
 * Class performs tests for 4 arithmetic operations (sum, subtraction, multiplication and division).
 */
public class OldFashionPoundOperationsTest {
    // Inputs
    private final String firstInput = "5p 17s 8d";
    private final String secondInput = "3p 4s 10d";
    // Results
    private String result;
    private String expectedResult;

    /**
     * Test for performing sum operation on two input strings
     */
    @Test
    void sum() {
        result = OldFashionPoundOperations.sum(firstInput, secondInput);
        expectedResult = "9p 2s 6d";
        Assertions.assertEquals(result, expectedResult);
    }

    /**
     * Test for performing subtraction operation on two input strings
     */
    @Test
    void subtraction() {
        result = OldFashionPoundOperations.subtraction(firstInput, secondInput);
        expectedResult = "2p 12s 10d";
        Assertions.assertEquals(result, expectedResult);

        result = OldFashionPoundOperations.subtraction(secondInput, firstInput);
        expectedResult = "-2p -12s -10d";
        Assertions.assertEquals(result, expectedResult);
    }

    /**
     * Test for performing multiplication operation on input string and multiplication factor
     */
    @Test
    void multiplication() {
        int multiplicationFactor = 2;
        result = OldFashionPoundOperations.multiplication(firstInput, multiplicationFactor);
        expectedResult = "11p 15s 4d";
        Assertions.assertEquals(result, expectedResult);

        result = OldFashionPoundOperations.multiplication(firstInput, 0);
        expectedResult = "0p 0s 0d";
        Assertions.assertEquals(result, expectedResult);
    }

    /**
     * Test for performing multiplication operation on input string and divisor
     */
    @Test
    void division() {
        int firstDivisor = 3;
        result = OldFashionPoundOperations.division(firstInput, firstDivisor);
        expectedResult = "1p 19s 2d (0p 0s 2d)";
        Assertions.assertEquals(result, expectedResult);

        String thirdInput = "18p 16s 1d ";
        int secondDivisor = 15;
        result = OldFashionPoundOperations.division(thirdInput, secondDivisor);
        expectedResult = "1p 5s 0d (0p 1s 1d)";
        Assertions.assertEquals(result, expectedResult);

        Assertions.assertThrows(IllegalArgumentException.class, () -> OldFashionPoundOperations.division(firstInput, 0));
    }
}
