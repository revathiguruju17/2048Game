package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
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
    void checkingWhetherTheLeftMoverMethodIsGettingCalledOrNot(){
        Game2048 game2048 = new Game2048();
        Mover mover = Mockito.mock(LeftMover.class);
        doNothing().when(mover).execute(isA(List.class),isA(Integer.class));
        game2048.play(mover,numberGenerator,numberGenerator1);
        mover.execute(null,0);
        verify(mover,times(1)).execute(null,0);
    }

}
