public class Boss extends Creeper {
    /**
     * Whether it's the first time the boss is hit or not.
     */
    boolean firstTimeHit;

    /**
     * Creates a new boss
     *
     * @param location The location of the boss.
     * @param board The board the boss belongs to.
     */
    public Boss(Location location, Board board) {
        super(location, board, new StepMover());
        this.sign = 'B';
        this.firstTimeHit = true;
    }

    /**
     * Execute the main action for the boss.
     */
    public void act() {
        if(this.isHit && this.firstTimeHit) {
            this.board.put(new Creeper(this.location, this.board, new StepMover()));
            this.energy--;
            this.firstTimeHit = false;
        }

        super.act();
    }
}
