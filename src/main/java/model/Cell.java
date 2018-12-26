package model;

public class Cell {

    private int value;

    public Cell(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addTwoCellValues(Cell cell){
        setValue( this.value+cell.value );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cell)) return false;
        Cell cell = (Cell) o;
        return value == cell.value;
    }
}
