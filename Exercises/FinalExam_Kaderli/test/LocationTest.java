import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Im schriftlichen Teil bin ich leider nicht mehr dazu gekommen, den Unit-Test zu skizzieren.
 *
 * Deshalb gibt es zu dieser Test-Implementierung keine Notizen von mir. Aber Grundsätzlich
 * teste ich einfach jede Methode und schaue, ob sie das zurück gibt, was sie sollte.
 */
class LocationTest {

    private Location location;

    @BeforeEach
    public void setUp() {
        this.location = new Location(10, 5);
    }

    @Test
    public void testGetX() {
        assertEquals(10, this.location.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(5, this.location.getY());
    }

    @Test
    public void testTranslate() {
        Location newLocation = location.translate(-5, 2);
        assertEquals(5, newLocation.getX());
        assertEquals(7, newLocation.getY());
    }

    @Test
    public void testEquals() {
        Location otherLocation = new Location(10, 5);
        assertEquals(true, this.location.equals(otherLocation));
    }

    @Test
    public void testHashCode() {
        Location otherLocation = new Location(10, 5);
        assertEquals(this.location.hashCode(), otherLocation.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("(10,5)", location.toString());
    }

}