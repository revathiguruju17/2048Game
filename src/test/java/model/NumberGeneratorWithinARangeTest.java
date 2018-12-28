package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberGeneratorWithinARangeTest {

    private NumberGenerator numberGenerator;

    @BeforeEach
    void init() {
        numberGenerator = new NumberGeneratorWithinARange();
    }

    @Test
    void shouldReturnTrueIfTheNumberIsWithinTheRange() {
        int number = numberGenerator.getNumber(15, 1);
        assertTrue(number>0 && number<16);
    }

    @Test
    void shouldReturnFalseIfTheNumberIsNotWithinTheRange() {
        int number = numberGenerator.getNumber(20, 5);
        assertFalse(number<5 || number>20);
    }
}
