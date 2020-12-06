import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    public Button trudnyBtn;
    public Button sredniBtn;
    public Button latwyBtn;

    public void applyLatwy(ActionEvent actionEvent) throws IOException {

        System.out.println("ŁATWY");
        Parent root = FXMLLoader.load(getClass().getResource("/SudokuView.fxml"));

    }

    public void applySredni(ActionEvent actionEvent) {
        System.out.println("ŚREDNI");

    }

    public void applyTrudny(ActionEvent actionEvent) {
        System.out.println("TRUDNY");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
