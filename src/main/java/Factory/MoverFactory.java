package Factory;

import model.*;

public class MoverFactory {
    public static Mover getMover(String name){
        switch (name) {
            case "LEFT":
                return new LeftMover();
            case "RIGHT":
                return new RightMover();
            case "UP":
                return new UpMover();
            default:
                return new DownMover();
        }
    }
}
