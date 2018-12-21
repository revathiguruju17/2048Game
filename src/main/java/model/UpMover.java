package model;

import java.util.List;

public class UpMover implements GridMover {

    @Override
    public void move(List<Cell> grid, int gridSize) {
        int column = 0;
        while (column < gridSize) {
            moveOneColumnUp( grid, gridSize, column );
            column += 1;
        }
    }

    private void moveOneColumnUp(List<Cell> grid, int gridSize, int row) {
        int rowRange = ((gridSize - 1) * gridSize) + row;
        int j = row;
        while (row <= rowRange) {
            int value = grid.get( row ).getValue();
            if (value > 0) {
                for (int i = j; i < row; ) {
                    if (grid.get( i ).getValue() == value) {
                        grid.get( i ).addTwoCellValues( grid.get( row ) );
                        grid.get( row ).setValue( 0 );
                        j = j + gridSize;
                        break;
                    } else if (grid.get( i ).getValue() == 0) {
                        grid.get( i ).setValue( value );
                        grid.get( row ).setValue( 0 );
                        break;
                    }
                    i += gridSize;
                }
            }
            row = row + gridSize;
        }
    }
}
