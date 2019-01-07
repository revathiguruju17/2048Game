package model;

public class NumberGenerator {

    public int getNumberWithinARange(int max, int min){
        return min + (int) (Math.random() * (max));
    }

    public int getNumberWithinASpecifiedRangeAndCalculatePower(int max, int min, int base) {
        return (int) Math.pow(base, min + (int) (Math.random() * (max)));
    }
}
