import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ShuffleArray {

    public static final int ARRAY_SIZE = 100;

    /**
     * Swap elements a and b in the given array.
     *
     * @param array The given array
     * @param a First element
     * @param b Second element
     */
    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = array[a];
    }

    /**
     * Shuffle an array using the Fisher-Yates shuffle.
     *
     * @param values The array to be shuffled
     */
    public static void shuffleArray(int[] values) {
        for(int i = 0; i < values.length; i++) {
            Random random = new Random();
            int j = random.nextInt(values.length - i) + i;
            swap(values, i, j);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];

        // Fill the array with numbers 1 to ARRAY_SIZE
        for(int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        // Shuffle the array
        shuffleArray(array);

        // Print the array out
        System.out.println(Arrays.toString(array));
    }
}
