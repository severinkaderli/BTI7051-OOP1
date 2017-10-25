/**
 * This is a small program to calculate PI using the
 * Leibniz series.
 *
 * @author Severin Kaderli
 */
public class Pi {
    /**
     * Calculate pi using the Leibniz series.
     *
     * @param iterations Number of iterations for calculating PI
     * @return PI
     */
    public static double calculatePi(int iterations) {
        double pi = 0;
        for (int i = 0; i < iterations; i++) {
            pi += Math.pow(-1, i) / (2 * i + 1);
        }

        return pi * 4;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 5; i++) {
            System.out.println("10^" + i + ": " + calculatePi((int) Math.pow(10, i)));
        }
    }
}
