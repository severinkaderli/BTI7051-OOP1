/**
 * Simple class that has a method for calculating the cross sum of a number.
 *
 * @author Severin Kaderli
 */
public class CrossSum {
    /**
     * Calculates the cross sum of a number.
     *
     * @param n The number whose cross sum should be calculated
     * @return The cross sum of the number
     */
    private static int crossSum(int n) {
        // If it's only a single digit return it
        if(n % 10 == n) {
            return n;
        }

        return (n % 10) + crossSum(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("Expected: 13, Got: " + crossSum(175));
        System.out.println("Expected: 26, Got: " + crossSum(53756));
    }
}
