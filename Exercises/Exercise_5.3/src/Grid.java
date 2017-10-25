/**
 * This program consists of some methods to print out ASCII
 * grids to the console.
 *
 * @author Severin Kaderli
 */
public class Grid {
    /**
     * Prints the "+-" part of the grids.
     *
     * @param columns Number of columns to print
     * @param cellSize Size of a cell
     */
    private static void printPlusMinus(int columns, int cellSize) {
        for (int i = 0; i < columns; i++) {
            System.out.print("+");
            for(int j = 0; j < cellSize; j++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }

    /**
     * Prints the "| " part of the grids.
     *
     * @param columns Number of columns to print
     * @param cellSize Size of a cell
     */
    private static void printPipes(int columns, int cellSize) {
        for (int i = 0; i < columns; i++) {
            System.out.print("|");
            for(int j = 0; j < cellSize; j++) {
                System.out.print(" ");
            }
        }
        System.out.println("| ");
    }

    /**
     * Prints a grid with the given number of rows
     * and columns and a cell size of 1.
     *
     * @param rows Number of rows
     * @param columns Number of columns
     */
    public static void printGrid(int rows, int columns) {
        printGrid(rows, columns, 1);
    }

    /**
     * Prints a grid with the given number of rows, columns and
     * a given cell size.
     *
     * @param rows Number of rows
     * @param columns Number of columns
     * @param cellSize Size of a cell
     */
    public static void printGrid(int rows, int columns, int cellSize) {
        for(int i = 0; i < rows; i++) {
            printPlusMinus(columns, cellSize);
            for(int j = 0; j < cellSize; j++) {
                printPipes(columns, cellSize);
            }
        }
        printPlusMinus(columns, cellSize);
    }

    public static void main(String[] args) {
        printGrid(4, 9);
        printGrid(4, 9, 2);
    }
}
