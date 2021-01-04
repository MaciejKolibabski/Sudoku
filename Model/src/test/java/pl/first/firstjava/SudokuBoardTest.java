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

    @Test
    public void cloneTest() throws CloneNotSupportedException {
        SudokuField[][] fields = new SudokuField[9][9];
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[0].length; j++) {
                fields[i][j] = new SudokuField();
            }
        }
        SudokuBoard board = new SudokuBoard();
        SudokuBoard board2 = (SudokuBoard) board.clone();
        board.solveGame();
        System.out.println(board.toString());
        System.out.println(board2.toString());
        board2.solveGame();
        assertNotSame(board, board2);
        assertNotSame(board.getColumn(1), board2.getColumn(1));
    }

}
























