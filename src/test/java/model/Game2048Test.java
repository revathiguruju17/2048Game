package model;

import controller.Mover;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Game2048Test {

    Mover moverMock = Mockito.mock( Mover.class );

    @Test
    void shouldMoveLeftAndRightWhenKeyIsLeftAndRight() {
        Game2048 game2048 = new Game2048();
        List<Cell> initialGrid = new ArrayList<>();
        game2048.gameSetup();
        List<String> keys = Arrays.asList( "LEFT", "RIGHT", "LEFT" );
        List<Cell> updatedGrid = new ArrayList<>();
        for (String key : keys) {
            updatedGrid = game2048.play( key );
        }
        assertNotEquals( initialGrid, updatedGrid );
    }

}
