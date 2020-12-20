package pl.first.firstjava;

import java.util.List;

public class SudokuColumn extends SudokuRcb {

    public SudokuColumn(List<SudokuField> fields) {
        super(fields);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
