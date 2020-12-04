package pl.first.firstjava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardDaoFactoryTest {

    private SudokuBoardDaoFactory daoFactory = new SudokuBoardDaoFactory();

    @Test
    void getFileDaotest() {
        assertNotNull(daoFactory.getFileDao("nazwatestowa"));
    }
}