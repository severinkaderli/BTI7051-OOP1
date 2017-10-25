import java.util.ArrayList;
import java.util.List;

/**
 * This program calculates prime factors of a given
 * number and prints those out.
 *
 * @author Severin Kaderli
 */
public class PrimeFactors {
    /**
     * Get all prime factors for a number n.
     *
     * @param n The given number
     * @return A ordered list with the factors
     */
    public static List<Integer> getPrimeFactors(int n) {
        List<Integer> factors = new ArrayList<>();

        int i = 2;
        while (i * i <= n) {
            // Check if it's a factor
            if (n % i == 0) {
                n /= i;
                factors.add(i);
            } else {
                i++;
            }
        }

        // Add the number itself as factor
        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }

    public static void main(String[] args) {
        System.out.println(getPrimeFactors(10));
        System.out.println(getPrimeFactors(12));
        System.out.println(getPrimeFactors(24));
        System.out.println(getPrimeFactors(54325432));
    }
}
