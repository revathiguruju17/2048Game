package model;

import Factory.MoverFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static Factory.MoverFactory.getMover;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class Game2048Test {

    @Test
    void checkingWhetherTheRandomNumberIsCreatedOrNotWhenTheSetupMethodIsCalled() {
        NumberGenerator numberGenerator = Mockito.mock(NumberGeneratorWithinARange.class);
        NumberGenerator numberGenerator1 = Mockito.mock(NumberGeneratorWithPowerOf2.class);
        when(numberGenerator.getNumber(15, 0)).thenReturn(5, 9);
        when(numberGenerator1.getNumber(2, 1)).thenReturn(2, 4);
        Game2048 game2048 = new Game2048();
        game2048.gameSetup(numberGenerator, numberGenerator1);
        List<Cell> grid = game2048.getGrid();
        assertEquals(2, grid.get(5).getValue());
        assertEquals(4, grid.get(9).getValue());
    }

    @Test
    void checkingWhetherTheMoverFactoryMethodIsGettingCalledOrNot() {
        MoverFactory moverFactoryMock = Mockito.mock(MoverFactory.class);
        Game2048 game2048 = new Game2048();
        game2048.play(37);
        verify(moverFactoryMock);
        getMover(37);
    }

    @Test
    void shouldInitializeOnlyTwoCellValuesWhenGameSetUpMethodIsCalled() {
        Game2048 game2048 = new Game2048();
        NumberGenerator numberGenerator = new NumberGeneratorWithinARange();
        NumberGenerator numberGenerator1 = new NumberGeneratorWithPowerOf2();
        game2048.gameSetup(numberGenerator, numberGenerator1);
        List<Cell> grid = game2048.getGrid();
        int updatedCells = 0;
        for (Cell cell : grid) {
            if (cell.getValue() != 0) {
                updatedCells += 1;
            }
        }
        assertEquals(2, updatedCells);
    }
}
