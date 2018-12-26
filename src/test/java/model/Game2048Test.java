package model;

import org.junit.jupiter.api.Test;

import java.util.List;

class Game2048Test {

    @Test
    void shouldMoveLeftAndRightWhenKeyIsLeftAndRight() {
        Game2048 game2048 = new Game2048();
        List<Cell> grid = game2048.gameSetup();
    }



}
