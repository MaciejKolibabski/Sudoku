package pl.first.firstjava;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class BacktrackingSudokuSolverTest {
    private SudokuBoard sudokuBoard;
    private SudokuSolver sudokuSolver;
    private BacktrackingSudokuSolver solver;

//    final private int[][] solveboard={
//            {0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0},
//    };


    @BeforeEach
    public void setUp()  {
        SudokuSolver sudokuSolver = new BacktrackingSudokuSolver();
       sudokuBoard = new SudokuBoard();
        sudokuBoard.solveGame();
    }

//    @RepeatedTest(2)
//    public void MainTest() {
//
//
//        SudokuBoard sudoku = new SudokuBoard();
//        System.out.println("Zainicjowane samymi zerami");
//        sudoku.show();
//
//
//        if () {
//            System.out.println("Po wykonaniu algorytmu");
//            sudoku.show();
//        } else {
//            System.out.println("Błąd !!!");
//        }
//    }


    @Test
    public void testfillBoard()  {

        sudokuBoard.solveGame();
        //rzędy
        for (int i = 0; i < 9; i++) {
            int suma = 0;
            for (int j = 0; j < 9; j++) {
                suma += sudokuBoard.get(i,j);
            }
            assertEquals(45, suma);
        }

        //kolumny

        for (int i = 0; i < 9; i++) {
            int suma = 0;
            for (int j = 0; j < 9; j++) {
                suma += sudokuBoard.get(j, i);
            }
            assertEquals(45, suma);
        }



        //małekwadraty

        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                int sum = 0;
                for (int i = x * 3; i <= x * 3 + 2; i++) {
                    for (int j = y * 3; j <= y * 3 + 2; j++) {
                        sum += sudokuBoard.get(i, j);
                    }
                }
                assertEquals(45, sum);
            }
        }

    }

   // powtarzalnośccyferekwsudoku
    @Test
    public void testRandom() {

        SudokuBoard Test1= new SudokuBoard();
        SudokuBoard Test2= new SudokuBoard();


        Test1.solveGame();
        Test2.solveGame();

        boolean boardsEqual=false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Test1.get(i, j) != Test2.get(i, j)) {
                    boardsEqual = false;
                }
            }
        }
        assertFalse(boardsEqual);
    }

}
