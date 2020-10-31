package pl.first.firstjava;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SudokuBoardTest{
    private SudokuBoard sudokuBoard;
    private SudokuSolver sudokuSolver;
    private BacktrackingSudokuSolver solver;



    @Test
    public void constructorTest()  {

        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.set(1,1,3);
        assertEquals(sudokuBoard.get(1,1),3);

    }



}
























