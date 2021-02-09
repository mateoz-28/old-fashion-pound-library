package oldfashionpound.operations;

import oldfashionpound.models.OldFashionPoundModel;
import oldfashionpound.utility.OldFashionPoundUtility;

/**
 * Class that has 4 static methods for arithmetic operations for the old money system of UK, before 1970.
 */
public class OldFashionPoundOperations {

    /**
     * Method that calculates sum of two input string representing OldFashionPound old money system of UK.
     * @param oldFashionPoundInput1 first input
     * @param oldFashionPoundInput2 second input
     * @return string representing sum of two inputs (oldFashionPoundInput1 + oldFashionPoundInput2)
     */
    public static String sum(String oldFashionPoundInput1, String oldFashionPoundInput2) {
        final long oldFashionPoundInput1Pence = OldFashionPoundUtility.convertOldFashionPoundModelToPence(OldFashionPoundUtility.extractNumericalValuesFromString(oldFashionPoundInput1));
        final long oldFashionPoundInput2Pence = OldFashionPoundUtility.convertOldFashionPoundModelToPence(OldFashionPoundUtility.extractNumericalValuesFromString(oldFashionPoundInput2));
        return OldFashionPoundUtility.convertPenceToOldFashionPoundModel(oldFashionPoundInput1Pence + oldFashionPoundInput2Pence).toString();
    }

    /**
     * Method that performs subtraction of two input string representing OldFashionPound old money system of UK.
     * @param oldFashionPoundInput1 first input
     * @param oldFashionPoundInput2 second input
     * @return string representing subtraction of two inputs (oldFashionPoundInput1 - oldFashionPoundInput2)
     */
    public static String subtraction(String oldFashionPoundInput1, String oldFashionPoundInput2) {
        final long oldFashionPoundInput1Pence = OldFashionPoundUtility.convertOldFashionPoundModelToPence(OldFashionPoundUtility.extractNumericalValuesFromString(oldFashionPoundInput1));
        final long oldFashionPoundInput2Pence = OldFashionPoundUtility.convertOldFashionPoundModelToPence(OldFashionPoundUtility.extractNumericalValuesFromString(oldFashionPoundInput2));
        return OldFashionPoundUtility.convertPenceToOldFashionPoundModel(oldFashionPoundInput1Pence - oldFashionPoundInput2Pence).toString();
    }

    /**
     * Method that performs multiplication of input string, representing OldFashionPound old money system of UK, and multiplication factor.
     * @param oldFashionPoundInput string representing OldFashionPound old money system of UK
     * @param multiplicationFactor multiplication factor
     * @return string representing multiplication of first input with multiplication factor (oldFashionPoundInput * multiplicationFactor)
     */
    public static String multiplication(String oldFashionPoundInput, int multiplicationFactor) {
        final long oldFashionPoundInputPence = OldFashionPoundUtility.convertOldFashionPoundModelToPence(OldFashionPoundUtility.extractNumericalValuesFromString(oldFashionPoundInput));
        return OldFashionPoundUtility.convertPenceToOldFashionPoundModel(oldFashionPoundInputPence*multiplicationFactor).toString();
    }

    /**
     * Method that performs division of input string, representing OldFashionPound old money system of UK, with divisor
     * @param oldFashionPoundInput string representing OldFashionPound old money system of UK
     * @param divisor divisor; must be different from zero
     * @return string representing division of first input with divisor (oldFashionPoundInput / multiplicationFactor) and remaining remainder (if exists)
     * @throws IllegalArgumentException if divisor is equal to zero
     */
    public static String division(String oldFashionPoundInput, int divisor) throws IllegalArgumentException {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor must not be zero.");
        }
        final long oldFashionPoundInputPence = OldFashionPoundUtility.convertOldFashionPoundModelToPence(OldFashionPoundUtility.extractNumericalValuesFromString(oldFashionPoundInput));
        OldFashionPoundModel oldFashionPoundModel = OldFashionPoundUtility.convertPenceToOldFashionPoundModel(oldFashionPoundInputPence/divisor);
        oldFashionPoundModel.setRemainderPence(oldFashionPoundInputPence%divisor);
        return oldFashionPoundModel.toString();
    }
}
