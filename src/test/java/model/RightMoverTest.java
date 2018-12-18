package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RightMoverTest {
    @Test
    void shouldMoveLeftSideCorrectlyForTheGivenSetOfValuesIn3By3Grid() {
        List<Cell> cells = Arrays.asList( new Cell(), new Cell(), new Cell(), new Cell(), new Cell(),
                new Cell(), new Cell(), new Cell(), new Cell() );
        cells.get( 0 ).setValue( 2 );
        cells.get( 1 ).setValue( 2 );
        cells.get( 3 ).setValue( 4 );
        cells.get( 4 ).setValue( 2 );
        cells.get( 6 ).setValue( 16 );
        cells.get( 7 ).setValue( 8 );
        cells.get( 8 ).setValue( 8 );
        RightMover rightMover = new RightMover();
        rightMover.move( cells, 3 );
        assertEquals( 0, cells.get( 0 ).getValue() );
        assertEquals( 0, cells.get( 1 ).getValue() );
        assertEquals( 4, cells.get( 2 ).getValue() );
        assertEquals( 0, cells.get( 3 ).getValue() );
        assertEquals( 4, cells.get( 4 ).getValue() );
        assertEquals( 2, cells.get( 5 ).getValue() );
        assertEquals( 0, cells.get( 6 ).getValue() );
        assertEquals( 16, cells.get( 7 ).getValue() );
        assertEquals( 16, cells.get( 8 ).getValue() );
    }
}
