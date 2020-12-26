import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.first.firstjava.BacktrackingSudokuSolver;
import pl.first.firstjava.SudokuBoard;
import pl.first.firstjava.SudokuField;


public class SudokuViewController implements Initializable {
    private SudokuBoard board;
    public GridPane grid;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GridPane grid = new GridPane();
        SudokuBoard board = new SudokuBoard();
        board.solveGame();

    }


    SudokuBoard initBoard() {


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


    public void loadSudokuBoard() {
        initBoard();


        Label[][] labels = new Label[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.get(i, j) != 0) {
                    labels[i][j] = new Label(Integer.toString(board.get(i, j)));
                } else {
                    labels[i][j] = new Label("");
                }

                labels[i][j].setAlignment(Pos.CENTER);
                labels[i][j].setPrefHeight(100);
                labels[i][j].setPrefWidth(100);
                labels[i][j].setTextAlignment(TextAlignment.CENTER);
                grid.add(labels[i][j], i, j);
            }
        }
        System.out.println(grid.getChildren());


    }
}




