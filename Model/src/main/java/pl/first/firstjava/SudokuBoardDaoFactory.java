package pl.first.firstjava;

public class SudokuBoardDaoFactory {
    static public Dao<SudokuBoard> getFileDao(String filename) {
        return new FileSudokuBoardDao(filename);
    }
}
