package model;

public class Cell {
    private int value;

    public int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

    void addTwoCellValues(Cell cell){
        setValue( this.value+cell.value );
    }
}
