import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.first.firstjava.SudokuBoard;
import pl.first.firstjava.SudokuField;


public class SudokuViewController implements Initializable {
    private SudokuBoard board;
    public GridPane grid;
    private List<List<SudokuField>> fields;




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




    public void readfromfile(ActionEvent actionEvent) {
        FileChooser filechoose = new FileChooser();
        File file = filechoose.showOpenDialog(new Stage());

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            var board = (SudokuBoard) ois.readObject();
            fields = board.getBoard();
            System.out.println("Po odczycie " + board);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("IOException is caught");
        }

        TextField[][] labels = new TextField[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (fields.get(j).get(i).getFieldValue()!= 0) {
                    labels[i][j] = new TextField(Integer.toString((fields.get(j).get(i).getFieldValue())));
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




    public void writetofile(ActionEvent actionEvent) {
        System.out.println("Zapis " + board);

        FileChooser filechoose = new FileChooser();
        File file = filechoose.showSaveDialog(new Stage());

        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(board);

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

    }


    public Stage aktualizuj(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SudokuView.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(loader.load()));
        System.out.println(board);
        stage.show();
        return stage;

    }
}

