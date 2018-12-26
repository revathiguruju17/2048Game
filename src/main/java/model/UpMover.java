package model;

import java.util.List;

public class UpMover implements Mover {

    @Override
    public void execute(List<Cell> grid, int gridSize) {
        int column = 0;
        while (column < gridSize) {
            moveOneColumnUp( grid, gridSize, column );
            column += 1;
        }
    }

    private void moveOneColumnUp(List<Cell> grid, int size, int row) {
        int rowRange = ((size - 1) * size) + row;
        int j = row;
        while (row <= rowRange) {
            int value = grid.get( row ).getValue();
            if (value > 0) {
                for (int i = j; i < row; ) {
                    if (GameRules.check( grid.get( i ), grid.get( row ) )) {
                        break;
                    }
                    j = j + size;
                    i += size;
                }
            }
            row = row + size;
        }
    }
}
