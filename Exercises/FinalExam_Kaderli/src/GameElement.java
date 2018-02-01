/**
 * Im schriftlichen Teil habe ich den Teil mit der Überprüfung der einzelnen
 * Argumente auf die Gültigkeit im Konstruktor vergessen.
 *
 * Auch habe ich jetzt noch eine getLocation() Methode hinzugefügt.
 */
public abstract class GameElement {
    /**
     * The location of the game element.
     */
    protected Location location;

    /**
     * The board the game element belongs to.
     */
    protected Board board;

    /**
     * The sign of the game element.
     */
    protected char sign;

    /**
     * The priority of the game element.
     */
    protected int priority;

    /**
     * The energy of the game element.
     */
    protected int energy;

    /**
     * The health of the game element.
     */
    protected int health;

    /**
     * Whether the game element was hit or not.
     */
    protected boolean isHit;

    /**
     * Creates a new game element object.
     *
     * @param location The location of the game element
     * @param board The board the game element belongs to
     * @param sign The sign of the game element
     * @param priority The priority of the game element
     */
    protected GameElement(Location location, Board board, char sign, int priority) {
        if(board == null) {
            throw new IllegalArgumentException();
        }

        if(location == null || !board.isValid(location)) {
            throw new IllegalArgumentException();
        }

        this.location = location;
        this.board = board;
        this.sign = sign;
        this.priority = priority;
        this.energy = 20;
        this.health = 10;
        this.isHit = false;
    }

    /**
     * Returns the location of the game element.
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     * Checks if a location is the one of the game element.
     *
     * @param location The location that will be checked.
     * @return True if it's the same location, false otherwise
     */
    public final boolean isYourLocation(Location location) {
        return this.location.equals(location);
    }

    /**
     * Checks if the priority matches the one from the game element and act accordingly.
     *
     * @param priority The priority to check for
     */
    public final void checkPriorityAndAct(int priority) {
        this.isHit = false;

        if(this.priority == priority) {
            this.act();
        }
    }

    /**
     * The main action of the game element.
     */
    protected abstract void act();

    /**
     * Returns whether a game element is alive or not.
     *
     * @return True if it's alive, false otherwise
     */
    public final boolean isAlive() {
        return this.health > 0;
    }

    /**
     * Register a hit on the game element.
     */
    public void hit() {
        if(this.isAlive()) {
            this.health--;
            this.isHit = true;
        }
    }


    /**
     * Get the output of the game element as character.
     */
    @Override
    public String toString() {
        if(!this.isAlive()) {
            return "x";
        }

        if(this.isHit) {
            return "*";
        }

        return String.valueOf(this.sign);
    }
}
