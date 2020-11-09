package pl.first.firstjava;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

//SudokuRCB - dodatkowa klasa która łączy klasy SudokuRow/Column/Box - R-Row, C-Column, B-Box

public class SudokuRcb {

    protected SudokuField[] fields;

    public SudokuRcb(SudokuField[] fields) {
        this.fields = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            this.fields[i] = new SudokuField(fields[i].getFieldValue());
        }
    }

    public boolean verify() {

        ArrayList<Integer> allFields = new ArrayList<>();
        for (SudokuField field : fields) {
            if (field.getFieldValue() != 0) {
                allFields.add(field.getFieldValue());
            }
        }

        Set<Integer> noDuplicates = new LinkedHashSet<>(allFields);
        return noDuplicates.size() == allFields.size();
        }

    public SudokuRcb tryValue(int value) {
        for (int i = 0; i < 9; i++) {
            if (fields[i].getFieldValue() == 0) {
                fields[i].setFieldValue(value);
                return this;
            }
        }
        return this;
    }





}
