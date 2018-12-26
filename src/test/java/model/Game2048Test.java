package model;

import controller.Direction;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

class Game2048Test {

    @Mock
    private Direction directionMock;
    private List<String> mockList;

    @Test
    void shouldMoveLeftAndRightWhenKeyIsLeftAndRight() {
        Game2048 game2048 = new Game2048();
        game2048.gameSetup();
        List<String> keys = Arrays.asList( "LEFT", "RIGHT", "LEFT" );
        for (String key : keys) {
            List<Cell> updatedGrid = game2048.play( key );
        }
    }

}
