import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    @Test
    public void testGetWidth() {
        int[][] configuration = new int[][] {
                {0, 1, 1},
                {1, 1}
        };

        MazeFactory mazeFactory = new MazeFactory();
        Maze maze = mazeFactory.buildMaze(configuration);
        assertEquals(3, maze.getWidth());
        assertEquals(2, maze.getHeight());
    }

}