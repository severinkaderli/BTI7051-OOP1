

/**
 * Hauptklasse des Test-Programms für Creeper-Klassen.
 */
public final class CreeperLab {
    private Board board;
    private Creeper creeper;

    /**
     * Konstruktor. Erzeugt das Spielfeld, den zu testenden Creeper und einen
     * Tower. Fügt beide dem Feld hinzu.
     */
    private CreeperLab() {
        board = new Board(10, 3);

        // Erzeugung des zu testenden Creeper-Objektes
        // (Auswahl durch Auskommentierungen in den folgenden drei Zeilen)
        creeper = new Creeper(new Location(0, 1), board, new StepMover());
//        creeper = new Creeper(new Location(0, 1), board, new JumpMover());
//        creeper = new Boss(new Location(0, 1), board);
        board.put(creeper);

        Tower tower = new Tower(new Location(5, 1), board);
        board.put(tower);
    }

    /**
     * Testschleife. Führt die Methoden update(), render() und sleep() solange
     * aus, bis der Creeper gestorben ist.
     */
    private void go() {
        board.render();
        while (creeper.isAlive()) {
            board.update();
            board.render();
            sleep();
        }
    }

    /**
     * Wartet eine Sekunde. Danach wird das Programm fortgesetzt.
     */
    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    /**
     * Main-Methode des Programms. Erzeugt ein CrepperLab-Objekt und ruft bei
     * diesem die Methode go() auf.
     */
    public static void main(String[] args) {
        CreeperLab lab = new CreeperLab();
        lab.go();
    }
}