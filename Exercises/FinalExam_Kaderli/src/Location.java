

import java.util.Objects;

/**
 * Ein Location-Objekt bezeichnet einen bestimmten Ort auf dem Spielfeld in Form
 * einer x- und einer y-Koordinate. Ein Location-Objekt ist unveränderlich
 * (immutable).
 */
public final class Location {
    private int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Gibt ein um deltaX und deltaY versetztes Location-Objekt zurück.
     */
    public Location translate(int deltaX, int deltaY) {
        return new Location(x + deltaX, y + deltaY);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (this.getClass() != other.getClass())
            return false;
        Location otherPoint = (Location) other;
        return this.x == otherPoint.x && this.y == otherPoint.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}