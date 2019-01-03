package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameRulesTest {

    @Test
    void shouldMergeAndReturnTrueWhenTheTwoCellValuesAreEqual(){
        Cell cell1 = new Cell( 4 );
        Cell cell2 = new Cell( 4 );
        boolean shouldMerge = GameRules.shouldMerge( cell1,cell2 );
        assertTrue(shouldMerge);
    }

    @Test
    void shouldNotMergeAndReturnFalseWhenTheTwoCellValuesAreUnEqual(){
        Cell cell1 = new Cell( 4 );
        Cell cell2 = new Cell( 8 );
        boolean shouldMerge = GameRules.shouldMerge( cell1,cell2 );
        assertFalse(shouldMerge);
    }

    @Test
    void shouldShiftAndReturnTrueWhenTheFirstCellValueIsZero(){
        Cell cell1 = new Cell( 0 );
        boolean shouldShift = GameRules.shouldShift( cell1 );
        assertTrue(shouldShift);
    }

    @Test
    void shouldNotShiftAndReturnFalseWhenTheFirstCellValueIsNotZeroAndSecondCellValueIsZero(){
        Cell cell1 = new Cell( 8 );
        boolean shouldShift = GameRules.shouldShift( cell1 );
        assertFalse(shouldShift);
    }

    @Test
    void shouldReturnTrueIfTheGridContains2048(){
        List<Cell> grid = Arrays.asList(new Cell(0),new Cell(2048), new Cell(8), new Cell(16));
        assertTrue(GameRules.checkWhetherTheGridContains2048(grid));
    }

    @Test
    void shouldReturnFalseIfTheGridDoesNotContains2048(){
        List<Cell> grid = Arrays.asList(new Cell(0),new Cell(48), new Cell(8), new Cell(16));
        assertFalse(GameRules.checkWhetherTheGridContains2048(grid));
    }

    @Test
    void shouldReturnTrueIfTheGridConsistsOfAnEmptyCell(){
        List<Cell> grid = Arrays.asList(new Cell(8),new Cell(2048), new Cell(8), new Cell(0));
        assertTrue(GameRules.checkWhetherTheGridConsistsOfAnEmptyCell(grid,2));
    }

    @Test
    void shouldReturnFalseIfTheGridIsFull(){
        List<Cell> grid = Arrays.asList(new Cell(8),new Cell(48), new Cell(4), new Cell(16));
        assertFalse(GameRules.checkWhetherTheGridConsistsOfAnEmptyCell(grid,2));
    }

    @Test
    void shouldReturnTrueIfTheGridIsFullButGridContainsSimilarValues(){
        List<Cell> grid = Arrays.asList(new Cell(8),new Cell(48), new Cell(8), new Cell(8));
        assertTrue(GameRules.checkWhetherTheGridConsistsOfAnEmptyCell(grid,2));
    }
}
