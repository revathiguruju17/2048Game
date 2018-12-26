package model;

import java.util.List;

public class RightMover implements Mover {
    @Override
    public void execute(List<Cell> grid, int size) {
        int row = size - 1;
        while (row >= 0) {
            moveOneRowToRight( grid, size, row );
            row -= 1;
        }
    }

    private void moveOneRowToRight(List<Cell> grid, int gridSize, int row) {
        int columnSize = (row * gridSize);
        int column = ((row + 1) * gridSize) - 1;
        int j = ((row + 1) * gridSize) - 1;
        while (column >= columnSize) {
            int value = grid.get( column ).getValue();
            if (value > 0) {
                for (int k = j; k > column; k--) {
                    if (GameRules.check( grid.get( k ), grid.get( column ) )) {
                        break;
                    }
                    j = k - 1;
                }
            }
            column -= 1;
        }
    }
}
