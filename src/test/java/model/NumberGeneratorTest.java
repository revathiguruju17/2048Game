package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberGeneratorTest {
    private NumberGenerator numberGenerator;

    @BeforeEach
    void init() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    void shouldReturnTrueIfTheNumberIsWithinTheRange() {
        int number = numberGenerator.getNumberWithinARange(15, 1);
        assertTrue(number>0 && number<16);
    }

    @Test
    void shouldReturnFalseIfTheNumberIsNotWithinTheRange() {
        int number = numberGenerator.getNumberWithinARange(20, 5);
        assertFalse(number<5 || number>20);
    }

    @Test
    void shouldReturnTrueIfTheNumberIsWithinTheRangeAndIsPowerOf2() {
        int number = numberGenerator.getNumberWithinASpecifiedRangeAndCalculatePower(2, 1,2);
        assertTrue(number>=2 && number<=4);
    }

    @Test
    void shouldReturnFalseIfTheNumberIsNotWithinTheRangeAndIsPowerOf2() {
        int number = numberGenerator.getNumberWithinASpecifiedRangeAndCalculatePower(10, 1,2);
        assertFalse(number<2 || number>1024);
    }
}
