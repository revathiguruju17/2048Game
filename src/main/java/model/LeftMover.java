package model;

import java.util.List;

public class LeftMover implements GridMover {

    @Override
    public void move(List<Cell> cells, int gridSize) {
        int row = 0;
        while (row < gridSize) {
            moveOneRowToLeft( cells, gridSize, row );
            row += 1;
        }
    }

    private void moveOneRowToLeft(List<Cell> cells, int gridSize, int row) {
        int columnSize = (row + 1) * gridSize;
        int column = (row * gridSize);
        int j = row * gridSize;
        while (column < columnSize) {
            int value = cells.get( column ).getValue();
            if (value > 0) {
                for (int k = j; k < column; k++) {
                    if (cells.get( k ).getValue() == value) {
                        cells.get( k ).addTwoCellValues( cells.get( column ) );
                        cells.get( column ).setValue( 0 );
                        j = k + 1;
                        break;
                    } else if (cells.get( k ).getValue() == 0) {
                        cells.get( k ).setValue( value );
                        cells.get( column ).setValue( 0 );
                        break;
                    }
                }
            }
            column += 1;
        }
        //System.out.println( cells.get( column - 4 ).getValue() + " " + cells.get( column - 3 ).getValue() + " " +
             //   cells.get( column - 2 ).getValue() + " " + cells.get( column -1).getValue() );
    }
}
