package Factory;

import Controller.*;

import java.awt.event.KeyEvent;

public class MoverFactory {
    public static Mover getMover(int code) {
        switch (code) {
            case KeyEvent.VK_LEFT:
                return new LeftMover();
            case KeyEvent.VK_UP:
                return new UpMover();
            case KeyEvent.VK_RIGHT:
                return new RightMover();
            case KeyEvent.VK_DOWN:
                return new DownMover();
        }
        return null;
    }
}
