import java.util.Arrays;

/**
 * An implemenation of an IntegerList using an underlying array for data storage.
 *
 * @author Severin Kaderli
 */
public class IntegerList {
    /**
     * The initial length of the underlying array.
     */
    private final static int INITIAL_LENGTH = 10;

    /**
     * The array used to store the integers.
     */
    private int[] integers;

    /**
     * The current size of the list.
     */
    private int size;

    /**
     * Constructs a new list with inital settings.
     */
    public IntegerList() {
        this.integers = new int[INITIAL_LENGTH];
        this.size = 0;
    }

    /**
     * Add the element to the list.
     *
     * @param x The integer to add
     */
    public void add(int x) {
        if (this.size == this.integers.length) {
            this.integers = Arrays.copyOf(this.integers, 2 * this.integers.length);
        }
        this.integers[this.size] = x;
        this.size++;
    }

    /**
     * Insert an element to the given position in the list.
     *
     * @param x The integer to insert
     * @param position The position to insert
     */
    public void insert(int x, int position) {
        if (position < 0 || position > this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (this.size == this.integers.length) {
            this.integers = Arrays.copyOf(this.integers, 2 * this.integers.length);
        }

        for (int i = this.size; i > position; i--) {
            this.integers[i] = this.integers[i - 1];
        }
        this.integers[position] = x;
        this.size++;
    }

    /**
     * Removes an element from the list.
     *
     * @param position The position where the element will be removed
     * @return The removed element
     */
    public int remove(int position) {
        if (position < 0 || position > this.size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int result = this.integers[position];
        for (int i = position; i < this.size - 1; i++) {
            this.integers[i] = this.integers[i + 1];
        }
        this.size--;
        return result;
    }

    /**
     * Returns the size of the list.
     *
     * @return The size of the list
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Checks if the list contains an element.
     *
     * @param x The element to check
     * @return True if the list contains the element, false otherwise
     */
    public boolean contains(int x) {
        for(int i = 0; i < this.size; i++) {
            if(this.integers[i] == x) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the first position of an element in the list.
     *
     * @param x The element to find the position of.
     * @return The position of the element. -1 when the element is not in the list.
     */
    public int position(int x) {
        for(int i = 0; i < this.size; i++) {
            if(this.integers[i] == x) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Swap two values in the list.
     *
     * @param i Position of the first element
     * @param j Position of the second element
     */
    public void swap(int i, int j) {
        if(i < 0 || i > this.size - 1 || j < 0 || j > this.size -1) {
            throw new IndexOutOfBoundsException();
        }

        if(i != j) {
            int tmp = this.integers[i];
            this.integers[i] = this.integers[j];
            this.integers[j] = tmp;
        }
    }

    /**
     * Reverses the list.
     */
    public void reverse() {
        int i = 0;
        int j = this.size - 1;

        while(i < j) {
            swap(i, j);
            i++;
            j--;
        }
    }

    /**
     * Sorts the list using an implementation of the bubble sort algorithm.
     */
    public void sort() {
        boolean swapped;
        int n = this.size;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if(this.integers[i] > this.integers[i + 1]) {
                    swap(i, i + 1);
                    swapped = true;
                }
            }
            n--;
        } while(swapped);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(this.integers, this.size));
    }

}