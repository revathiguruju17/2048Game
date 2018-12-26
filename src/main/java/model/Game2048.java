package model;

import controller.Direction;

import java.util.Arrays;
import java.util.List;

public class Game2048 {
    private List<Cell> grid;
    private static final int GRID_SIZE = 4;
    private static final int GAME_MAX_VALUE = 2048;

    public Game2048() {
        grid = Arrays.asList( new Cell( 0 ), new Cell( 0 ), new Cell( 0 ),
                new Cell( 0 ), new Cell( 0 ), new Cell( 0 ), new Cell( 0 ), new Cell( 0 )
                , new Cell( 0 ), new Cell( 0 ), new Cell( 0 ), new Cell( 0 ),
                new Cell( 0 ), new Cell( 0 ), new Cell( 0 ), new Cell( 0 ) );
    }

    public List<Cell> gameSetup() {
        int index1 = NumberGenerator.getRandomNumberWithinARange( 15, 0 );
        int index2 = NumberGenerator.getRandomNumberWithinARange( 15, 0 );
        int value1 = NumberGenerator.getRandomNumberWithinARangeAndPowerOf2( 2, 1 );
        int value2 = NumberGenerator.getRandomNumberWithinARangeAndPowerOf2( 2, 1 );
        grid.get( index1 ).setValue( value1 );
        grid.get( index2 ).setValue( value2 );
        return grid;
    }


    List<Cell> play(String key) {
        Direction.valueOf( key ).move( grid, GRID_SIZE );
        if (checkWhethertheGridConsistsOf2048()) {
            System.out.println( "win" );
        }
        if (!checkWhetherTheGridConsistsOfAnEmptyCell()) {
            System.out.println( "game end" );
        } else {
            createOneCell();
        }
        return grid;
    }

    private Boolean checkWhethertheGridConsistsOf2048() {
        boolean isGridContains2048 = false;
        for (Cell cell : grid) {
            if (cell.getValue() == GAME_MAX_VALUE) {
                isGridContains2048 = true;
            }
        }
        return isGridContains2048;

    }

    private Boolean checkWhetherTheGridConsistsOfAnEmptyCell() {
        boolean isEmpty = false;
        for (Cell cell : grid) {
            if (cell.getValue() == 0) {
                isEmpty = true;
            }
        }
        return isEmpty;
    }

    private void createOneCell() {
        int value;
        do {
            int index = NumberGenerator.getRandomNumberWithinARange( 15, 0 );
            value = grid.get( index ).getValue();
            if (value == 0) {
                grid.get( index ).setValue( NumberGenerator.
                        getRandomNumberWithinARangeAndPowerOf2( 2, 1 ) );
            }
        } while (value != 0);
    }

}
