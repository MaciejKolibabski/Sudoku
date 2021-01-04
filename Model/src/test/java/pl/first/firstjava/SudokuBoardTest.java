package pl.first.firstjava;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;




public class SudokuBoardTest{
    private SudokuBoard sudokuBoard;
    private SudokuBoard sudokuBoard2;

    @BeforeEach
    public void setUp() {
        sudokuBoard = new SudokuBoard();
    }

    @Test
    public void constructorTest()  {

        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.set(1,1,3);
        assertEquals(sudokuBoard.get(1,1),3);
    }

    @Test
    public void toStringTest() {
        assertNotNull(sudokuBoard.toString());
    }
    @Test
    public void equalsTest() {
        sudokuBoard2 = new SudokuBoard();
        assertTrue(sudokuBoard.equals(sudokuBoard2)
                && sudokuBoard2.equals(sudokuBoard));
    }
    @Test
    public void hashCodeTest() {
        sudokuBoard2 = new SudokuBoard();
        assertEquals(sudokuBoard.hashCode(), sudokuBoard2.hashCode());
    }


}
























