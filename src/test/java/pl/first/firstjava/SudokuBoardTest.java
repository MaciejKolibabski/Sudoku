package pl.first.firstjava;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuBoardTest {
    private SudokuBoard sudokuBoard;
    private boolean boardsEqual = true;

    @BeforeEach
    public void setUp() {
        sudokuBoard = new SudokuBoard();
        sudokuBoard.fillBoard();
    }

    @RepeatedTest(2)
    public void MainTest() {


        SudokuBoard sudoku = new SudokuBoard();
        System.out.println("Zainicjowane samymi zerami");
        sudoku.show();

        // we try resolution
        if (sudoku.fillBoard()) {
            System.out.println("Po wykonaniu algorytmu");
            sudoku.show();
        } else {
            System.out.println("Błąd !!!");
        }
    }


    @Test
    public void testfillBoard() {
        //rzędy
        for (int i = 0; i < 9; i++) {
            int suma = 0;
            for (int j = 0; j < 9; j++) {
                suma += sudokuBoard.getField(i, j);
            }
            assertEquals(45, suma);
        }

        //kolumny

        for (int i = 0; i < 9; i++) {
            int suma = 0;
            for (int j = 0; j < 9; j++) {
                suma += sudokuBoard.getField(j, i);
            }
            assertEquals(45, suma);
        }

        //małekwadraty

        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                int sum = 0;
                for (int i = x * 3; i <= x * 3 + 2; i++) {
                    for (int j = y * 3; j <= y * 3 + 2; j++) {
                        sum += sudokuBoard.getField(i, j);
                    }
                }
                assertEquals(45, sum);
            }
        }

    }

    //powtarzalnośccyferekwsudoku
    @Test
    public void testRandom() {
        SudokuBoard Test1 = new SudokuBoard();
        SudokuBoard Test2 = new SudokuBoard();
        Test1.fillBoard();
        Test2.fillBoard();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Test1.getField(i, j) != Test2.getField(i, j)) {
                    boardsEqual = false;
                }
            }
        }
        assertFalse(boardsEqual);
    }
}
























