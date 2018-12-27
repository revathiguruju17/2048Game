package model;

import Factory.MoverFactory;

import java.util.Arrays;
import java.util.List;

public class Game2048 {
    private List<Cell> grid;
    private static final int GRID_SIZE = 4;
    private static final int GAME_MAX_VALUE = 2048;

    public Game2048() {
        grid = Arrays.asList( new Cell( 0 ), new Cell( 0 ), new Cell( 0 ), new Cell( 0 )
                , new Cell( 0 ), new Cell( 0 ), new Cell( 0 ), new Cell( 0 )
                , new Cell( 0 ), new Cell( 0 ), new Cell( 0 ), new Cell( 0 ),
                new Cell( 0 ), new Cell( 0 ), new Cell( 0 ), new Cell( 0 ) );
    }

    public void gameSetup() {
        int index1 = NumberGenerator.getRandomNumberWithinARange( 15, 0 );
        int index2 = NumberGenerator.getRandomNumberWithinARange( 15, 0 );
        int value1 = NumberGenerator.getRandomNumberWithinARangeAndPowerOf2( 2, 1 );
        int value2 = NumberGenerator.getRandomNumberWithinARangeAndPowerOf2( 2, 1 );
        grid.get( index1 ).setValue( value1 );
        grid.get( index2 ).setValue( value2 );
    }

    public void play(String key) {
        Mover mover = MoverFactory.getMover( key );
        mover.execute( grid, GRID_SIZE );
        if (checkWhetherTheGridContains2048()) {
            System.out.println( "win" );
        }
        if (!checkWhetherTheGridConsistsOfAnEmptyCell()) {
            System.out.println( "game end" );
        } else {
            createOneCell();
        }
    }

    private Boolean checkWhetherTheGridContains2048() {
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

    public List<Cell> getGrid() {
        return grid;
    }
}
