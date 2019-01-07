package model;

import model.GameRules;
import model.Cell;
import model.Mover;

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

    private void moveOneColumnUp(List<Cell> grid, int size, int currentRow) {
        int rowRange = ((size - 1) * size) + currentRow;
        int j = currentRow;
        while (currentRow <= rowRange) {
            int value = grid.get( currentRow ).getValue();
            if (value > 0) {
                for (int i = j; i < currentRow; ) {
                    if (GameRules.shouldMerge(grid.get(i), grid.get(currentRow))) {
                        grid.get(i).merge(grid.get(currentRow));
                        j = j + size;
                        break;
                    } else if (GameRules.shouldShift(grid.get(i))) {
                        grid.get(i).shift(grid.get(currentRow));
                        break;
                    } else {
                        j = j + size;
                    }
                    i = i + size;
                }
            }
            currentRow = currentRow + size;
        }
    }
}
