package pl.first.firstjava;

import java.util.List;

public class SudokuBox extends SudokuRcb {

    public SudokuBox(List<SudokuField> fields) {
        super(fields);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
