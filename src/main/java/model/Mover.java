package model;


import java.util.List;

public interface Mover {
    void execute(List<Cell> grid, int gridSize);
}

