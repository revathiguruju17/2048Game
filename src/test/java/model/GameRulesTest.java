package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRulesTest {

    @Test
    void shouldMergeAndReturnTrueWhenTheTwoCellValuesAreEqual(){
        Cell cell1 = new Cell( 4 );
        Cell cell2 = new Cell( 4 );
        boolean shouldMergeOrShift = GameRules.check( cell1,cell2 );
        assertTrue(shouldMergeOrShift);
        assertEquals(8,cell1.getValue());
        assertEquals( 0,cell2.getValue() );
    }

    @Test
    void shouldNotMergeAndReturnFalseWhenTheTwoCellValuesAreUnEqual(){
        Cell cell1 = new Cell( 4 );
        Cell cell2 = new Cell( 8 );
        boolean shouldMergeOrShift = GameRules.check( cell1,cell2 );
        assertFalse(shouldMergeOrShift);
        assertEquals(4,cell1.getValue());
        assertEquals( 8,cell2.getValue() );
    }

    @Test
    void shouldShiftAndReturnTrueWhenTheFirstCellValueIsZero(){
        Cell cell1 = new Cell( 0 );
        Cell cell2 = new Cell( 4 );
        boolean shouldMergeOrShift = GameRules.check( cell1,cell2 );
        assertTrue(shouldMergeOrShift);
        assertEquals(4,cell1.getValue());
        assertEquals( 0,cell2.getValue() );
    }

    @Test
    void shouldNotShiftAndReturnFalseWhenTheFirstCellValueIsNotZeroAndSecondCellValueIsZero(){
        Cell cell1 = new Cell( 8 );
        Cell cell2 = new Cell( 0 );
        boolean shouldMergeOrShift = GameRules.check( cell1,cell2 );
        assertFalse(shouldMergeOrShift);
        assertEquals(8,cell1.getValue());
        assertEquals( 0,cell2.getValue() );
    }
}
