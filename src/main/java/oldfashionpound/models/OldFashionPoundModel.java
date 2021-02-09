package oldfashionpound.models;

import oldfashionpound.utility.OldFashionPoundUtility;

import java.util.Objects;

/**
 * Simple java class that represents old money system of the UK.
 * Before 1970., there were 12 pence in a shilling and 20 shillings, or 240 pence, in a pound.
 * Thus, a price in the OldUK Money system was expressed in Pounds, Shillings and Pence.
 * For example "12p 6s 10d" is 12 Pounds, 6 Shillings and 10 Pence.
 */
public class OldFashionPoundModel {
    private long pound;
    private long shilling;
    private long pence;
    private long remainderPence;

    public OldFashionPoundModel(long pound, long shilling, long pence) {
        this.pound = pound;
        this.shilling = shilling;
        this.pence = pence;
        this.remainderPence = 0;
    }

    public long getPound() { return pound; }

    public void setPound(long pound) { this.pound = pound; }

    public long getShilling() { return shilling; }

    public void setShilling(long shilling) { this.shilling = shilling; }

    public long getPence() { return pence; }

    public void setPence(long pence) { this.pence = pence; }

    public long getRemainderPence() { return remainderPence; }

    public void setRemainderPence(long remainderPence) { this.remainderPence = remainderPence; }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(pound + "p " + shilling + "s " + pence + "d");
        // If remainder exists, append remainder to output
        if (remainderPence != 0) {
            stringBuilder.append(" (" + OldFashionPoundUtility.convertPenceToOldFashionPoundModel(remainderPence) + ")");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OldFashionPoundModel that = (OldFashionPoundModel) o;
        return pound == that.pound && shilling == that.shilling && pence == that.pence;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pound, shilling, pence);
    }

}
