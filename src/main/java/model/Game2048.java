package model;

class Game2048 {
    private final Grid grid;

    Game2048() {
         grid = new Grid();
    }

    void updateGridToLeftPosition() {
        this.grid.moveLeft();
    }
}
