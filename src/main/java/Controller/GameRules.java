package Controller;

import model.Cell;

import java.util.List;

public class GameRules {
    static boolean shouldMerge(Cell cell1, Cell cell2) {
        return cell1.checkCellsForMerging(cell2);
    }

    static boolean shouldShift(Cell cell1) {
        return cell1.checkCellsForShifting();
    }

    static Boolean checkWhetherTheGridContains2048(List<Cell> grid) {
        for (Cell cell : grid) {
            if (cell.getValue() == 2048) {
                return true;
            }
        }
        return false;
    }

    static Boolean checkWhetherTheGridConsistsOfAnEmptyCell(List<Cell> grid) {
        for (Cell cell : grid) {
            if (cell.getValue() == 0) {
                return true;
            }
        }
        return false;
    }

}
