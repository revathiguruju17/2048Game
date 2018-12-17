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
    }

    void updateCellValue(int value, int indexOfCell) {
        cells.get( indexOfCell ).setValue( value );
    }

    Cell getCell(int index) {
        return cells.get( index );
    }
}
