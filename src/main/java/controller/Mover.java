package controller;

import model.*;

import java.util.List;

public enum Mover {
    LEFT{
        public void move(List<Cell> grid, int size){
            LeftMover leftMover = new LeftMover();
            leftMover.move( grid , size);
        }
    },
    RIGHT{
        public void move(List<Cell> grid, int size){
            RightMover rightMover= new RightMover();
            rightMover.move( grid,size );
        }
    },
    UP{
        public void move(List<Cell> grid, int size){
            UpMover upMover = new UpMover();
            upMover.move(grid,size);
        }
    },
    DOWN{
        public void move(List<Cell> grid, int size) {
            DownMover downMover = new DownMover();
            downMover.move( grid, size);
        }
    };

public void move(List<Cell> grid, int size){}
}
