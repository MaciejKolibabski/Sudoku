package pl.first.firstjava;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class SudokuRcbTest {
    @Test
    public void verifyTestpoprawny() {
        SudokuRow sudokuRow = new SudokuRow(Arrays.asList(
                new SudokuField(1),
                new SudokuField(2),
                new SudokuField(3),
                new SudokuField(4),
                new SudokuField(5),
                new SudokuField(6),
                new SudokuField(7),
                new SudokuField(8),
                new SudokuField(9)));
        assertTrue(sudokuRow.verify());
    }
    @Test
    public void verifyTestniepoprawny() {
        SudokuRow sudokuRow = new SudokuRow(Arrays.asList(
                new SudokuField(3),
                new SudokuField(3),
                new SudokuField(3),
                new SudokuField(4),
                new SudokuField(5),
                new SudokuField(7),
                new SudokuField(7),
                new SudokuField(8),
                new SudokuField(9)));
        assertFalse(sudokuRow.verify());
    }
}