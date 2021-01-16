//package pl.first.firstjava;
//
//import org.junit.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class FileSudokuBoardDaoTest  {
//
//
//@Test
//    public void writeReadTest() {
//        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
//        SudokuBoard sudokuBoard = new SudokuBoard();
//        SudokuBoard sudokuBoardSecond;
//        Dao<SudokuBoard> fileSudokuBoardDao;
//        fileSudokuBoardDao = factory.getFileDao("fileName");
//        fileSudokuBoardDao.write(sudokuBoard);
//        sudokuBoardSecond = fileSudokuBoardDao.read();
//        assertEquals(sudokuBoard, sudokuBoardSecond);
//    }
//
//
//
//
//
//
//
//
//
//}