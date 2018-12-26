package model;

class GameRules {
    static boolean check(Cell cell, Cell cell1) {
        boolean shouldMergeOrShift =cell.checkCellsForMergingOrShifting( cell1 );
        if(shouldMergeOrShift){
            cell.merge( cell1 );
        }
        return shouldMergeOrShift;
    }
}
