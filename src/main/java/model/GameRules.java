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
        for (Cell cell : grid) {
            if (cell.getValue() == 0) {
                return true;
            }
        }
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size - 1; column++) {
                if (grid.get(row + column).getValue() == grid.get(row + column + 1).getValue()) {
                    return true;
                } else if (grid.get(row + column).getValue() == grid.get(row + column + size).getValue()) {
                    return true;
                }
            }
        }
        return false;
    }

}
