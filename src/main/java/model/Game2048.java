package model;

import java.util.Arrays;
import java.util.List;

public class Game2048 {

    private static final int GRID_SIZE = 4;
    private List<Cell> grid = Arrays.asList( new Cell(), new Cell(), new Cell(), new Cell(),
            new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(),
            new Cell(), new Cell(), new Cell(), new Cell(), new Cell() );

    public List<Cell> gameSetup() {
        int index1 = NumberGenerator.getRandomNumberWithinARange( 15, 0 );
        int index2 = NumberGenerator.getRandomNumberWithinARange( 15, 0 );
        int value1 = NumberGenerator.getRandomNumberWithinARangeAndPowerOf2( 2, 1 );
        int value2 = NumberGenerator.getRandomNumberWithinARangeAndPowerOf2( 2, 1 );
        grid.get( index1 ).setValue( value1 );
        grid.get( index2 ).setValue( value2 );
        return grid;
    }


    List<Cell> play(int key) {
        Mover.values()[key - 1].move( grid, GRID_SIZE );
        int value;
        do{
           int index = NumberGenerator.getRandomNumberWithinARange( 15,0 );
           value = grid.get( index ).getValue();
           if(value==0){
               grid.get( index ).setValue( NumberGenerator.getRandomNumberWithinARangeAndPowerOf2( 2,1 ) );
           }
        }while (value!=0);
        return grid;
    }

}
