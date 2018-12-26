package controller;

import Command.*;
import model.Cell;

import java.util.List;

public enum Path {
    LEFT ( new LeftMoveCommand()),
    RIGHT(new RightMoveCommand()),
    UP (new UpMoveCommand() ),
    DOWN (new DownMoveCommand() );

    private Command command;

    Path(Command command) {
        this.command = command;
    }

    public void move(List<Cell> grid, int size) {
        this.command.move( grid,size );
    }
}
