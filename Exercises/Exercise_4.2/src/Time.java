/**
 * This class represents a point in time e.g. 14:31:05. The format is in
 * hours, minutes and seconds.
 *
 * @author Severin Kaderli
 */
public class Time {
    /**
     * The hours of the point in time.
     */
    private int hours;

    /**
     * The minutes of the point in time.
     */
    private int minutes;

    /**
     * The seconds of the point in time.
     */
    private int seconds;

    /**
     * Returns the hours.
     *
     * @return The hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * Returns the minutes.
     *
     * @return The minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Returns the seconds.
     *
     * @return The seconds
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Create a new point in time.
     *
     * @param hours The hours of the point in time
     * @param minutes The minutes of the point in time
     * @param seconds The seconds of the point in time
     */
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * Checks if this time is before another time.
     *
     * @param comparisonTime The time to compare with
     * @return True if the time is before the comparison time, false otherwise
     */
    public boolean before(Time comparisonTime) {
        return (this.getHours() < comparisonTime.getHours())
                || (this.getHours() == comparisonTime.getHours()
                    && this.getMinutes() < comparisonTime.getMinutes())
                || (this.getHours() == comparisonTime.getHours()
                    && this.getMinutes() == comparisonTime.getMinutes()
                    && this.getSeconds() < comparisonTime.getSeconds());
    }

    /**
     * Checks if this time is after another time.
     *
     * @param comparisonTime The time to compare with
     * @return True if the time is after the comparison time, false otherwise
     */
    public boolean after(Time comparisonTime) {
        return !before(comparisonTime);
    }

    /**
     * Checks if the times are equal.
     *
     * @param comparisonTime The time to compare with
     * @return True if the times are equal, false otherwise
     */
    public boolean equals(Time comparisonTime) {
        return  (this.getHours() == comparisonTime.getHours())
                && (this.getMinutes() == comparisonTime.getMinutes())
                && (this.getSeconds() == comparisonTime.getSeconds());
    }

    /**
     * Return the point of time in a string representation.
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.getHours(), this.getMinutes(), this.getSeconds());
    }
}
