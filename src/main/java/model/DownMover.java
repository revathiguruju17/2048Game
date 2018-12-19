package model;

import java.util.List;

public class DownMover implements GridMover {

    @Override
    public void move(List<Cell> grid, int gridSize) {
        int column = 0;
        while (column < gridSize) {
            moveOneColumnDown( grid, gridSize, column );
            column += 1;
        }
    }

    private void moveOneColumnDown(List<Cell> grid, int gridSize, int column) {
        int rowRange = ((gridSize - 1) * gridSize) + column;
        int row = (column * gridSize) + column;
        int j = row;
        while (row < rowRange) {
            row = (row * gridSize) + column;
            int value = grid.get( row ).getValue();
            if (value > 0) {
                for (int i = j; i < rowRange; i++) {
                    if (grid.get( i ).getValue() == value) {
                        grid.get( i ).addTwoCellValues( grid.get( row ) );
                        grid.get( column ).setValue( 0 );
                        j = (row * gridSize) + column;
                        break;
                    } else if (grid.get( i ).getValue() == 0) {
                        grid.get( i ).setValue( value );
                        grid.get( column ).setValue( 0 );
                        break;
                    }
                }
            }
            row += 1;
        }
    }
}
