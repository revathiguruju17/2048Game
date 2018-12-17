package model;


class NumberGenerator {

    static int getRandomNumberWithinARange(int max, int min) {
        return min + (int) (Math.random() * max);
    }

    static int getRandomNumberWithinARangeAndPowerOf2(int max, int min) {
        int number = min + (int) (Math.random() * max);
        return (int)Math.pow( 2,number );
    }
}
