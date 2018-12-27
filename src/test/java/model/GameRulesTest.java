package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRulesTest {

    @Test
    void shouldMergeAndReturnTrueWhenTheTwoCellValuesAreEqual(){
        Cell cell1 = new Cell( 4 );
        Cell cell2 = new Cell( 4 );
        boolean shouldMerge = GameRules.isShouldMerge( cell1,cell2 );
        assertTrue(shouldMerge);
        assertEquals(8,cell1.getValue());
        assertEquals( 0,cell2.getValue() );
    }

    @Test
    void shouldNotMergeAndReturnFalseWhenTheTwoCellValuesAreUnEqual(){
        Cell cell1 = new Cell( 4 );
        Cell cell2 = new Cell( 8 );
        boolean shouldMerge = GameRules.isShouldMerge( cell1,cell2 );
        assertFalse(shouldMerge);
        assertEquals(4,cell1.getValue());
        assertEquals( 8,cell2.getValue() );
    }

    @Test
    void shouldShiftAndReturnTrueWhenTheFirstCellValueIsZero(){
        Cell cell1 = new Cell( 0 );
        Cell cell2 = new Cell( 4 );
        boolean shouldShift = GameRules.isShouldShift( cell1 );
        assertTrue(shouldShift);
        assertEquals(4,cell1.getValue());
        assertEquals( 0,cell2.getValue() );
    }

    @Test
    void shouldNotShiftAndReturnFalseWhenTheFirstCellValueIsNotZeroAndSecondCellValueIsZero(){
        Cell cell1 = new Cell( 8 );
        Cell cell2 = new Cell( 0 );
        boolean shouldShift = GameRules.isShouldShift( cell1 );
        assertFalse(shouldShift);
        assertEquals(8,cell1.getValue());
        assertEquals( 0,cell2.getValue() );
    }
}
