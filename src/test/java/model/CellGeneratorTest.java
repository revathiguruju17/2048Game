package model;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CellGeneratorTest {

    @Test
    void shouldCreateOneCellIfTheGridInAnEmptyPlaceInGrid() {
        List<Cell> grid = Arrays.asList(new Cell(4), new Cell(0), new Cell(8), new Cell(8), new Cell(24),
                new Cell(4), new Cell(4), new Cell(0), new Cell(0), new Cell(0),
                new Cell(8), new Cell(2), new Cell(2), new Cell(4), new Cell(2), new Cell(4));
        NumberGenerator numberGenerator = Mockito.mock(NumberGeneratorWithinARange.class);
        NumberGenerator numberGenerator1 = Mockito.mock(NumberGeneratorWithPowerOf2.class);
        when(numberGenerator.getNumber(15, 0)).thenReturn(7);
        when(numberGenerator1.getNumber(2, 1)).thenReturn(4);
        new CellGenerator().generate(grid, numberGenerator, numberGenerator1);
        assertEquals(4, grid.get(7).getValue());
    }
}
