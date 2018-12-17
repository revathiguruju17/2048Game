package model;

import org.junit.jupiter.api.Test;

class Game2048Test {
    @Test
    void updateGridToLeftPosition(){
        Game2048 game2048 = new Game2048();
        game2048.updateGridToLeftPosition();
    }
}
