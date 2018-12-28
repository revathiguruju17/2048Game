package model;

import Factory.MoverFactory;

import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

public class Game2048 {
    private List<Cell> grid;
    private static final int GRID_SIZE = 4;

    public Game2048() {
        grid = Arrays.asList(new Cell(0), new Cell(0), new Cell(0), new Cell(0)
                , new Cell(0), new Cell(0), new Cell(0), new Cell(0)
                , new Cell(0), new Cell(0), new Cell(0), new Cell(0),
                new Cell(0), new Cell(0), new Cell(0), new Cell(0));
    }

    public void gameSetup(NumberGenerator numberGenerator1, NumberGenerator numberGenerator2) {
        int index1 = numberGenerator1.getNumber(15, 0);
        int index2 = numberGenerator1.getNumber(15, 0);
        int value1 = numberGenerator2.getNumber(2, 1);
        int value2 = numberGenerator2.getNumber(2, 1);
        grid.get(index1).setValue(value1);
        grid.get(index2).setValue(value2);
    }

    public Mover getMover(int keycode) {
        return MoverFactory.getMover(keycode);
    }

    public void play(Mover mover, NumberGenerator numberGenerator, NumberGenerator numberGenerator1) {
        mover.execute(grid, GRID_SIZE);
        new CellGenerator().generate(grid, numberGenerator, numberGenerator1);
    }

    public List<Cell> getGrid() {
        return grid;
    }
}
