package pl.first.firstjava;

public class SudokuField {

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

    public void setFieldValue(int value) {
        if (value < 0 || value > 9) {
            System.out.println("Must be <1;9>");
        }
        this.value = value;
    }
}