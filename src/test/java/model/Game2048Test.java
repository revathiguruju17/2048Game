package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Game2048Test {

    @Test
    void shouldInitializeOnlyTwoCellValuesWhenGameSetUpMethodIsCalled() {
        Game2048 game2048 = new Game2048();
        List<Cell> grid = game2048.gameSetup();
        int updatedCells =0;
        for (Cell cell:grid) {
            if(cell.getValue()!=0){
                updatedCells+=1;
            }
        }
        assertEquals(2,updatedCells);
    }
}
