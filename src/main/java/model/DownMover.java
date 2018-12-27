package model;

import java.util.List;

public class DownMover implements Mover {

    @Override
    public void execute(List<Cell> grid, int size) {
        int column = 0;
        while (column < size) {
            moveOneColumnDown( grid, size, column );
            column += 1;
        }
    }

    private void moveOneColumnDown(List<Cell> grid, int size, int range) {
        int row = ((size - 1) * size) + range;
        int j = row;
        while (row >= range) {
            int value = grid.get( row ).getValue();
            if (value > 0) {
                for (int i = j; i > row; ) {
                    //if (GameRules.check( grid.get( i ), grid.get( row ) )) {
                     //   break;
                   // }
                    j = j - size;
                    //i = i - size;
                }
            }
            row = row - size;
        }
    }
}
