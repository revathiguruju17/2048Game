package model;

import java.util.List;

public class GameRules {
    static boolean isShouldMerge(Cell cell1, Cell cell2) {
        return cell1.checkCellsForMerging(cell2);
    }

    static boolean isShouldShift(Cell cell1) {
        return cell1.checkCellsForShifting();
    }

    public static Boolean checkWhetherTheGridContains2048(List<Cell> grid) {
        boolean isGridContains2048 = false;
        for (Cell cell : grid) {
            if (cell.getValue() == 2048) {
                isGridContains2048 = true;
            }
        }
        return isGridContains2048;
    }

    public static Boolean checkWhetherTheGridConsistsOfAnEmptyCell(List<Cell> grid) {
        boolean isEmpty = false;
        for (Cell cell : grid) {
            if (cell.getValue() == 0) {
                isEmpty = true;
            }
        }
        return isEmpty;
    }
}
