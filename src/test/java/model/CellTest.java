package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CellTest {
    @Test
    void shouldSetTheCellValue() {
        Cell cell = new Cell(3);
        assertEquals( 3, cell.getValue() );
    }

    @Test
    void shouldSetTheCellValueCorrectly() {
        Cell cell = new Cell(3);
        assertNotEquals( 4, cell.getValue() );
    }

    @Test
    void shouldAddTwoCellValuesCorrectly() {
        Cell cell1 = new Cell(64);
        Cell cell2 = new Cell(64);
        cell1.addTwoCellValues( cell2 );
        assertEquals( 128, cell1.getValue() );
    }
}
