package oldfashionpound.utility;

import oldfashionpound.models.OldFashionPoundModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link OldFashionPoundUtility}
 */
class OldFashionPoundUtilityTest {

    /**
     * Test for parsing input string into OldFashionPoundModel object
     */
    @Test
    void extractNumericalValuesFromString() {
        OldFashionPoundModel result = OldFashionPoundUtility.extractNumericalValuesFromString("9p 2s 6d");
        OldFashionPoundModel expectedResult = new OldFashionPoundModel(9, 2, 6);
        Assertions.assertEquals(result, expectedResult);

        result = OldFashionPoundUtility.extractNumericalValuesFromString("0p 2s 6d");
        expectedResult = new OldFashionPoundModel(0, 2, 6);
        Assertions.assertEquals(result, expectedResult);

        Assertions.assertThrows(NumberFormatException.class, () -> OldFashionPoundUtility.extractNumericalValuesFromString("9p2s6d"));
        Assertions.assertThrows(NumberFormatException.class, () -> OldFashionPoundUtility.extractNumericalValuesFromString("9p 2s6d"));
        Assertions.assertThrows(NumberFormatException.class, () -> OldFashionPoundUtility.extractNumericalValuesFromString("6d"));
        Assertions.assertThrows(NumberFormatException.class, () -> OldFashionPoundUtility.extractNumericalValuesFromString("-9p -2s -6d"));
    }

    /**
     * Test for converting OldFashionPoundModel to pence (long value)
     */
    @Test
    void convertOldFashionPoundModelToPence() {
        long result = OldFashionPoundUtility.convertOldFashionPoundModelToPence(new OldFashionPoundModel(2, 4, 6));
        long expectedResult = 6 + 4*12 + 2*20*12;
        Assertions.assertEquals(result, expectedResult);

        result = OldFashionPoundUtility.convertOldFashionPoundModelToPence(new OldFashionPoundModel(0, 0, 0));
        expectedResult = 0;
        Assertions.assertEquals(result, expectedResult);

        result = OldFashionPoundUtility.convertOldFashionPoundModelToPence(new OldFashionPoundModel(-5, -5, -7));
        expectedResult = -7 - 5*12 - 5*20*12;
        Assertions.assertEquals(result, expectedResult);

        result = OldFashionPoundUtility.convertOldFashionPoundModelToPence(new OldFashionPoundModel(2, 0, 0));
        expectedResult = 2*20*12;
        Assertions.assertEquals(result, expectedResult);
    }

    /**
     * Test for converting pence (long value) to OldFashionPoundModel
     */
    @Test
    void convertPenceToOldFashionPoundModel() {
        OldFashionPoundModel result = OldFashionPoundUtility.convertPenceToOldFashionPoundModel(480);
        OldFashionPoundModel expectedResult = new OldFashionPoundModel(2, 0, 0);
        Assertions.assertEquals(result, expectedResult);

        result = OldFashionPoundUtility.convertPenceToOldFashionPoundModel(0);
        expectedResult = new OldFashionPoundModel(0, 0, 0);
        Assertions.assertEquals(result, expectedResult);

        result = OldFashionPoundUtility.convertPenceToOldFashionPoundModel(-260);
        expectedResult = new OldFashionPoundModel(-1, -1, -8);
        Assertions.assertEquals(result, expectedResult);
    }
}