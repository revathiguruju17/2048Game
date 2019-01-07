package model;


import java.util.ArrayList;
import java.util.List;

public class Game2048 {
    private List<Cell> grid;
    private int GRID_SIZE;
    private GameState gameState;
    private int base;
    private int range;

    public Game2048(int size, int base, int range) {
        this.GRID_SIZE = size;
        this.base = base;
        this.range = range;
        grid = new ArrayList<>();
        for (int count = 0; count < size * size; count++) {
            grid.add(new Cell(0));
        }
        gameState = GameState.CONTINUE;
    }

    public void gameSetup(NumberGenerator numberGenerator) {
        int index1 = numberGenerator.getNumberWithinARange(grid.size() - 1, 0);
        int index2 = numberGenerator.getNumberWithinARange(grid.size() - 1, 0);
        int value1 = numberGenerator.getNumberWithinASpecifiedRangeAndCalculatePower(range, 1, base);
        int value2 = numberGenerator.getNumberWithinASpecifiedRangeAndCalculatePower(range, 1, base);
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
