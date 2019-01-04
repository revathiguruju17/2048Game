package model;

import java.util.List;

class GameRules {
    static boolean shouldMerge(Cell cell1, Cell cell2) {
        return cell1.checkCellsForMerging(cell2);
    }

    static boolean shouldShift(Cell cell1) {
        return cell1.checkCellsForShifting();
    }

    static Boolean checkWhetherTheGridContains2048(List<Cell> grid) {
        boolean isGridContains2048 = false;
        for (Cell cell : grid) {
            if (cell.getValue() == 2048) {
                isGridContains2048 = true;
            }
        }
        return isGridContains2048;
    }

    static Boolean checkWhetherTheGridConsistsOfAnEmptyCell(List<Cell> grid, int size) {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                int currentCell = (row * size) + column;
                int currentValue = grid.get(currentCell).getValue();
                if (grid.get(currentCell).getValue() == 0) {
                    return true;
                } else if (currentCell == grid.size() - 1 && grid.get(currentCell).getValue() != 0) {
                    return false;
                } else if (column == size - 1 || row == size - 1) {
                    if (column == size - 1 && currentValue == grid.get(currentCell + size).getValue()) {
                        return true;
                    }
                    if (row == size - 1 && currentValue == grid.get(currentCell + 1).getValue()) {
                        return true;
                    }
                } else {
                    if (currentValue == grid.get(currentCell + 1).getValue()) {
                        return true;
                    }
                    if (currentValue == grid.get(currentCell + size).getValue()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
