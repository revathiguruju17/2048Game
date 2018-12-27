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
        int currentColumn = ((row + 1) * gridSize) - 1;
        int j = currentColumn;
        while (currentColumn >= columnSize) {
            int value = grid.get( currentColumn ).getValue();
            if (value > 0) {
                for (int k = j; k > currentColumn; k--) {
                    if (GameRules.isShouldMerge( grid.get( k ), grid.get( currentColumn ) )) {
                        grid.get( k ).merge( grid.get( currentColumn ) );
                        j = k - 1;
                        break;
                    } else if (GameRules.isShouldShift( grid.get( k ) )) {
                        grid.get( k ).shift( grid.get( currentColumn ) );
                        break;
                    } else {
                        j = k - 1;
                    }
                }
            }
            currentColumn -= 1;
        }
    }
}
