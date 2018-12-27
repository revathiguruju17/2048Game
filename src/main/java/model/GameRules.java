package model;

class GameRules {
    static boolean isShouldMerge(Cell cell1, Cell cell2) {
        return cell1.checkCellsForMerging( cell2 );
    }

    static boolean isShouldShift(Cell cell1 ) {
        return cell1.checkCellsForShifting(  );
    }
}
