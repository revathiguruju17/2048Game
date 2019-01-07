package model;

import java.util.List;

class CellGenerator {
   List<Cell> generate(List<Cell> grid, NumberGenerator numberGenerator) {
        int value;
        do {
            int index = numberGenerator.getNumberWithinARange(15, 0);
            value = grid.get(index).getValue();
            if (value == 0) {
                grid.get(index).setValue(numberGenerator.getNumberWithAPowerOf2(2, 1));
            }
        } while (value != 0);
        return grid;
    }
}
