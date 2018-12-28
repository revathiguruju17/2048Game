package Factory;

import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoverFactoryTest {

    @Test
    void shouldReturnLetMoverWhenWePassLeftKeyCode() {
        Mover mover = MoverFactory.getMover(37);
        assertEquals(LeftMover.class, mover.getClass());
    }

    @Test
    void shouldReturnUpMoverWhenWePassUpKeyCode() {
        Mover mover = MoverFactory.getMover(38);
        assertEquals(UpMover.class, mover.getClass());
    }

    @Test
    void shouldReturnRightMoverWhenWePassRightKeyCode() {
        Mover mover = MoverFactory.getMover(39);
        assertEquals(RightMover.class, mover.getClass());
    }

    @Test
    void shouldReturnDownMoverWhenWePassDownKeyCode() {
        Mover mover = MoverFactory.getMover(40);
        assertEquals(DownMover.class, mover.getClass());
    }

}
