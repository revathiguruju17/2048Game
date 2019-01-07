package model;

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
        GameState gameState = GameState.CONTINUE;
    }

    public void gameSetup(NumberGenerator numberGenerator) {
        int index1 = numberGenerator.getNumberWithinARange(15, 0);
        int index2 = numberGenerator.getNumberWithinARange(15, 0);
        int value1 = numberGenerator.getNumberWithAPowerOf2(2, 1);
        int value2 = numberGenerator.getNumberWithAPowerOf2(2, 1);
        grid.get(index1).setValue(value1);
        grid.get(index2).setValue(value2);
    }

    public GameState play(Mover mover, NumberGenerator numberGenerator) {
        mover.execute(grid, GRID_SIZE);
        GameState gameState = updateGameState();
        if (gameState.equals(GameState.CONTINUE)) {
            new CellGenerator().generate(grid, numberGenerator);
        }
        return gameState;
    }

    private GameState updateGameState() {
        if (GameRules.checkWhetherTheGridContains2048(grid)) {
            return GameState.WIN;
        } else if (!GameRules.checkWhetherTheGridConsistsOfAnEmptyCell(grid)) {
            return GameState.OVER;
        } else
            return GameState.CONTINUE;
    }


    public List<Cell> getGrid() {
        return grid;
    }
}
