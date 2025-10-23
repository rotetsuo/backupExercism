public class Secrets {

    /**
     * Task 1: Shifts the bits of a value to the right, inserting zeros from the left.
     * @param value The integer value to shift.
     * @param amount The number of places to shift.
     * @return The result of the right shift.
     */
    public static int shiftBack(int value, int amount) {
        // The '>>>' operator is the unsigned right shift, which guarantees
        // that zeros are added on the left side.
        return value >>> amount;
    }

    /**
     * Task 2: Sets bits in a value to 1 based on a mask.
     * @param value The original integer value.
     * @param mask The mask indicating which bits to set to 1.
     * @return The value with the specified bits set to 1.
     */
    public static int setBits(int value, int mask) {
        // The bitwise OR operator '|' sets a bit to 1 if it's 1 in either
        // the value or the mask.
        return value | mask;
    }

    /**
     * Task 3: Flips bits in a value based on a mask.
     * @param value The original integer value.
     * @param mask The mask indicating which bits to flip.
     * @return The value with the specified bits flipped.
     */
    public static int flipBits(int value, int mask) {
        // The bitwise XOR operator '^' flips a bit if the corresponding
        // bit in the mask is 1.
        return value ^ mask;
    }

    /**
     * Task 4: Clears bits (sets to 0) in a value based on a mask.
     * @param value The original integer value.
     * @param mask The mask indicating which bits to clear.
     * @return The value with the specified bits cleared.
     */
    public static int clearBits(int value, int mask) {
        // First, we invert the mask with '~' so that the bits to clear become 0
        // and all other bits become 1. Then, the bitwise AND operator '&'
        // preserves the bits from 'value' where the inverted mask is 1 and
        // clears the bits where the inverted mask is 0.
        return value & ~mask;
    }
}