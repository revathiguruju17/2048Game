import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GridTest {
    @Test
    void shouldUpdateCellValueInTheGrid(){
        Grid grid = new Grid();
        grid.updateCellValue( 4, 2 );
        assertEquals(4, grid.getCell( 2 ).getValue());
    }
}
