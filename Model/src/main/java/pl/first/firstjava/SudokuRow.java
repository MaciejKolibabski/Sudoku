package pl.first.firstjava;

import java.util.List;

public class SudokuRow extends SudokuRcb {

    public SudokuRow(List<SudokuField> fields) {
        super(fields);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
