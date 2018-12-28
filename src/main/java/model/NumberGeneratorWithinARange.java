package model;

public class NumberGeneratorWithinARange implements NumberGenerator{

    @Override
    public int getNumber(int max, int min){
       return min + (int) (Math.random() * (max));
    }
}
