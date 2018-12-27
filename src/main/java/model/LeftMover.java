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

    private void moveOneRowToLeft(List<Cell> grid, int gridSize, int currentRow) {
        int columnSize = (currentRow + 1) * gridSize;
        int currentColumn = (currentRow * gridSize);
        int j = currentRow * gridSize;
        while (currentColumn < columnSize) {
            if (grid.get( currentColumn ).getValue() > 0) {
                for (int k = j; k < currentColumn; k++) {
                    if (GameRules.isShouldMerge(grid.get( k ),grid.get( currentColumn ))) {
                        grid.get( k ).merge( grid.get( currentColumn ) );
                        j = k + 1;
                        break;
                    }
                    else if (GameRules.isShouldShift(grid.get( k ))) {
                        grid.get( k ).shift( grid.get( currentColumn ) );
                        break;
                    }
                    else{
                        j = k+1;
                    }
                }
            }
            currentColumn += 1;
        }
    }
}
