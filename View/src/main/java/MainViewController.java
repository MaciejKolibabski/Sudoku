import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainViewController implements Initializable {

    @FXML
    public Button trudnyBtn;
    public Button sredniBtn;
    public Button latwyBtn;

    public Stage applyLatwy(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SudokuView.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(loader.load())
        );
        SudokuViewController controller = loader.getController();
        stage.show();
        return stage;

    }

    public Stage applySredni(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SudokuView.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
        new Scene(loader.load())
        );
        SudokuViewController controller = loader.getController();
        stage.show();
        return stage;
    }

    public Stage applyTrudny(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SudokuView.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(loader.load())
        );
        SudokuViewController controller = loader.getController();
        stage.show();
        return stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    }
