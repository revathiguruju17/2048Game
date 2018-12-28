package model;

import java.util.List;

public class CellGenerator {
   public List<Cell> generate(List<Cell> grid, NumberGenerator numberGenerator, NumberGenerator numberGenerator1) {
        int value;
        do {
            int index = numberGenerator.getNumber(15, 0);
            value = grid.get(index).getValue();
            if (value == 0) {
                grid.get(index).setValue(numberGenerator1.getNumber(2, 1));
            }
        } while (value != 0);
        return grid;
    }
}
