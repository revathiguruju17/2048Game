package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Game2048Test {

    @Test
    void shouldMoveLeftWhenKeyIs1() {
        Game2048 game2048 = new Game2048();
        List<Cell> grid = game2048.gameSetup();
        List<Integer> keys = Arrays.asList( 1,2,1 );
        for (int key : keys) {
            grid = game2048.play( key );
        }
    }

}
