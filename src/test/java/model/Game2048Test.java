package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class Game2048Test {
    private NumberGenerator numberGeneratorMock;
    private NumberGenerator numberGenerator1Mock;
    private Game2048 game2048;

    @BeforeEach
    void init() {
        numberGeneratorMock = Mockito.mock(NumberGeneratorWithinARange.class);
        numberGenerator1Mock = Mockito.mock(NumberGeneratorWithPowerOf2.class);
        game2048 = new Game2048();
    }

    @Test
    void checkingWhetherTheRandomNumbersIsCreatedOrNotWhenTheSetupMethodIsCalled() {
        when(numberGeneratorMock.getNumber(15, 0)).thenReturn(5, 9);
        when(numberGenerator1Mock.getNumber(2, 1)).thenReturn(2, 4);
        game2048.gameSetup(numberGeneratorMock, numberGenerator1Mock);
        List<Cell> grid = game2048.getGrid();
        assertEquals(2, grid.get(5).getValue());
        assertEquals(4, grid.get(9).getValue());
    }


    @Test
    void checkingWhetherTheLeftMoverMethodIsGettingCalledOrNot() {
        Mover moverMock = Mockito.mock(LeftMover.class);
        doNothing().when(moverMock).execute(isA(List.class), isA(Integer.class));
        List<Cell> grid = game2048.getGrid();
        game2048.play(moverMock, numberGeneratorMock, numberGenerator1Mock);
        verify(moverMock).execute(grid, 4);
    }

    @Test
    void checkingWhetherAllTheMoverMethodsAreGettingCalledOrNotForTheGivenSetOfValues() {
        when(numberGeneratorMock.getNumber(15, 0)).thenReturn(5, 9, 6, 14);
        when(numberGenerator1Mock.getNumber(2, 1)).thenReturn(2, 4, 2, 4);
        game2048.gameSetup(numberGeneratorMock, numberGenerator1Mock);
        game2048.play(new LeftMover(), numberGeneratorMock, numberGenerator1Mock);
        game2048.play(new RightMover(), numberGeneratorMock, numberGenerator1Mock);
        game2048.play(new UpMover(), numberGeneratorMock, numberGenerator1Mock);
        List<Cell> grid = game2048.getGrid();
        assertEquals(8, grid.get(3).getValue());
        assertEquals(4, grid.get(2).getValue());
    }

    @Test
    void shouldReturnGameStateAsWinIfTheGridContains2048() {
        when(numberGeneratorMock.getNumber(15, 0)).thenReturn(5, 9, 6);
        when(numberGenerator1Mock.getNumber(2, 1)).thenReturn(2, 2048, 4);
        game2048.gameSetup(numberGeneratorMock, numberGenerator1Mock);
        GameState result = game2048.play(new LeftMover(), numberGeneratorMock, numberGenerator1Mock);
        assertEquals(GameState.WIN, result);
    }

    @Test
    void shouldReturnGameStateAsContinueIfTheGridContainsAnEmptyCellAndDoesNotHave2048() {
        when(numberGeneratorMock.getNumber(15, 0)).thenReturn(5, 9, 6);
        when(numberGenerator1Mock.getNumber(2, 1)).thenReturn(2, 2, 4);
        game2048.gameSetup(numberGeneratorMock, numberGenerator1Mock);
        GameState result = game2048.play(new LeftMover(), numberGeneratorMock, numberGenerator1Mock);
        assertEquals(GameState.CONTINUE, result);
    }
}
