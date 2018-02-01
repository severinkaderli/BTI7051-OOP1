/**
 * Im Gegensatz zum schriftlichen Teil habe ich hier bei der Methode move() noch
 * zusätzlich das Board als Parameter mitgegeben. Da man sonst nicht wissen kann,
 * ob eine Bewegung valide ist oder nicht, wenn man keine Infos über das Board hat.
 */
public interface Mover {
    public Location move(Location location, Board board);
}
