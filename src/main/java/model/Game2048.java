package model;

import controller.Direction;

import java.util.Arrays;
import java.util.List;

public class Game2048 {

    private static final int GRID_SIZE = 4;
    private List<Cell> grid;

    public void gameSetup() {
        grid = Arrays.asList( new Cell(0), new Cell(0), new Cell(0), new Cell(0),
                new Cell(0), new Cell(0), new Cell(0), new Cell(0), new Cell(0), new Cell(0),
                new Cell(0), new Cell(0), new Cell(0), new Cell(0), new Cell(0), new Cell(0) );
        int index1 = NumberGenerator.getRandomNumberWithinARange( 15, 0 );
        int index2 = NumberGenerator.getRandomNumberWithinARange( 15, 0 );
        int value1 = NumberGenerator.getRandomNumberWithinARangeAndPowerOf2( 2, 1 );
        int value2 = NumberGenerator.getRandomNumberWithinARangeAndPowerOf2( 2, 1 );
        grid.get( index1 ).setValue( value1 );
        grid.get( index2 ).setValue( value2 );
    }


    List<Cell> play(String key) {
        Direction.valueOf( key ).move( grid, GRID_SIZE );
        int value;
        do {
            int index = NumberGenerator.getRandomNumberWithinARange( 15, 0 );
            value = grid.get( index ).getValue();
            if (value == 0) {
                grid.get( index ).setValue( NumberGenerator.getRandomNumberWithinARangeAndPowerOf2( 2, 1 ) );
            }
        } while (value != 0);
        return grid;
    }

}
