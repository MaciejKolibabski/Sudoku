package pl.first.firstjava;

import java.util.Random;

public class BacktrackingSudokuSolver implements SudokuSolver {




    @Override
    public boolean solve(SudokuBoard board) {
        Random rand = new Random();
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {

                if (board.get(y, x) == 0) {


                    int ran = rand.nextInt(9) + 1;
                    for (int z = 1; z <= 9; z++) {
                        int number = (ran + z) % 9 + 1;

                        if (board.checkOK(y,x,number)) {

                            board.set(y, x, number);

                            if (solve(board)) {
                                return true;
                            } else {
                                board.set(y, x, 0);
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

