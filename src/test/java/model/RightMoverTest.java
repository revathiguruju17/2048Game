package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RightMoverTest {
    private RightMover rightMover;

    @BeforeEach
    void init(){
        rightMover = new RightMover();
    }

    @Test
    void shouldNotMoveRightWhenTheGridIsNull() {
        List<Cell> grid = new ArrayList<>();
        rightMover.move( grid,0 );
        assertTrue( grid.isEmpty() );
    }

    @Test
    void shouldMoveRightWhenTheRightCellIsEmpty(){
        List<Cell> grid = Arrays.asList( new Cell(2), new Cell(0),
                new Cell(4), new Cell(0) );
        rightMover.move( grid,2 );
        assertEquals( 0, grid.get( 0 ).getValue() );
        assertEquals( 2, grid.get( 1 ).getValue() );
        assertEquals( 0, grid.get( 2 ).getValue() );
        assertEquals( 4, grid.get( 3 ).getValue() );
    }

    @Test
    void shouldMergeWhenThereAreTwoCellsOfSameValuesInARow(){
        List<Cell> grid = Arrays.asList( new Cell(2), new Cell(2),
                new Cell(4), new Cell(4) );
        rightMover.move( grid,2 );
        assertEquals( 0, grid.get( 0 ).getValue() );
        assertEquals( 4, grid.get( 1 ).getValue() );
        assertEquals( 0, grid.get( 2 ).getValue() );
        assertEquals( 8, grid.get( 3 ).getValue() );
    }

    @Test
    void shouldNotMoveRightWhenTheLeftCellIsEmptyAndRightCellIsNotEmpty(){
        List<Cell> grid = Arrays.asList( new Cell(0), new Cell(2),
                new Cell(0), new Cell(4) );
        rightMover.move( grid,2 );
        assertEquals( 0, grid.get( 0 ).getValue() );
        assertEquals( 2, grid.get( 1 ).getValue() );
        assertEquals( 0, grid.get( 2 ).getValue() );
        assertEquals( 4, grid.get( 3 ).getValue() );
    }

    @Test
    void shouldNotMoveRightWhenThereAreTwoDifferentValuesInRowRatherThan0(){
        List<Cell> grid = Arrays.asList( new Cell(2), new Cell(4),
                new Cell(8), new Cell(16) );
        rightMover.move( grid,2 );
        assertEquals( 2, grid.get( 0 ).getValue() );
        assertEquals( 4, grid.get( 1 ).getValue() );
        assertEquals( 8, grid.get( 2 ).getValue() );
        assertEquals( 16, grid.get( 3 ).getValue() );
    }

}
