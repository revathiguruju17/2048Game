package model;

import java.util.List;

public class RightMover implements GridMover {
    @Override
    public void move(List<Cell> cells, int size) {
        int row = size - 1;
        while (row >= 0) {
            moveOneRowToRight( cells, size, row );
            row -= 1;
        }
    }

    private void moveOneRowToRight(List<Cell> cells, int gridSize, int row) {
        int columnSize = (row  * gridSize);
        int column = ((row+1) * gridSize)-1;
        int j = ((row+1) * gridSize)-1;
        while (column >= columnSize) {
            int value = cells.get( column ).getValue();
            if (value > 0) {
                for (int k = j; k > column; k--) {
                    if (cells.get( k ).getValue() == value) {
                        cells.get( k ).addTwoCellValues( cells.get( column ) );
                        cells.get( column ).setValue( 0 );
                        j = k - 1;
                        break;
                    } else if (cells.get( k ).getValue() == 0) {
                        cells.get( k ).setValue( value );
                        cells.get( column ).setValue( 0 );
                        break;
                    }
                }
            }
            column -= 1;
        }
    }
}
