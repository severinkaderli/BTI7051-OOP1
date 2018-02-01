/**
 * Im schriftlichen Teil konnte ich diese Klasse nicht fertigstellen.
 *
 * Ich wusste zuerst nicht, wie man ohne Informationen vom Board herausfinden
 * soll ob die neue Location valide oder nicht ist. Deshalb übergebe ich jetzt einfach
 * das Board als Parameter.
 */
public class StepMover implements Mover {

    /**
     * Checks if you can move right, then up, then down and returns the
     * correct new location object. If no movement is possible the original location is
     * returned.
     *
     * @param location The given location
     * @param board The board
     * @return The new location
     */
    public Location move(Location location, Board board) {

        // Check right
        Location rightLocation = location.translate(1, 0);
        if(board.isValid(rightLocation)) {
            return rightLocation;
        }

        Location aboveLocation = location.translate(0, -1);
        if(board.isValid(aboveLocation)) {
            return aboveLocation;
        }

        Location belowLocation = location.translate(0, 1);
        if(board.isValid(belowLocation)) {
            return belowLocation;
        }

        return location;
    }
}
