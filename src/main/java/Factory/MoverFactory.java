package Factory;

import model.*;

public class MoverFactory {
    public static Mover getMover(String name){
        switch (name) {
            case "left":
                return new LeftMover();
            case "right":
                return new RightMover();
            case "up":
                return new UpMover();
            default:
                return new DownMover();
        }
    }
}
