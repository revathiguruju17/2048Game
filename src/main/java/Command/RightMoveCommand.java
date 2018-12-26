package Command;

import model.Cell;

import java.util.List;

public class RightMoveCommand implements Command {
    @Override
    public void move(List<Cell> grid, int size) {
        int row = size - 1;
        while (row >= 0) {
            moveOneRowToRight( grid, size, row );
            row -= 1;
        }
    }

    private void moveOneRowToRight(List<Cell> grid, int gridSize, int row) {
        int columnSize = (row  * gridSize);
        int column = ((row+1) * gridSize)-1;
        int j = ((row+1) * gridSize)-1;
        while (column >= columnSize) {
            int value = grid.get( column ).getValue();
            if (value > 0) {
                for (int k = j; k > column; k--) {
                    if (grid.get( k ).getValue() == value) {
                        grid.get( k ).addTwoCellValues( grid.get( column ) );
                        grid.get( column ).setValue( 0 );
                        j = k - 1;
                        break;
                    } else if (grid.get( k ).getValue() == 0) {
                        grid.get( k ).setValue( value );
                        grid.get( column ).setValue( 0 );
                        break;
                    }
                    else{
                        j=k-1;
                    }
                }
            }
            column -= 1;
        }
    }
}
