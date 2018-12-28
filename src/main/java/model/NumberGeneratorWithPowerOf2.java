package model;

public class NumberGeneratorWithPowerOf2 implements NumberGenerator {

    @Override
    public int getNumber(int max, int min) {
        return (int) Math.pow(2, min + (int) (Math.random() * (max)));
    }
}
