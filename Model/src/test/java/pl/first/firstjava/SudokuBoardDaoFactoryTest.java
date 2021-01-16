package pl.first.firstjava;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardDaoFactoryTest {

    private SudokuBoardDaoFactory daoFactory = new SudokuBoardDaoFactory();

    @Test
    void getFileDaotest() throws FileNotFoundException {
        assertNotNull(daoFactory.getFileDao(new File("File.txt")));
    }
}