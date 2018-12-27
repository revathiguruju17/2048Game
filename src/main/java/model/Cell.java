package model;

public class Cell {

    private int value;

    public Cell(int value) {
        this.value = value;
    }

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

    void merge(Cell cell) {
        this.addTwoCellValues( cell );
        cell.setValue( 0 );
    }

    boolean checkCellsForMerging(Cell cell) {
        return this.equals( cell);
    }

    boolean checkCellsForShifting() {
        return this.getValue()==0 ;
    }

    void shift(Cell cell2) {
        this.setValue( cell2.getValue() );
        cell2.setValue( 0 );
    }
}
