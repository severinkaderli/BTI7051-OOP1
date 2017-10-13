import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSet {
    /**
     * The number of values.
     */
    private int count;
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
        this.sum = 0;
        this.average = 0;
        this.count = 0;
        this.max = Integer.MIN_VALUE;
        this.min = Integer.MAX_VALUE;
    }

    /**
     * Return the number of values in the dataset.
     *
     * @return The number of values
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Add a value to the dataset.
     *
     * @param x The value to be added
     */
    public void addValue(int x) {
        this.sum += x;
        this.count++;
        this.calculateAverage();
        this.calculateMax(x);
        this.calculateMin(x);
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
        this.average = (double) this.getSum() / this.getCount();
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
     *
     * @param x The newly added number
     */
    private void calculateMax(int x) {
        if(x > this.max) {
            this.max = x;
        }
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
     *
     * @param x The newly added number
     */
    private void calculateMin(int x) {
        if(x < this.min) {
            this.min = x;
        }
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
