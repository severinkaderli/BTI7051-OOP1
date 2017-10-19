import java.awt.*;

/**
 * This class represents a line using a slope and a y-intercept.
 *
 * @author Severin Kaderli
 */
public class Line {

    /**
     * The slope of the line. If the line is vertical this is
     * Double.POSITIVE_INFINITY.
     */
    private double m;

    /**
     * The y-intercept of the line.
     */
    private double b;

    /**
     * The x position of the line if the line is vertical. Otherwise it's
     * always set to 0.
     */
    private double x;

    /**
     * Constructs a line using to points on the line.
     *
     * @param point       The first point on the line
     * @param secondPoint The second point on the line
     */
    public Line(Point point, Point secondPoint) {
        // Check if the line is vertical
        if (point.x == secondPoint.x) {
            this.m = Double.POSITIVE_INFINITY;
            this.b = 0;
            this.x = point.x;
        } else {
            this.m = (secondPoint.y - point.y) / (secondPoint.x - point.x);
            this.b = point.y - m * point.x;
            this.x = 0;
        }

    }

    /**
     * Construct a line using a point and the slope of the line.
     *
     * @param point A point on the line
     * @param m     The slope of the line
     */
    public Line(Point point, double m) {
        this.b = point.y - m * point.x;
        this.m = m;
        this.x = 0;
    }

    /**
     * Construct a line in the form of an equation y = mx + b.
     *
     * @param b The y-intercept
     * @param m The slope of the line
     */
    public Line(double b, double m) {
        this.b = b;
        this.m = m;
        this.x = 0;
    }

    /**
     * Construct a vertical line using a x position.
     *
     * @param x The x position of the vertial line.
     */
    public Line(int x) {
        this.x = x;
        this.b = 0;
        this.m = Double.POSITIVE_INFINITY;
    }

    /**
     * Returns whether the line is vertical or not.
     *
     * @return True if the line is vertical, false otherwise
     */
    public boolean isVertical() {
        return this.m == Double.POSITIVE_INFINITY;
    }

    /**
     * Returns whether the line is horizontal or not.
     *
     * @return True if the line is horizontal, false otherwise
     */
    public boolean isHorizontal() {
        return this.m == 0;
    }

    /**
     * Checks whether two lines are equal.
     *
     * @param otherLine The line to compare with
     * @return True if the lines are equal, false otherwise
     */
    public boolean equals(Line otherLine) {
        return (this.m == otherLine.m && this.b == otherLine.b);
    }

    /**
     * Returns whether two lines are parallel.
     *
     * @param otherLine The line to compare with
     * @return True if the lines are parallel, false otherwise
     */
    public boolean isParallel(Line otherLine) {
        return (this.m == otherLine.m);
    }

    // TODO: Implement this method
    public boolean intersects(Line otherLine) {
        return true;
    }
}
