package model;

import Factory.MoverFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static Factory.MoverFactory.getMover;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class Game2048Test {

    @Test
    void checkingWhetherTheMoverFactoryMethodIsGettingCalledOrNot() {
        MoverFactory moverFactoryMock = Mockito.mock(MoverFactory.class);
        Game2048 game2048 = new Game2048();
        game2048.play("left");
        verify(moverFactoryMock);
        getMover("left");
    }

    @Test
    void checkingWhetherExecuteMethodInLeftMoverIsGettingCalledOrNotWhenTheKeyIsLeft() {
        LeftMover leftMover = Mockito.mock(LeftMover.class);
        Game2048 game2048 = new Game2048();
        game2048.play("left");
        verify(leftMover).execute(null, 0);
    }

    @Test
    void shouldInitializeOnlyTwoCellValuesWhenGameSetUpMethodIsCalled() {
        Game2048 game2048 = new Game2048();
        game2048.gameSetup();
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
