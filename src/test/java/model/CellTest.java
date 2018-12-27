package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void shouldAddTwoCellValuesCorrectly(){
        Cell cell1 = new Cell(64);
        Cell cell2 = new Cell(64);
        cell1.addTwoCellValues( cell2 );
        assertEquals( 128, cell1.getValue() );
    }

    @Test
    void shouldMergeWhenTheTwoCellsConsistsOfEqualValues(){
        Cell cell1 = new Cell( 8 );
        Cell cell2 = new Cell( 8 );
        cell1.merge( cell2 );
        assertEquals( 16,cell1.getValue() );
        assertEquals( 0,cell2.getValue() );
    }

    @Test
    void shouldShiftFromOneCellValueToAnotherCellValueWhenShiftMethodIsCalled(){
        Cell cell1 = new Cell( 0 );
        Cell cell2 = new Cell( 8 );
        cell1.shift( cell2 );
        assertEquals( 8,cell1.getValue() );
        assertEquals( 0,cell2.getValue() );
    }

    @Test
    void checkingTwoCellsWhetherTheyCanBeShiftedOrNotForGivenCellOfValue0(){
        Cell cell1 = new Cell(0);
        assertTrue(cell1.checkCellsForShifting());
    }

    @Test
    void checkingTwoCellsWhetherTheyCanBeShiftedOrNotForGivenCellOfValue16(){
        Cell cell1 = new Cell(16);
        assertFalse(cell1.checkCellsForShifting());
    }

    @Test
    void checkingTwoCellsWhetherTheyCanBeMergedOrNotForGivenCellsOfValue8And8(){
        Cell cell1 = new Cell(8);
        Cell cell2 = new Cell(8);
        assertTrue(cell1.checkCellsForMerging(cell2));
    }

    @Test
    void checkingTwoCellsWhetherTheyCanBeShiftedOrNotForGivenCellOfValue16And8(){
        Cell cell1 = new Cell(16);
        Cell cell2 = new Cell(8);
        assertFalse(cell1.checkCellsForMerging(cell2));
    }
}
