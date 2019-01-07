package Controller;

import Controller.GameRules;
import Controller.Mover;
import model.Cell;

import java.util.List;

public class DownMover implements Mover {

    @Override
    public void execute(List<Cell> grid, int size) {
        int column = 0;
        while (column < size) {
            moveOneColumnDown(grid, size, column);
            column += 1;
        }
    }

    private void moveOneColumnDown(List<Cell> grid, int size, int range) {
        int currentRow = ((size - 1) * size) + range;
        int j = currentRow;
        while (currentRow >= range) {
            int value = grid.get(currentRow).getValue();
            if (value > 0) {
                for (int i = j; i > currentRow; ) {
                    if (GameRules.shouldMerge(grid.get(i), grid.get(currentRow))) {
                        grid.get(i).merge(grid.get(currentRow));
                        j = j - size;
                        break;
                    } else if (GameRules.shouldShift(grid.get(i))) {
                        grid.get(i).shift(grid.get(currentRow));
                        break;
                    } else {
                        j = j - size;
                    }
                    i = i - size;
                }
            }
            currentRow = currentRow - size;
        }
    }
}
