package model;

public class NumberGenerator {

    int getNumberWithinARange(int max, int min){
        return min + (int) (Math.random() * (max));
    }

    int getNumberWithAPowerOf2(int max, int min) {
        return (int) Math.pow(2, min + (int) (Math.random() * (max)));
    }
}
