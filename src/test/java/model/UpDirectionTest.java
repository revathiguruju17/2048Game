package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpDirectionTest {

    @Test
    void shouldMoveUpCorrectlyForGivenValuesIn2By2Grid() {
        List<Cell> grid = Arrays.asList( new Cell(), new Cell(), new Cell(), new Cell() );
        grid.get( 0 ).setValue( 16 );
        grid.get( 1 ).setValue( 2 );
        grid.get( 2 ).setValue( 8 );
        grid.get( 3 ).setValue( 2 );
        UpMover upMover = new UpMover();
        upMover.move( grid, 2 );
        assertEquals( 16, grid.get( 0 ).getValue() );
        assertEquals( 4, grid.get( 1 ).getValue() );
        assertEquals( 8, grid.get( 2 ).getValue() );
        assertEquals( 0, grid.get( 3 ).getValue() );
    }

    @Test
    void shouldMoveUpCorrectlyForGivenValuesIn3By3Grid() {
        List<Cell> grid = Arrays.asList( new Cell(), new Cell(), new Cell(), new Cell(),
                new Cell(), new Cell(), new Cell(), new Cell(), new Cell() );
        grid.get( 0 ).setValue( 4 );
        grid.get( 1 ).setValue( 8 );
        grid.get( 2 ).setValue( 32 );
        grid.get( 3 ).setValue( 2 );
        grid.get( 4 ).setValue( 64 );
        grid.get( 5 ).setValue( 32 );
        grid.get( 6 ).setValue( 2 );
        grid.get( 7 ).setValue( 16 );
        grid.get( 8 ).setValue( 16 );
        UpMover upMover = new UpMover();
        upMover.move( grid, 3 );
        assertEquals( 4, grid.get( 0 ).getValue() );
        assertEquals( 8, grid.get( 1 ).getValue() );
        assertEquals( 64, grid.get( 2 ).getValue() );
        assertEquals( 4, grid.get( 3 ).getValue() );
        assertEquals( 64, grid.get( 4 ).getValue() );
        assertEquals( 16, grid.get( 5 ).getValue() );
        assertEquals( 0, grid.get( 6 ).getValue() );
        assertEquals( 16, grid.get( 7 ).getValue() );
        assertEquals( 0, grid.get( 8 ).getValue() );
    }

    @Test
    void shouldMoveUpCorrectlyForTheGivenValuesIn4By4Grid() {
        List<Cell> grid = Arrays.asList( new Cell(), new Cell(), new Cell(), new Cell(), new Cell(),
                new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(),
                new Cell(), new Cell(), new Cell(), new Cell() );
        grid.get( 0 ).setValue( 2 );
        grid.get( 1 ).setValue( 8 );
        grid.get( 2 ).setValue( 2 );
        grid.get( 3 ).setValue( 16 );
        grid.get( 4 ).setValue( 2 );
        grid.get( 6 ).setValue( 4 );
        grid.get( 8 ).setValue( 4 );
        grid.get( 9 ).setValue( 4 );
        grid.get( 10 ).setValue( 2 );
        grid.get( 11 ).setValue( 4 );
        grid.get( 12 ).setValue( 4 );
        grid.get( 13 ).setValue( 4 );
        grid.get( 14 ).setValue( 2 );
        grid.get( 15 ).setValue( 16 );
        UpMover upMover = new UpMover();
        upMover.move( grid, 4 );
        assertEquals( 4, grid.get( 0 ).getValue() );
        assertEquals( 8, grid.get( 1 ).getValue() );
        assertEquals( 2, grid.get( 2 ).getValue() );
        assertEquals( 16, grid.get( 3 ).getValue() );
        assertEquals( 8, grid.get( 4 ).getValue() );
        assertEquals( 8, grid.get( 5 ).getValue() );
        assertEquals( 4, grid.get( 6 ).getValue() );
        assertEquals( 4, grid.get( 7 ).getValue() );
        assertEquals( 0, grid.get( 8 ).getValue() );
        assertEquals( 0, grid.get( 9 ).getValue() );
        assertEquals( 4, grid.get( 10 ).getValue() );
        assertEquals( 16, grid.get( 11 ).getValue() );
        assertEquals( 0, grid.get( 12 ).getValue() );
        assertEquals( 0, grid.get( 13 ).getValue() );
        assertEquals( 0, grid.get( 14 ).getValue() );
        assertEquals( 0, grid.get( 15 ).getValue() );
    }
}
