package ch.severinkaderli.pacman.Elements;

import ch.severinkaderli.pacman.Common.Type;

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

                switch(Type.valueOf(elementType)) {
                    case WALL:
                        maze.addWall();
                        break;

                    case PELLET:
                        maze.addPellet();
                        break;

                    case POWER_PELLET:
                        //maze.addPowerPellet();
                        break;

                    case PACMAN:
                        maze.addPacman();
                        break;


                    case FLOOR:
                    default:
                        maze.addFloor();
                        break;
                }
            }
        }

        return maze;
    }
}
