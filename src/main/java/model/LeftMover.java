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
            if (grid.get( column ).getValue() > 0) {
                for (int k = j; k < column; k++) {
                    if(GameRules.check(grid.get( k ),grid.get( column ))){
                        break;
                    }
                    j = k + 1;
                }
            }
            column += 1;
        }
    }
}
