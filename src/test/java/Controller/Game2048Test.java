package Controller;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class Game2048Test {
    private NumberGenerator numberGeneratorMock;
    private Game2048 game2048;

    @BeforeEach
    void init() {
        numberGeneratorMock = Mockito.mock(NumberGenerator.class);
        game2048 = new Game2048(4,2,2);
    }

    @Test
    void checkingWhetherTheRandomNumbersIsCreatedOrNotWhenTheSetupMethodIsCalled() {
        when(numberGeneratorMock.getNumberWithinARange(15, 0)).thenReturn(5, 9);
        when(numberGeneratorMock.getNumberWithinASpecifiedRangeAndCalculatePower(2, 1,2)).thenReturn(2, 4);
        game2048.gameSetup(numberGeneratorMock);
        List<Cell> grid = game2048.getGrid();
        assertEquals(2, grid.get(5).getValue());
        assertEquals(4, grid.get(9).getValue());
    }


    @Test
    void checkingWhetherTheLeftMoverMethodIsGettingCalledOrNot() {
        Mover leftMoverMock = Mockito.mock(LeftMover.class);
        doNothing().when(leftMoverMock).execute(isA(List.class), isA(Integer.class));
        List<Cell> grid = game2048.getGrid();
        game2048.play(leftMoverMock, numberGeneratorMock);
        verify(leftMoverMock,times(1)).execute(grid, 4);
    }

    @Test
    void checkingWhetherTheRightMoverMethodIsGettingCalledOrNot(){
        Mover rightMoverMock = Mockito.mock(RightMover.class);
        doNothing().when(rightMoverMock).execute(isA(List.class), isA(Integer.class));
        List<Cell> grid = game2048.getGrid();
        game2048.play(rightMoverMock, numberGeneratorMock);
        verify(rightMoverMock,times(1)).execute(grid, 4);
    }

    @Test
    void checkingWhetherTheDownMoverMethodIsGettingCalledOrNot(){
        Mover downMover = Mockito.mock(UpMover.class);
        doNothing().when(downMover).execute(isA(List.class), isA(Integer.class));
        List<Cell> grid = game2048.getGrid();
        game2048.play(downMover, numberGeneratorMock);
        verify(downMover,times(1)).execute(grid, 4);
    }

    @Test
    void checkingWhetherTheUpMoverMethodIsGettingCalledOrNot(){
        Mover upMoverMock = Mockito.mock(UpMover.class);
        doNothing().when(upMoverMock).execute(isA(List.class), isA(Integer.class));
        List<Cell> grid = game2048.getGrid();
        game2048.play(upMoverMock, numberGeneratorMock);
        verify(upMoverMock,times(1)).execute(grid, 4);
    }

    @Test
    void checkingWhetherAllTheMoverMethodsAreGettingCalledOrNotForTheGivenSetOfValues() {
        when(numberGeneratorMock.getNumberWithinARange(15, 0)).thenReturn(5, 9, 6, 14);
        when(numberGeneratorMock.getNumberWithinASpecifiedRangeAndCalculatePower(2, 1,2)).thenReturn(2, 4, 2, 4);
        game2048.gameSetup(numberGeneratorMock);
        game2048.play(new LeftMover(), numberGeneratorMock);
        game2048.play(new RightMover(), numberGeneratorMock);
        game2048.play(new UpMover(), numberGeneratorMock);
        List<Cell> grid = game2048.getGrid();
        assertEquals(8, grid.get(3).getValue());
        assertEquals(4, grid.get(2).getValue());
    }


    @Test
    void shouldReturnGameStateAsWinIfTheGridContains2048() {
        when(numberGeneratorMock.getNumberWithinARange(15, 0)).thenReturn(5, 9, 6);
        when(numberGeneratorMock.getNumberWithinASpecifiedRangeAndCalculatePower(2, 1,2)).thenReturn(2, 2048, 4);
        game2048.gameSetup(numberGeneratorMock);
        GameState result = game2048.play(new LeftMover(), numberGeneratorMock);
        assertEquals(GameState.WIN, result);
    }

    @Test
    void shouldReturnGameStateAsContinueIfTheGridContainsAnEmptyCellAndDoesNotHave2048() {
        when(numberGeneratorMock.getNumberWithinARange(15, 0)).thenReturn(5, 9, 6);
        when(numberGeneratorMock.getNumberWithinASpecifiedRangeAndCalculatePower(2, 1,2)).thenReturn(2, 2, 4);
        game2048.gameSetup(numberGeneratorMock);
        GameState result = game2048.play(new LeftMover(), numberGeneratorMock);
        assertEquals(GameState.CONTINUE, result);
    }
}
