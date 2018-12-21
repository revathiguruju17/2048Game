package controller;

import model.*;

import java.util.List;

public enum Direction {
    LEFT {
        public void move(List<Cell> grid, int size) {
            new LeftMover().move( grid, size );
        }
    },
    RIGHT {
        public void move(List<Cell> grid, int size) {
            new RightMover().move( grid, size );
        }
    },
    UP {
        public void move(List<Cell> grid, int size) {
            new UpMover().move( grid, size );
        }
    },
    DOWN {
        public void move(List<Cell> grid, int size) {
            new DownMover().move( grid, size );
        }
    };

    public void move(List<Cell> grid, int size) {
    }
}
