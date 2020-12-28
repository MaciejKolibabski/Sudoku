import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import pl.first.firstjava.SudokuBoard;
import pl.first.firstjava.SudokuField;


public class SudokuViewController implements Initializable {
    private SudokuBoard board;
    public GridPane grid;
    public int deleteFiedls;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GridPane grid = new GridPane();
        SudokuBoard board = new SudokuBoard();
        board.solveGame();

    }


    SudokuBoard fillBoard() {

        SudokuField[][] fields = new SudokuField[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                fields[i][j] = new SudokuField();
            }
        }
        SudokuBoard board = new SudokuBoard();
        board.solveGame();
        this.board = board;
        return board;
    }


    public void showSudoku(int deleteFiedls) {

        fillBoard();
        deleteRandom(board,deleteFiedls);

        TextField[][] labels = new TextField[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.get(i, j) != 0) {
                    labels[i][j] = new TextField(Integer.toString(board.get(i, j)));
                } else {
                    labels[i][j] = new TextField("");
                }

                labels[i][j].setAlignment(Pos.CENTER);
                labels[i][j].setPrefHeight(100);
                labels[i][j].setPrefWidth(100);
                grid.add(labels[i][j], i, j);

            }
        }
        System.out.println(grid.getChildren());


    }

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

