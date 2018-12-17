import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CellTest {
    @Test
    void shouldSetTheCellValue(){
        Cell cell = new Cell();
        cell.setValue( 3 );
        assertEquals(3,cell.getValue());
    }

    @Test
    void shouldSetTheCellValueCorrectly(){
        Cell cell = new Cell();
        cell.setValue( 3 );
        assertNotEquals(4,cell.getValue());
    }
}
