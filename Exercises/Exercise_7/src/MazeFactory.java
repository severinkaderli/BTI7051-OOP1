import java.awt.*;

public class MazeFactory {

    /**
     * Create a new maze object based on the given configuration.
     *
     * @param mazeConfiguration The configuration of the maze
     * @return The built maze
     */
    public Maze buildMaze(int[][] mazeConfiguration) {
        Maze maze = new Maze();

        // Loop through the configuration and add the correct elements to
        // the maze.
        for(int[] row : mazeConfiguration) {
            maze.addRow();
            for(int elementType : row) {
                switch(elementType) {
                    case 1:
                        maze.addWall();
                        break;

                    case 2:
                        maze.addPellet();
                        break;

                    default:
                        maze.addFloor();
                        break;
                }
            }
        }

        return maze;
    }
}
