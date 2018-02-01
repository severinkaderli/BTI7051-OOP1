public class Creeper extends GameElement {
    /**
     * The priority of the creeper.
     */
    public static final int CREEPER_PRIORITY = 1;

    /**
     * The mover of the creeper.
     */
    private Mover mover;

    /**
     * Creates a new Creeper object.
     *
     * @param location The location of the creeper
     * @param board The board the creeper belongs to
     * @param mover The mover for the creeper
     */
    public Creeper(Location location, Board board, Mover mover) {
        super(location, board, 'c', CREEPER_PRIORITY);
        this.mover = mover;
    }

    /**
     * Execute the main action for the creeper.
     */
    public void act() {
        if (this.isAlive()) {
            this.location = this.mover.move(this.location, this.board);
            this.energy--;
            if (this.energy < 10) {
                this.health--;
            }
        }
    }

}
