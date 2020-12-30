import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.first.firstjava.SudokuBoard;
import pl.first.firstjava.SudokuField;
import pl.first.firstjava.SudokuSolver;

public class MainViewController implements Initializable {

    @FXML
    public Button trudnyBtn;
    public Button sredniBtn;
    public Button latwyBtn;
    public SudokuBoard board;
    public List<List<SudokuField>> fields;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public Stage applyLatwy(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SudokuView.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(loader.load()));
        SudokuViewController controller = loader.getController();
        controller.showSudoku(20);
        stage.show();
        return stage;

    }

    public Stage applySredni(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SudokuView.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(loader.load()));
        SudokuViewController controller = loader.getController();
        controller.showSudoku(35);
        stage.show();
        return stage;

    }

    public Stage applyTrudny(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SudokuView.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(loader.load()));
        SudokuViewController controller = loader.getController();
        controller.showSudoku(60);
        stage.show();
        return stage;
    }


}