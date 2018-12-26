package Command;

import model.Cell;

import java.util.List;

public interface Command {
    void move(List<Cell> grid, int gridSize);
}

