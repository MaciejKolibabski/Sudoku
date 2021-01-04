import pl.first.firstjava.SudokuBoard;

import java.util.Random;

public class DifficultChoice {

    public SudokuBoard deleteRandom(SudokuBoard tab, int deleteFiedls) {
        Random rand = new Random();
        while (deleteFiedls > 0) {
            int x = rand.nextInt(9);
            int y = rand.nextInt(9);
            if (tab.get(x,y) != 0) {
                tab.set(x, y, 0);
                deleteFiedls--;
            }
        }
        return tab;
    }
}
