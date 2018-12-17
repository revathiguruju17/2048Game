package model;


class NumberGenerator {

    static int getRandomNumber(int max, int min) {
        return min + (int) (Math.random() * max);
    }
}
