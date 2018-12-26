package model;

import java.util.List;

public class LeftMover implements Mover {

    @Override
    public void execute(List<Cell> grid, int gridSize) {
        int row = 0;
        while (row < gridSize) {
            moveOneRowToLeft( grid, gridSize, row );
            row += 1;
        }
    }

    private void moveOneRowToLeft(List<Cell> grid, int gridSize, int row) {
        int columnSize = (row + 1) * gridSize;
        int column = (row * gridSize);
        int j = row * gridSize;
        while (column < columnSize) {
            int value = grid.get( column ).getValue();
            if (value > 0) {
                for (int k = j; k < column; k++) {
                    if (grid.get( k ).getValue() == value) {
                        grid.get( k ).addTwoCellValues( grid.get( column ) );
                        grid.get( column ).setValue( 0 );
                        j = k + 1;
                        break;
                    } else if (grid.get( k ).getValue() == 0) {
                        grid.get( k ).setValue( value );
                        grid.get( column ).setValue( 0 );
                        break;
                    }
                    else {
                        j= k+1;
                    }
                }
            }
            column += 1;
        }
    }
}
