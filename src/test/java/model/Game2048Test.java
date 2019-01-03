package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class Game2048Test {
    private NumberGenerator numberGenerator;
    private NumberGenerator numberGenerator1;

    @BeforeEach
    void init() {
        numberGenerator = Mockito.mock(NumberGeneratorWithinARange.class);
        numberGenerator1 = Mockito.mock(NumberGeneratorWithPowerOf2.class);
    }

    @Test
    void checkingWhetherTheRandomNumbersIsCreatedOrNotWhenTheSetupMethodIsCalled() {
        when(numberGenerator.getNumber(15, 0)).thenReturn(5, 9);
        when(numberGenerator1.getNumber(2, 1)).thenReturn(2, 4);
        Game2048 game2048 = new Game2048();
        game2048.gameSetup(numberGenerator, numberGenerator1);
        List<Cell> grid = game2048.getGrid();
        assertEquals(2, grid.get(5).getValue());
        assertEquals(4, grid.get(9).getValue());
    }


    @Test
    void checkingWhetherTheLeftMoverMethodIsGettingCalledOrNot() {
        Game2048 game2048 = new Game2048();
        Mover moverMock = Mockito.mock(LeftMover.class);
        doNothing().when(moverMock).execute(isA(List.class), isA(Integer.class));
        List<Cell> grid = game2048.getGrid();
        game2048.play(moverMock, numberGenerator, numberGenerator1);
        verify(moverMock).execute(grid, 4);
    }

    @Test
    void checkingWhetherTheLeftMoverAndRightMoverMethodsAreGettingCalledOrNot() {
        when(numberGenerator.getNumber(15, 0)).thenReturn(5, 9,6,14);
        when(numberGenerator1.getNumber(2, 1)).thenReturn(2, 4,2,4);
        Game2048 game2048 = new Game2048();
        game2048.gameSetup(numberGenerator,numberGenerator1);
        game2048.play(new LeftMover(),numberGenerator,numberGenerator1);
        game2048.play(new RightMover(),numberGenerator,numberGenerator1);
        game2048.play(new UpMover(),numberGenerator,numberGenerator1);
        List<Cell>  grid = game2048.getGrid();
        assertEquals(8,grid.get(3).getValue());
        assertEquals(4,grid.get(2).getValue());
    }
}
