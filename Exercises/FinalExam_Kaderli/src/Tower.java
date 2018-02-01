

/**
 * Klasse für Tower-Objekte.
 */
public final class Tower extends GameElement {
    public static final int TOWER_PRIORITY = 2;

    /**
     * Konstruktor.
     *
     * @param location
     *            Die Stelle auf dem Spielfeld, an welcher sich das Tower-Objekt
     *            befindet. Darf nicht null sein und muss eine gültige Stelle
     *            auf dem Spielfeld bezeichnen.
     * @param board
     *            Darf nicht null sein.
     */
    protected Tower(Location location, Board board) {
        super(location, board, 'T', TOWER_PRIORITY);
    }

    @Override
    protected void act() {
        fire();
    }

    /**
     * Prüft, ob sich an der Stelle unmittelbar links vom Tower ein
     * GameElement-Objekt befindet. Ruft bei diesem Objekt die hit()-Methode
     * auf.
     */
    private void fire() {
        Location targetLocation = location.translate(-1, 0);
        if (board.isValid(targetLocation)) {
            GameElement target = board.peek(targetLocation);
            if (target != null)
                target.hit();
        }
    }
}