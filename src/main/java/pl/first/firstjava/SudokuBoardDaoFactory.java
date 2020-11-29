package pl.first.firstjava;

import java.io.Serializable;

public class SudokuBoardDaoFactory {
    public Dao<SudokuBoard> getFileDao(String filename) {
        return new FileSudokuBoardDao(filename);
    }
}
