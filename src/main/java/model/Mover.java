package model;

import model.Cell;

import java.util.List;

public interface Mover {
    void execute(List<Cell> grid, int gridSize);
}

