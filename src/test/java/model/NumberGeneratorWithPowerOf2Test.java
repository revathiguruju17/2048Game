package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberGeneratorWithPowerOf2Test {
    private NumberGenerator numberGenerator;

    @BeforeEach
    void init(){
      numberGenerator = new NumberGeneratorWithPowerOf2();
    }

    @Test
    void shouldReturnTrueIfTheNumberIsWithinTheRange() {
        int number = numberGenerator.getNumber(2, 1);
        assertTrue(number>=2 && number<=4);
    }

    @Test
    void shouldReturnFalseIfTheNumberIsNotWithinTheRange() {
        int number = numberGenerator.getNumber(10, 1);
        assertFalse(number<2 || number>1024);
    }
}
