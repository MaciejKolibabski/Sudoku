package pl.first.firstjava;

public class SudokuField {

    private int value;

    public SudokuField() {

    }

    public SudokuField(SudokuField sudokuField) {
        this.value= sudokuField.getFieldValue();
    }

    public SudokuField(int value) {

        this.value = value;
    }

    public int getFieldValue() {

        return this.value;
    }

    public void setFieldValue(int value) {
        if (value < 0 || value > 9) {
            System.out.println("Ma być z przedziału <1,9>");
            return ;
        }
        this.value = value;
    }
}
