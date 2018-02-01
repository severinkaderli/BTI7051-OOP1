import ch.severinkaderli.pacman.Elements.Maze;
import ch.severinkaderli.pacman.Elements.MazeFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    private Maze maze;

    @BeforeEach
    public void setUp() {
        int[][] configuration = new int[][] {
                {0, 1, 1},
                {1, 1}
        };

        MazeFactory mazeFactory = new MazeFactory();
        maze = mazeFactory.buildMaze(configuration);
    }

    @Test
    public void testGetWidth() {

        assertEquals(3, maze.getWidth());
        assertEquals(2, maze.getHeight());
    }

    @AfterEach
    public void tearDown() {
        this.maze = null;
    }

}