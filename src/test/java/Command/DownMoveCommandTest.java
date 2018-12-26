package Command;

import Command.DownMoveCommand;
import model.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DownMoveCommandTest {
    private DownMoveCommand downMover;

    @BeforeEach
    void init() {
        downMover = new DownMoveCommand();
    }

    @Test
    void shouldNotMoveDownWhenTheGridIsNull() {
        List<Cell> grid = new ArrayList<>();
        downMover.move( grid, 0 );
        assertTrue( grid.isEmpty() );
    }

    @Test
    void shouldNotMoveDownWhenTheGridConsistsOfOnlyOneRow() {
        List<Cell> grid = Arrays.asList( new Cell( 4 ), new Cell( 2 ) );
        downMover.move( grid, 1 );
        assertEquals( 4, grid.get( 0 ).getValue() );
        assertEquals( 2, grid.get( 1 ).getValue() );
    }

    @Test
    void shouldMoveDownWhenTheDownCellIsEmpty() {
        List<Cell> grid = Arrays.asList( new Cell( 2 ), new Cell( 4 ),
                new Cell( 0 ), new Cell( 0 ) );
        downMover.move( grid, 2 );
        assertEquals( 0, grid.get( 0 ).getValue() );
        assertEquals( 0, grid.get( 1 ).getValue() );
        assertEquals( 2, grid.get( 2 ).getValue() );
        assertEquals( 4, grid.get( 3 ).getValue() );
    }

    @Test
    void shouldMergeWhenThereAreTwoCellsOfSameValuesInVertical() {
        List<Cell> grid = Arrays.asList( new Cell( 2 ), new Cell( 4 ),
                new Cell( 2 ), new Cell( 4 ) );
        downMover.move( grid, 2 );
        assertEquals( 0, grid.get( 0 ).getValue() );
        assertEquals( 0, grid.get( 1 ).getValue() );
        assertEquals( 4, grid.get( 2 ).getValue() );
        assertEquals( 8, grid.get( 3 ).getValue() );
    }

    @Test
    void shouldNotMoveDownWhenTheUpperCellIsEmptyAndDownCellIsNotEmpty() {
        List<Cell> grid = Arrays.asList( new Cell( 0 ), new Cell( 0 ),
                new Cell( 2 ), new Cell( 4 ) );
        downMover.move( grid, 2 );
        assertEquals( 0, grid.get( 0 ).getValue() );
        assertEquals( 0, grid.get( 1 ).getValue() );
        assertEquals( 2, grid.get( 2 ).getValue() );
        assertEquals( 4, grid.get( 3 ).getValue() );
    }

    @Test
    void shouldNotMoveDownWhenThereAreTwoDifferentValuesInVerticalRatherThan0() {
        List<Cell> grid = Arrays.asList( new Cell( 2 ), new Cell( 4 ),
                new Cell( 8 ), new Cell( 16 ) );
        downMover.move( grid, 2 );
        assertEquals( 2, grid.get( 0 ).getValue() );
        assertEquals( 4, grid.get( 1 ).getValue() );
        assertEquals( 8, grid.get( 2 ).getValue() );
        assertEquals( 16, grid.get( 3 ).getValue() );
    }

    @Test
    void shouldMoveDownCorrectlyForGivenValuesIn2By2Grid() {
        List<Cell> grid = Arrays.asList( new Cell( 8 ), new Cell( 16 ),
                new Cell( 0 ), new Cell( 16 ) );
        downMover.move( grid, 2 );
        assertEquals( 0, grid.get( 0 ).getValue() );
        assertEquals( 0, grid.get( 1 ).getValue() );
        assertEquals( 8, grid.get( 2 ).getValue() );
        assertEquals( 32, grid.get( 3 ).getValue() );
    }
}
