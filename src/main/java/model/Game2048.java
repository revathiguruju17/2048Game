package model;


import java.util.Arrays;
import java.util.List;

public class Game2048 {

    private static final int GRID_SIZE = 4;
    private List<Cell> grid = Arrays.asList( new Cell(), new Cell(), new Cell(), new Cell(), new Cell(),
            new Cell(), new Cell(), new Cell(), new Cell() );

    public void gameSetup() {
        int index1 = NumberGenerator.getRandomNumberWithinARange( 15, 0 );
        int index2 = NumberGenerator.getRandomNumberWithinARange( 15, 0 );
        int value1 = NumberGenerator.getRandomNumberWithinARangeAndPowerOf2( 2, 1 );
        int value2 = NumberGenerator.getRandomNumberWithinARangeAndPowerOf2( 2, 1 );
        grid.get( index1 ).setValue( value1 );
        grid.get( index2 ).setValue( value2 );
    }

    public List<Cell> moveLeft() {
        LeftMover leftMover = new LeftMover();
        leftMover.move( grid, GRID_SIZE );
        return grid;
    }

    public List<Cell> moveRight() {
        RightMover rightMover = new RightMover();
        rightMover.move( grid, GRID_SIZE );
        return grid;
    }

    public List<Cell> moveUp() {
        return grid;
    }

    public List<Cell> moveDown() {
        return grid;
    }
}
