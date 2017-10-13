/**
 * Representation of a rational number with a numerator and a denominator.
 *
 * @author Severin Kaderli
 */
public class RationalNumber {
    /**
     * The numerator of the rational number.
     */
    private long numerator;

    /**
     * The denominator of the rational number.
     */
    private long denominator;

    public RationalNumber(long value) {
        this(value, 1);
    }

    /**
     * Creates a rational number using a numerator and a denominator.
     *
     * @param numerator   The numerator
     * @param denominator The denominator
     */
    public RationalNumber(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
    }

    /**
     * Returns the numerator.
     *
     * @return The numerator
     */
    public long getNumerator() {
        return numerator;
    }

    /**
     * Sets the numerator.
     *
     * @param numerator The numerator
     */
    public void setNumerator(long numerator) {
        this.numerator = numerator;
    }

    /**
     * Returns the denominator.
     *
     * @return The denominator
     */
    public long getDenominator() {
        return denominator;
    }

    /**
     * Set the denominator
     *
     * @param denominator The denominator
     */
    private void setDenominator(long denominator) {
        this.denominator = denominator;
    }

    /**
     * Add two rational numbers together.
     *
     * @param x The rational number that will be added.
     * @return The new rational number
     */
    public RationalNumber add(RationalNumber x) {
        long numerator = (this.getNumerator() * x.getDenominator()) + (x.getNumerator() * this.getDenominator());
        long denominator = this.getDenominator() * x.getDenominator();

        return new RationalNumber(numerator, denominator);
    }

    /**
     * Multiply two rational numbers together.
     *
     * @param x The rational number that will be multiplied with
     * @return The new rational number
     */
    public RationalNumber multiply(RationalNumber x) {
        long numerator = this.getNumerator() * x.getNumerator();
        long denominator = this.getDenominator() * x.getDenominator();

        return new RationalNumber(numerator, denominator);
    }

    /**
     * Reduces the rational number.
     */
    private void reduce() {
        long gcd = RationalNumber.gcd(this.getNumerator(), this.getDenominator());

        if (gcd > 1) {
            this.setNumerator(this.getNumerator() / gcd);
            this.setDenominator(this.getDenominator() / gcd);
        }
    }

    /**
     * Returns the number as a fraction string.
     *
     * @return The fraction string
     */
    @Override
    public String toString() {
        if(this.denominator == 1) {
            return String.valueOf(this.numerator);
        } else {
            return this.numerator + "/" + this.denominator;
        }

    }

    /**
     * Get the double value of the rational number.
     *
     * @return The double value
     */
    public double toDouble() {
        return (double) numerator / denominator;
    }

    /**
     * Returns the greatest common divisor of two numbers.
     *
     * @param a The first number
     * @param b The second number
     * @return The gcd of the two numbers
     */
    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
