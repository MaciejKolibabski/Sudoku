package pl.first.firstjava;

import java.io.File;
import java.io.FileNotFoundException;

public class SudokuBoardDaoFactory {

    public static Dao<SudokuBoard> getFileDao(File fileName) throws FileNotFoundException {
        return new FileSudokuBoardDao(fileName);
    }


}