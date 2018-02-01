/**
 * Im schriftlichen Teil konnte ich diese Klasse nicht fertigstellen.
 *
 * Ich wusste zuerst nicht, wie man ohne Informationen vom Board herausfinden
 * soll ob die neue Location valide oder nicht ist. Deshalb übergebe ich jetzt einfach
 * das Board als Parameter.
 */
public class JumpMover implements Mover {

    /**
     * Checks if you can move right twice and then once up or right twice and once down and returns the
     * correct new location object. If no movement is possible the original location is
     * returned.
     *
     * @param location The given location
     * @param board The board
     * @return The new location
     */
    public Location move(Location location, Board board) {

        Location topLocation = location.translate(2, -1);
        if(board.isValid(topLocation)) {
            return topLocation;
        }

        Location bottomLocation = location.translate(2, 1);
        if(board.isValid(bottomLocation)) {
            return bottomLocation;
        }


        return location;
    }

}
