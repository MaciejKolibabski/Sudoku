package pl.first.firstjava;

import java.util.Random;

public class BacktrackingSudokuSolver implements SudokuSolver {




    @Override
    public boolean solve(SudokuBoard board) {
        Random rand = new Random();
        for (int line = 0; line < 9; line++) {
            for (int column = 0; column < 9; column++) {

                if (board.get(line, column) == 0) {


                    int ran = rand.nextInt(9) + 1;
                    for (int z = 1; z <= 9; z++) {
                        int number = (ran + z) % 9 + 1;


                        if (board.checkOK(line,column,number)) {

                            board.set(line, column, number);

                            if (solve(board)) {
                                return true;
                            } else {
                                board.set(line, column, 0);
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

