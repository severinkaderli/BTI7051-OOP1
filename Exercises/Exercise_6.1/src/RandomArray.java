import java.util.Arrays;
import java.util.Random;

public class RandomArray {
    /**
     * The size of the random arrays.
     */
    private static final int ARRAY_SIZE = 100;

    /**
     * The upper bound for the random number generation.
     */
    private static final int NUMBER_UPPER_BOUND = 100;

    /**
     * Returns a random int between 1 and NUMBER_UPPER_BOUND.
     *
     * @return A random int
     */
    public static int getRandomValue() {
        Random random = new Random();
        return random.nextInt(NUMBER_UPPER_BOUND) + 1;
    }

    /**
     * Fills an array with random values.
     *
     * @param array The array to be filled.
     */
    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = getRandomValue();
        }
    }

    public static void main(String[] args) {
        int[] randomArray1 = new int[ARRAY_SIZE];
        fillArray(randomArray1);
        System.out.println(Arrays.toString(randomArray1));

        int[] randomArray2 = new int[ARRAY_SIZE];
        fillArray(randomArray2);
        System.out.println(Arrays.toString(randomArray2));
    }
}
