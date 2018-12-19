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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cell)) return false;
        Cell cell = (Cell) o;
        return value == cell.value;
    }
}
