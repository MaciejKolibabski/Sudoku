package pl.first.firstjava;

import org.junit.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class FileSudokuBoardDaoTest  {


@Test
    public void writeReadTest() throws Exception {
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        SudokuBoard sudokuBoard = new SudokuBoard();
        SudokuBoard sudokuBoardSecond;
        Dao<SudokuBoard> fileSudokuBoardDao;
        fileSudokuBoardDao = factory.getFileDao( new File("fileName.ser"));
        fileSudokuBoardDao.write(sudokuBoard);
        sudokuBoardSecond = fileSudokuBoardDao.read();
        assertEquals(sudokuBoard, sudokuBoardSecond);
    }









}