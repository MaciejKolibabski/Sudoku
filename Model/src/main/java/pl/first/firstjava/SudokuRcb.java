package pl.first.firstjava;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class SudokuRcb implements Serializable, Cloneable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SudokuRcb sudokuRcb = (SudokuRcb) o;

        return new EqualsBuilder()
                .append(fields, sudokuRcb.fields)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(fields)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("fields", fields)
                .toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
