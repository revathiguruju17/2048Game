package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeftMoverTest {

    @Test
    void shouldMoveLeftSideCorrectlyForTheGivenSetOfValuesIn3By3Grid() {
        List<Cell> grid = Arrays.asList( new Cell(), new Cell(), new Cell(), new Cell(), new Cell(),
                new Cell(), new Cell(), new Cell(), new Cell() );
        grid.get( 2 ).setValue( 2 );
        grid.get( 4 ).setValue( 2 );
        grid.get( 5 ).setValue( 2 );
        grid.get( 7 ).setValue( 8 );
        grid.get( 8 ).setValue( 4 );
        LeftMover leftMover = new LeftMover();
        leftMover.move( grid, 3 );
        assertEquals( 2, grid.get( 0 ).getValue() );
        assertEquals( 0, grid.get( 1 ).getValue() );
        assertEquals( 0, grid.get( 2 ).getValue() );
        assertEquals( 4, grid.get( 3 ).getValue() );
        assertEquals( 8, grid.get( 6 ).getValue() );
        assertEquals( 4, grid.get( 7 ).getValue() );
    }

    @Test
    void shouldMoveLeftSideCorrectlyForTheSetOfValuesIn3By3Grid() {
        List<Cell> cells = Arrays.asList( new Cell(), new Cell(), new Cell(), new Cell(), new Cell(),
                new Cell(), new Cell(), new Cell(), new Cell() );
        cells.get( 0 ).setValue( 2 );
        cells.get( 1 ).setValue( 2 );
        cells.get( 2 ).setValue( 2 );
        cells.get( 4 ).setValue( 2 );
        cells.get( 5 ).setValue( 4 );
        cells.get( 6 ).setValue( 4 );
        cells.get( 7 ).setValue( 4 );
        cells.get( 8 ).setValue( 8 );
        LeftMover leftMover = new LeftMover();
        leftMover.move( cells, 3 );
        assertEquals( 4, cells.get( 0 ).getValue() );
        assertEquals( 2, cells.get( 1 ).getValue() );
        assertEquals( 0, cells.get( 2 ).getValue() );
        assertEquals( 2, cells.get( 3 ).getValue() );
        assertEquals( 4, cells.get( 4 ).getValue() );
        assertEquals( 8, cells.get( 6 ).getValue() );
        assertEquals( 8, cells.get( 7 ).getValue() );
        assertEquals( 0, cells.get( 8 ).getValue() );
    }

    @Test
    void shouldMoveLeftSideCorrectlyForTheSetOfValuesIn4By4Grid() {
        List<Cell> cells = Arrays.asList( new Cell(), new Cell(), new Cell(), new Cell(), new Cell(),
                new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(),
                new Cell(), new Cell(), new Cell(), new Cell() );
        cells.get( 0 ).setValue( 8 );
        cells.get( 1 ).setValue( 8 );
        cells.get( 2 ).setValue( 16 );
        cells.get( 4 ).setValue( 4 );
        cells.get( 5 ).setValue( 4 );
        cells.get( 6 ).setValue( 2 );
        cells.get( 9 ).setValue( 2 );
        cells.get( 10 ).setValue( 4 );
        cells.get( 12 ).setValue( 32 );
        cells.get( 13 ).setValue( 16 );
        cells.get( 14 ).setValue( 16 );
        cells.get( 15 ).setValue( 64 );
        LeftMover leftMover = new LeftMover();
        leftMover.move( cells, 4 );
        assertEquals( 16, cells.get( 0 ).getValue() );
        assertEquals( 16, cells.get( 1 ).getValue() );
        assertEquals( 0, cells.get( 2 ).getValue() );
        assertEquals( 0, cells.get( 3 ).getValue() );
        assertEquals( 8, cells.get( 4 ).getValue() );
        assertEquals( 2, cells.get( 5 ).getValue() );
        assertEquals( 0, cells.get( 6 ).getValue() );
        assertEquals( 0, cells.get( 7 ).getValue() );
        assertEquals( 2, cells.get( 8 ).getValue() );
        assertEquals( 4, cells.get( 9 ).getValue() );
        assertEquals( 0, cells.get( 10 ).getValue() );
        assertEquals( 0, cells.get( 11 ).getValue() );
        assertEquals( 32, cells.get( 12 ).getValue() );
        assertEquals( 32, cells.get( 13 ).getValue() );
        assertEquals( 64, cells.get( 14 ).getValue() );
        assertEquals( 0, cells.get( 15 ).getValue() );
    }
}
