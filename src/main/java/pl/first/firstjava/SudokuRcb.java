package pl.first.firstjava;


//SudokuRCB - dodatkowa klasa która łączy klasy SudokuRow/Column/Box - R-Row, C-Column, B-Box
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



public class SudokuRcb {

    protected List<SudokuField> fields;

    public SudokuRcb(List<SudokuField> fields) {
        this.fields = Arrays.asList(new SudokuField[9]);
        for (int i = 0; i < 9; i++) {
            this.fields.set(i, new SudokuField(fields.get(i).getFieldValue()));
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
            if (fields.get(i).getFieldValue() == 0) {
                fields.get(i).setFieldValue(value);
                return this;
            }
        }
        return this;
    }





}
