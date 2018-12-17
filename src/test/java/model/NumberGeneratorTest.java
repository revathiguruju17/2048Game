package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberGeneratorTest {
    @Test
    void shouldGenerateNumberWhichIsGreaterThanOrEqualToTheMinimumRange() {
        int number = NumberGenerator.getRandomNumber( 16, 0 );
        assertTrue( number >= 0 );
    }

    @Test
    void shouldGenerateNumberWhichIsLesserThanTheMaximumRange() {
        int number = NumberGenerator.getRandomNumber( 16, 0 );
        assertTrue( number < 16 );
    }
}
