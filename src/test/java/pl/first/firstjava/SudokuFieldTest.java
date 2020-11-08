package pl.first.firstjava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SudokuFieldTest {
    private SudokuField sudokuField;

    @BeforeEach
    public void setUp() {
        sudokuField = new SudokuField();
    }
    @Test
    public void getFieldValueTest() {
        assertEquals(sudokuField.getFieldValue(), 0);
    }

    @Test
    public void setFieldValueTest() {
        sudokuField.setFieldValue(2);
        assertEquals(sudokuField.getFieldValue(), 2);
    }


}
