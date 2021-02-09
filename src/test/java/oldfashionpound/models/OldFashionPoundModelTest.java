package oldfashionpound.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link OldFashionPoundModel}
 */
class OldFashionPoundModelTest {

    /**
     * Simple test for testing OldFashionPoundModel.toString() method
     */
    @Test
    void testToString() {
        String OldFashionPoundModelToString = new OldFashionPoundModel(12, 6, 4).toString();
        String expectedResult = "12p 6s 4d";
        Assertions.assertEquals(OldFashionPoundModelToString, expectedResult);

        OldFashionPoundModelToString = new OldFashionPoundModel(-12, -6, 4).toString();
        expectedResult = "-12p -6s 4d";
        Assertions.assertEquals(OldFashionPoundModelToString, expectedResult);

        OldFashionPoundModelToString = new OldFashionPoundModel(0, 0, 0).toString();
        expectedResult = "0p 0s 0d";
        Assertions.assertEquals(OldFashionPoundModelToString, expectedResult);
    }
}