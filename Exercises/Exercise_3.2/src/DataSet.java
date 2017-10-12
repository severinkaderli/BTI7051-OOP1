import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSet {
    /**
     * List of the values.
     */
    private List<Integer> values;

    /**
     * The sum of the values.
     */
    private long sum;

    /**
     * The average of the values.
     */
    private double average;

    /**
     * The max value in the dataset.
     */
    private int max;

    /**
     * The min value in the dataset.
     */
    private int min;

    /**
     *
     */
    public DataSet() {
        this.values = new ArrayList<>();
        this.sum = 0;
        this.average = 0;
        this.max = 0;
        this.min = 0;
    }

    /**
     * Add a value to the dataset.
     *
     * @param x The value to be added
     */
    public void addValue(int x) {
        this.values.add(x);

        this.calculateSum();
        this.calculateAverage();
        this.calculateMax();
        this.calculateMin();
    }

    /**
     * Calculate the current sum.
     */
    private void calculateSum() {
        this.sum = 0;

        this.values.forEach(value -> this.sum += value);
    }

    /**
     * Returns the sum.
     *
     * @return The sum of the dataset
     */
    public long getSum() {
        return this.sum;
    }

    /**
     * Calculate the current average.
     */
    private void calculateAverage() {
        this.average = (double) this.getSum() / this.values.size();
    }

    /**
     * Get the average.
     *
     * @return The average value of the dataset
     */
    public double getAverage() {
        return this.average;
    }

    /**
     * Calculates the current max value.
     */
    private void calculateMax() {
        this.max = Collections.max(this.values);
    }

    /**
     * Get the max value.
     *
     * @return The max value of the dataset
     */
    public int getMax() {
        return this.max;
    }

    /**
     * Calculates the current min value.
     */
    private void calculateMin() {
        this.min = Collections.min(this.values);
    }

    /**
     * Get the min value.
     *
     * @return The min value of the dataset
     */
    public int getMin() {
        return this.min;
    }
}
