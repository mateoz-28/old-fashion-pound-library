package oldfashionpound.utility;

import oldfashionpound.models.OldFashionPoundModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class containing methods for converting data from string to {@link oldfashionpound.models.OldFashionPoundModel}
 * and converting {@link oldfashionpound.models.OldFashionPoundModel} to pence
 */
public class OldFashionPoundUtility {

    /**
     * Helper method that checks input string and converts string to {@link oldfashionpound.models.OldFashionPoundModel}
     * @param oldFashionPoundInput input string for conversion
     * @return {@link oldfashionpound.models.OldFashionPoundModel} that contains pounds, shillings and pence
     * @throws NumberFormatException if input string is null, empty or in incorrect format
     */
    public static OldFashionPoundModel extractNumericalValuesFromString(String oldFashionPoundInput) throws NumberFormatException {
        // Check if input string is null or empty
        if (oldFashionPoundInput == null || oldFashionPoundInput.trim().isEmpty()) {
            throw new NumberFormatException("Input string must not be empty. Allowed format is 'Xp Ys Zd'");
        }

        // Trim input string and construct regex for validating that input string is in correct format "Xp Ys Zd"
        oldFashionPoundInput = oldFashionPoundInput.trim();
        Pattern pattern = Pattern.compile("((\\d+p\\s)(\\d+s\\s)(\\d+d))");
        Matcher matcher = pattern.matcher(oldFashionPoundInput);

        // If input string isn't in correct format, throw NumberFormatException
        if (!matcher.matches()) {
            throw new NumberFormatException("Input string isn't in correct format. Allowed format is 'Xp Ys Zd'");
        }

        // Initialize values
        long pounds = 0;
        long shillings = 0;
        long pence = 0;
        String[] poundsShillingPenceArray = oldFashionPoundInput.split("\\s", -1); // Split data with space delimiter

        for (String oldFashionedPound: poundsShillingPenceArray) {
            // Extract number from string and convert string to long
            final long oldFashionedPoundLongValue = Long.parseLong(oldFashionedPound.substring(0, oldFashionedPound.length() - 1));
            if (oldFashionedPound.contains("p")) { // If string contains 'p', set pounds
                pounds = oldFashionedPoundLongValue;
            } else if (oldFashionedPound.contains("s")) { // If string contains 's', set shillings
                shillings = oldFashionedPoundLongValue;
            } else if (oldFashionedPound.contains("d")) {// If string contains 'd', set pence
                pence = oldFashionedPoundLongValue;
            }
        }
        // Return instance of OldFashionPoundModel class
        return new OldFashionPoundModel(pounds, shillings, pence);
    }

    /**
     * Helper method that converts {@link oldfashionpound.models.OldFashionPoundModel} to pence
     * @param oldFashionPoundModel instance for conversion
     * @return long value representing {@link oldfashionpound.models.OldFashionPoundModel} amount in pence
     */
    public static long convertOldFashionPoundModelToPence(OldFashionPoundModel oldFashionPoundModel) {
        // 1 pound = 240 pence; 1 shilling = 12 pence
        return 240*oldFashionPoundModel.getPound() + 12*oldFashionPoundModel.getShilling() + oldFashionPoundModel.getPence();
    }

    /**
     * Helper method that converts pence to {@link oldfashionpound.models.OldFashionPoundModel}
     * @param pence long amount in pence
     * @return {@link oldfashionpound.models.OldFashionPoundModel} representing pence amount in pound, shillings and pence format
     */
    public static OldFashionPoundModel convertPenceToOldFashionPoundModel(long pence) {
        // 1 pound = 20 shillings; 1 shilling = 12 pence
        return new OldFashionPoundModel(pence/240, (pence/12)%20, pence%12);
    }

}
