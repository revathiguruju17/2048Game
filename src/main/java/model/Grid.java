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
        int index1 = NumberGenerator.getRandomNumber( 0, 15 );
        int index2 = NumberGenerator.getRandomNumber( 0, 15 );
        int value1 = NumberGenerator.getRandomNumber( 1, 2 );
        value1 *= 2;
        int value2 = NumberGenerator.getRandomNumber( 1, 2 );
        value2 *= 2;
        updateCellValue( value1, index1 );
        updateCellValue( value2, index2 );
    }

    void updateCellValue(int value, int indexOfCell) {
        cells.get( indexOfCell ).setValue( value );
    }

    Cell getCell(int index) {
        return cells.get( index );
    }

    void updateLeft() {

    }
}
