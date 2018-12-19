package model;

import java.util.List;

public class DownMover implements GridMover {

    @Override
    public void move(List<Cell> grid, int gridSize) {
        int column = 0;
        while (column < gridSize) {
            moveOneColumnDown( grid, gridSize, column );
            column += 1;
        }
    }

    private void moveOneColumnDown(List<Cell> grid, int gridSize, int column) {
        int rowRange = ((gridSize - 1) * gridSize) + column;
        int row = (column * gridSize) + column;
        int j = row;
        while (row < rowRange) {
            row = (row * gridSize) + column;
            int value = grid.get( row ).getValue();
            if (value > 0) {
                for (int k = j; j < rowRange; j++) {

                }
            }
            row += 1;
        }
    }
}
