package Command;

import model.Cell;

import java.util.List;

public class DownMoveCommand implements Command {

    @Override
    public void move(List<Cell> grid, int size) {
        int column = 0;
        while (column < size) {
            moveOneColumnDown( grid, size, column );
            column += 1;
        }
    }

    private void moveOneColumnDown(List<Cell> grid, int size, int range) {
        int row = ((size - 1) * size) + range;
        int j = row;
        while (row >= range) {
            int value = grid.get( row ).getValue();
            if (value > 0) {
                for (int i = j; i > row; ) {
                    if (grid.get( i ).getValue() == value) {
                        grid.get( i ).addTwoCellValues( grid.get( row ) );
                        grid.get( row ).setValue( 0 );
                        j = j - size;
                        break;
                    } else if (grid.get( i ).getValue() == 0) {
                        grid.get( i ).setValue( value );
                        grid.get( row ).setValue( 0 );
                        break;
                    } else {
                        j = j - size;
                    }
                    i -= size;
                }
            }
            row = row - size;
        }
    }
}
