package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LeftMoverTest {
    private LeftMover leftMover;

    @BeforeEach
    void init(){
        leftMover = new LeftMover();
    }

    @Test
    void shouldNotMoveLeftWhenTheGridIsNull() {
        List<Cell> grid = new ArrayList<>();
        leftMover.move( grid,0 );
        assertTrue( grid.isEmpty() );
    }

    @Test
    void shouldNotMoveLeftWhenTheGridConsistsOfOnlyOneCell(){
        List<Cell> grid = Collections.singletonList( new Cell(4) );
        leftMover.move( grid,1 );
        assertEquals( 4,grid.get( 0 ).getValue() );
    }

    @Test
    void shouldMoveLeftWhenTheLeftCellIsEmpty(){
        List<Cell> grid = Arrays.asList( new Cell(0), new Cell(2),
                new Cell(0), new Cell(4) );
        leftMover.move( grid,2 );
        assertEquals( 2, grid.get( 0 ).getValue() );
        assertEquals( 0, grid.get( 1 ).getValue() );
        assertEquals( 4, grid.get( 2 ).getValue() );
        assertEquals( 0, grid.get( 3 ).getValue() );
    }

    @Test
    void shouldMergeWhenThereAreTwoCellsOfSameValuesInVHorizontal(){
        List<Cell> grid = Arrays.asList( new Cell(2), new Cell(4),
                new Cell(2), new Cell(4) );
        leftMover.move( grid,2 );
        assertEquals( 4, grid.get( 0 ).getValue() );
        assertEquals( 0, grid.get( 1 ).getValue() );
        assertEquals( 8, grid.get( 2 ).getValue() );
        assertEquals( 0, grid.get( 3 ).getValue() );
    }

    @Test
    void shouldNotMoveLeftWhenTheLeftCellIsNotEmptyAndRightCellIsEmpty(){
        List<Cell> grid = Arrays.asList( new Cell(2), new Cell(0),
                new Cell(4), new Cell(0) );
        leftMover.move( grid,2 );
        assertEquals( 2, grid.get( 0 ).getValue() );
        assertEquals( 0, grid.get( 1 ).getValue() );
        assertEquals( 4, grid.get( 2 ).getValue() );
        assertEquals( 0, grid.get( 3 ).getValue() );
    }

    @Test
    void shouldNotMoveLeftWhenThereAreTwoDifferentValuesInARowRatherThan0(){
        List<Cell> grid = Arrays.asList( new Cell(2), new Cell(4),
                new Cell(8), new Cell(16) );
        leftMover.move( grid,2 );
        assertEquals( 2, grid.get( 0 ).getValue() );
        assertEquals( 4, grid.get( 1 ).getValue() );
        assertEquals( 8, grid.get( 2 ).getValue() );
        assertEquals( 16, grid.get( 3 ).getValue() );
    }
}
