import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import pl.first.firstjava.SudokuBoard;


public class SudokuViewController implements Initializable {
    public BorderPane mainBorderPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GridPane grid = new GridPane();
        SudokuBoard board = new SudokuBoard();
        board.solveGame();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid.add(new Label(String.format("%d ", board.get(i,j))), i, j);
            }
        }
        mainBorderPane.getChildren().add(grid);
    }
}
