package pl.first.firstjava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuFieldTest {
    private SudokuField sudokuField;
    private SudokuField sudokuField2;

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

    @Test
    public void toStringTest() {

        assertNotNull(sudokuField.toString());
    }

    @Test
    public void equalsTest() {
        sudokuField2 = new SudokuField();
        assertTrue(sudokuField.equals(sudokuField2) && sudokuField2.equals(sudokuField));
    }

    @Test
    public void hashCodeTest() {
        sudokuField2 = new SudokuField();
        assertEquals(sudokuField.hashCode(), sudokuField2.hashCode());
    }


}
