package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpMoverTest {

    @Test
    void shouldMoveUpCorrectlyFor2By2Grid() {
        List<Cell> grid = Arrays.asList( new Cell(), new Cell(), new Cell(), new Cell() );
        grid.get( 0 ).setValue( 16 );
        grid.get( 1 ).setValue( 2 );
        grid.get( 2 ).setValue( 8 );
        grid.get( 3 ).setValue( 2 );
        UpMover upMover = new UpMover();
        upMover.move( grid, 2 );
        for (Cell cell:grid) {
            System.out.print(cell.getValue()+" ");
        }
        assertEquals( 16, grid.get( 0 ).getValue() );
        assertEquals( 4, grid.get( 1 ).getValue() );
        assertEquals( 8, grid.get( 2 ).getValue() );
        assertEquals( 0, grid.get( 3 ).getValue() );
    }

    @Test
    void shouldMoveUpCorrectlyFor3By3Grid() {
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
}
