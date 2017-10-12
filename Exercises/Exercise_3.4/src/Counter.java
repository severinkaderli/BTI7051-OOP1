/**
 * Class representation of a counter.
 *
 * @author Counter
 */
public class Counter {
    /**
     * The count
     */
    private int count;

    /**
     * Create a new counter and set the count to 0.
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * Get the current count.
     *
     * @return The current count
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Add one to the counter.
     */
    public void count() {
        this.count++;
    }

    /**
     * Reset the counter to 0.
     */
    public void reset() {
        this.count = 0;
    }
}
