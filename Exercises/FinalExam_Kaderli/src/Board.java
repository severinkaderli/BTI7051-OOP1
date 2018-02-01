import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse habe ich eigentlich fast 1:1 wie im schriftlichen Teil umgesetzt. Lediglich
 * für die render() Methode hatte ich im schriftlichen Teil zu wenig Zeit gehabt und habe
 * sie deshalb nur grob erklärt.
 *
 * Die Umsetzung der Methode ist dann jedoch übereinstimmend mit meiner "Beschreibung" der Methode, aussser, dass
 * ich im schriftlichen Teil vergessen habe, den Buffer mit "Spaces" aufzufüllen.
 */
public final class Board {
    /**
     * The game elements of the board.
     */
    private List<GameElement> elements;

    /**
     * The width of the board.
     */
    private int width;

    /**
     * The height of the board.
     */
    private int height;

    /**
     * Initializes a new board.
     *
     * @param width The width of the board
     * @param height The height of the board
     */
    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.elements = new ArrayList<>();
    }

    /**
     * Adds a new game element to the board.
     *
     * @param gameElement The game element to add
     */
    public void put(GameElement gameElement) {
        this.elements.add(gameElement);
    }

    /**
     * Returns the game element at the given location. When no element is found then null will be
     * returned.
     *
     * @param location The location to check
     * @return Either the game element at the location or null.
     */
    public GameElement peek(Location location) {
        for(GameElement element: this.elements) {
            if(element.isYourLocation(location)) {
                return element;
            }
        }

        return null;
    }

    /**
     * Checks if the given location is valid for the current board.
     *
     * @param location The location to validate
     * @return True, if the location is valid, false otherwise
     */
    public boolean isValid(Location location) {
        if(location == null) {
            return false;
        }

        if(location.getX() < 0 || location.getY() < 0) {
            return false;
        }

        if(location.getX() >= this.width || location.getY() >= this.height) {
            return false;
        }

        return true;
    }

    /**
     * Updates the game elements.
     */
    public void update() {
        for(GameElement element : this.elements) {
            element.checkPriorityAndAct(Creeper.CREEPER_PRIORITY);
        }

        for(GameElement element : this.elements) {
            element.checkPriorityAndAct(Tower.TOWER_PRIORITY);
        }
    }

    /**
     * Prints the board to the console.
     */
    public void render() {
        // Initialise board buffer with spaces
        char[][] buffer = new char[this.height + 2][this.width];
        for(int row = 0; row < buffer.length; row++) {
            for(int col = 0; col < buffer[row].length; col++) {
                buffer[row][col] = ' ';
            }
        }

        // Add top lines
        for(int col = 0; col < buffer[0].length; col++) {
            buffer[0][col] = '-';
        }

        // Add bottom lines
        for(int col = 0; col < buffer[buffer.length - 1].length; col++) {
            buffer[buffer.length - 1][col] = '-';
        }

        // Add elements to buffer
        for(GameElement element : this.elements) {
            buffer[element.getLocation().getY() + 1][element.getLocation().getX()] = element.toString().charAt(0);
        }

        // Loop through the buffer and output it
        for(int row = 0; row < buffer.length; row++) {
            for(int col = 0; col < buffer[row].length; col++) {
                System.out.print(buffer[row][col]);
            }
            System.out.print("\n");
        }
    }
}
