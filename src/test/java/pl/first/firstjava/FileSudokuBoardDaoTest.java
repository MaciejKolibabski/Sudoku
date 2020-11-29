package pl.first.firstjava;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.RuntimeException;

import static org.junit.jupiter.api.Assertions.*;

public class FileSudokuBoardDaoTest  {



    private Dao<SudokuBoard> fileSudokuBoardDao;
    private SudokuBoard sudokuBoardSecond;



@Test
    public void writeReadTest() {
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        SudokuBoard sudokuBoard = new SudokuBoard();
        SudokuBoard sudokuBoardSecond;
        Dao<SudokuBoard> fileSudokuBoardDao;
        fileSudokuBoardDao = factory.getFileDao("fileName");
        fileSudokuBoardDao.write(sudokuBoard);
        sudokuBoardSecond = fileSudokuBoardDao.read();

        assertEquals(sudokuBoard, sudokuBoardSecond);
    }








    
}