package Command;

import Command.UpMoveCommand;
import model.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UpMoveCommandTest {
    private UpMoveCommand upMover;

    @BeforeEach
    void init() {
        upMover = new UpMoveCommand();
    }

    @Test
    void shouldNotMoveDownWhenTheGridIsNull() {
        List<Cell> grid = new ArrayList<>();
        upMover.move( grid, 0 );
        assertTrue( grid.isEmpty() );
    }

    @Test
    void shouldNotMoveUpWhenTheGridConsistsOfOnlyOneRow() {
        List<Cell> grid = Arrays.asList( new Cell(4), new Cell(2) );
        grid.get( 0 ).setValue( 4 );
        grid.get( 1 ).setValue( 2 );
        upMover.move( grid, 1 );
        assertEquals( 4, grid.get( 0 ).getValue() );
        assertEquals( 2, grid.get( 1 ).getValue() );
    }

    @Test
    void shouldMoveUpWhenTheUpperCellIsEmpty() {
        List<Cell> grid = Arrays.asList( new Cell(0), new Cell(0),
                new Cell(2), new Cell(4) );
        upMover.move( grid, 2 );
        assertEquals( 2, grid.get( 0 ).getValue() );
        assertEquals( 4, grid.get( 1 ).getValue() );
        assertEquals( 0, grid.get( 2 ).getValue() );
        assertEquals( 0, grid.get( 3 ).getValue() );
    }

    @Test
    void shouldMergeWhenThereAreTwoCellsOfSameValuesInAColumn() {
        List<Cell> grid = Arrays.asList( new Cell(2), new Cell(4),
                new Cell(2), new Cell(4) );
        upMover.move( grid, 2 );
        assertEquals( 4, grid.get( 0 ).getValue() );
        assertEquals( 8, grid.get( 1 ).getValue() );
        assertEquals( 0, grid.get( 2 ).getValue() );
        assertEquals( 0, grid.get( 3 ).getValue() );
    }

    @Test
    void shouldNotMoveUpWhenTheLowerCellIsEmptyAndUpperCellIsNotEmpty() {
        List<Cell> grid = Arrays.asList( new Cell(2), new Cell(4),
                new Cell(0), new Cell(0) );
        upMover.move( grid, 2 );
        assertEquals( 2, grid.get( 0 ).getValue() );
        assertEquals( 4, grid.get( 1 ).getValue() );
        assertEquals( 0, grid.get( 2 ).getValue() );
        assertEquals( 0, grid.get( 3 ).getValue() );
    }

    @Test
    void shouldNotMoveUpWhenThereAreTwoDifferentValuesInVAColumnRatherThan0() {
        List<Cell> grid = Arrays.asList( new Cell( 2 ), new Cell( 4 ),
                new Cell( 8 ), new Cell( 16 ) );
        upMover.move( grid, 2 );
        assertEquals( 2, grid.get( 0 ).getValue() );
        assertEquals( 4, grid.get( 1 ).getValue() );
        assertEquals( 8, grid.get( 2 ).getValue() );
        assertEquals( 16, grid.get( 3 ).getValue() );
    }

}
