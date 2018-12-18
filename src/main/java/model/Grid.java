package model;

import java.util.ArrayList;
import java.util.List;

class Grid {
    private static final int NUMBER_OF_CELLS_IN_THE_GRID = 16;
    private List<Cell> cells;

    Grid() {
        this.cells = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_CELLS_IN_THE_GRID; i++) {
            this.cells.add( new Cell() );
        }
        setTwoCellsWithAValue();
    }

    private void setTwoCellsWithAValue() {
        int index1 = NumberGenerator.getRandomNumberWithinARange( 0, 15 );
        int index2 = NumberGenerator.getRandomNumberWithinARange( 0, 15 );
        int value1 = NumberGenerator.getRandomNumberWithinARangeAndPowerOf2( 3, 1 );
        int value2 = NumberGenerator.getRandomNumberWithinARangeAndPowerOf2( 3, 1 );
        updateCellValue( value1, index1 );
        updateCellValue( value2, index2 );
    }

    void updateCellValue(int value, int indexOfCell) {
        cells.get( indexOfCell ).setValue( value );
    }

    Cell getCell(int index) {
        return cells.get( index );
    }

    void moveLeft() {
        LeftMover leftMover = new LeftMover();
        leftMover.move( cells,4 );
    }
}
