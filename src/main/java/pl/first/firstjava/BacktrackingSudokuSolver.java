package pl.first.firstjava;

import java.util.Random;

public class BacktrackingSudokuSolver implements SudokuSolver  {


    @Override
    public boolean solve(SudokuBoard sudokuBoard) {
            Random rand = new Random();
            for (int line = 0; line < 9; line++) {
                for (int column = 0; column < 9; column++) {

                    if (sudokuBoard.get(line, column) == 0) {


                        int ran = rand.nextInt(9) + 1;
                        for (int z = 1; z <= 9; z++) {
                            int number = (ran + z) % 9 + 1;


                            if (sudokuBoard.checkOK(line, column, number)) {

                                sudokuBoard.set(line, column, number);

                                if (solve(sudokuBoard)) {
                                    return true;
                                } else {
                                    sudokuBoard.set(line, column, 0);
                                }
                            }
                        }

                        return false;
                    }
                }
            }

            return true;
        }


    }

