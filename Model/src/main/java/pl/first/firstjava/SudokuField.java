package pl.first.firstjava;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SudokuField implements Serializable, Cloneable, Comparable<SudokuField> {

    private int value;

    public SudokuField() {

    }

    public SudokuField(int value) {

        this.value = value;
    }

    public SudokuField(SudokuField sudokuField) {
        this.value = sudokuField.getFieldValue();
    }

    public int getFieldValue() {

        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SudokuField that = (SudokuField) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(value, that.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(value)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("value= ", value)
                .toString();
    }

    public void setFieldValue(int value) {
        if (value < 0 || value > 9) {
            System.out.println("Must be <1;9>");
        }
        this.value = value;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SudokuField sudokuField = new SudokuField();
        sudokuField.value = this.value;
        return sudokuField;
    }

    @Override
    public int compareTo(SudokuField o) {
        if (this.getFieldValue() == o.getFieldValue()) {
            return 0;
        } else if (this.getFieldValue() > o.getFieldValue()) {
            return 1;
        } else {
            return -1;
        }
    }

}