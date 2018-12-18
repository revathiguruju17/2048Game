package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberGeneratorTest {
    @Test
    void shouldGenerateNumberWhichIsGreaterThanOrEqualToTheMinimumRange() {
        int number = NumberGenerator.getRandomNumberWithinARange(15,0 );
        assertTrue( number >= 0 );
    }

    @Test
    void shouldGenerateNumberWhichIsLesserThanTheMaximumRange() {
        int number = NumberGenerator.getRandomNumberWithinARange( 15, 0 );
        assertTrue( number < 16 );
    }

    @Test
    void shouldGenerateANumberWhichIsAPowerOf2(){
        int number = NumberGenerator.getRandomNumberWithinARangeAndPowerOf2( 2,1 );
        assertTrue( number==2 || number==4 );
    }
}
