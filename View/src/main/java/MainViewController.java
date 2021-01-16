import java.io.IOException;
import java.net.URL;
import java.util.Locale;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class MainViewController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(MainViewController.class);

    @FXML
    public Button trudnyBtn;
    public Button sredniBtn;
    public Button latwyBtn;
    public Button authorBtn;
    private Stage primaryStage;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public Stage applyLatwy(ActionEvent actionEvent) throws IOException {

        log.info("Wybrales poziom latwy");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SudokuView.fxml"));
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
        loader.setResources(bundle);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(loader.load()));
        SudokuViewController controller = loader.getController();
        controller.showSudoku(20);
        stage.show();
        return stage;

    }

    public Stage applySredni(ActionEvent actionEvent) throws IOException {
        log.info("Wybrales poziom sredni");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SudokuView.fxml"));;
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
        loader.setResources(bundle);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(loader.load()));
        SudokuViewController controller = loader.getController();
        controller.showSudoku(35);
        stage.show();
        return stage;

    }

    public Stage applyTrudny(ActionEvent actionEvent) throws IOException {
        log.info("Wybrales poziom trudny");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SudokuView.fxml"));
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
        loader.setResources(bundle);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(loader.load()));
        SudokuViewController controller = loader.getController();
        controller.showSudoku(60);
        stage.show();
        return stage;
    }

    public void initData(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void openAgainStage() throws IOException {
        primaryStage.close();
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"), bundle);
        Stage stage = new Stage(StageStyle.DECORATED);
        Parent root = loader.load();
        stage.setScene(new Scene(root, 700,700));
        MainViewController controller = loader.getController();
        controller.initData(stage);
        stage.show();
    }

    public void englishlanguage(ActionEvent actionEvent) throws IOException {
        log.info("Wersja angielska");

        Locale.setDefault(new Locale("en"));
        openAgainStage();

    }

    public void polishlanguage(ActionEvent actionEvent) throws IOException {
        log.info("Wersja polska");

        Locale.setDefault(new Locale("pl"));
        openAgainStage();
    }


    public Stage showAuthors(ActionEvent actionEvent) throws IOException {
        log.info("Pokazanie autorow");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AuthorsView.fxml"));;
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
        loader.setResources(bundle);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(loader.load()));
        stage.show();
        return stage;
    }

}