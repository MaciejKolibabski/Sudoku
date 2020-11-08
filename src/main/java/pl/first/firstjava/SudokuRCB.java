package pl.first.firstjava;

import java.util.ArrayList;

public abstract class SudokuRCB {

    protected SudokuField[] fields;


    public SudokuRCB(SudokuField[] fields) {
        this.fields = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            this.fields[i] = new SudokuField(fields[i].getFieldValue());
        }

    }


    public boolean verify() {
        ArrayList<Integer> allFields = new ArrayList<>();
        for (SudokuField field : fields
        ) {
            if (field.getFieldValue() != 0) {
                allFields.add(field.getFieldValue());
            }
        }

        ArrayList<Integer> noDuplicates = new ArrayList<>();
        for (Integer value : allFields
        ) {
            if (!noDuplicates.contains(value)) {
                noDuplicates.add(value);
            }
        }

        return noDuplicates.size() == allFields.size();
    }


    public SudokuRCB tryValue(int value) {
        for (int i = 0; i < 9; i++) {
            if (fields[i].getFieldValue() == 0) {
                fields[i].setFieldValue(value);
                return this;
            }
        }
        return this;
    }


}
