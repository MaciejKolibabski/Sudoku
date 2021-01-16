package pl.first.firstjava;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SudokuField implements Serializable, Cloneable, Comparable<SudokuField> {

    private int fieldValue;

    public SudokuField() {

    }

    public SudokuField(int value) {

        this.fieldValue = value;
    }

    public SudokuField(SudokuField sudokuField) {
        this.fieldValue = sudokuField.getFieldValue();
    }

    public int getFieldValue() {
        return this.fieldValue;
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
                .append(fieldValue, that.fieldValue)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(fieldValue)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("value= ", fieldValue)
                .toString();
    }

    public void setFieldValue(int value) {
        if (value < 0 || value > 9) {
            System.out.println("Must be <1;9>");
        }
        this.fieldValue = value;
    }

    @Override
    protected SudokuField clone() throws CloneNotSupportedException {
        SudokuField sudokuField = new SudokuField();
        sudokuField.fieldValue = this.fieldValue;
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