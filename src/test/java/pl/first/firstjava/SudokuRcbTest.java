package pl.first.firstjava;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuRcbTest {

    private SudokuRow PoprawnaLista(){
        return new SudokuRow(Arrays.asList(
                new SudokuField(1),
                new SudokuField(2),
                new SudokuField(3),
                new SudokuField(4),
                new SudokuField(5),
                new SudokuField(6),
                new SudokuField(7),
                new SudokuField(8),
                new SudokuField(9)));
    }

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

    @Test
    public void toStringTest(){
        SudokuRow sudokuRow = PoprawnaLista();
            assertNotNull(sudokuRow.toString());

    }

    @Test
    public void equalsTest(){
        SudokuRow sudokuRow = PoprawnaLista();
        SudokuRow sudokuRow2 = PoprawnaLista();

        assertTrue(sudokuRow.equals(sudokuRow2) && sudokuRow2.equals(sudokuRow));
    }

    @Test
    public void hashCodeTest(){
        SudokuRow sudokuRow = PoprawnaLista();
        SudokuRow sudokuRow2 = PoprawnaLista();

        assertEquals(sudokuRow.hashCode(), sudokuRow2.hashCode());
    }
}