package Factory;

import java.awt.event.KeyEvent;

public class KeyFactory {

    public static String getKey(int code) {
        if (code == KeyEvent.VK_DOWN) {
            return "DOWN";
        } else if (code == KeyEvent.VK_UP) {
            return "UP";
        } else if (code == KeyEvent.VK_LEFT) {
            return "LEFT";
        }
        return "RIGHT";
    }
}
