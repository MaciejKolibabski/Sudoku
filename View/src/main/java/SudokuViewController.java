import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.property.adapter.JavaBeanIntegerProperty;
import javafx.beans.property.adapter.JavaBeanIntegerPropertyBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.first.firstjava.FileSudokuBoardDao;
import pl.first.firstjava.SudokuBoard;
import pl.first.firstjava.SudokuField;
import pl.first.firstjava.wyjatki.MyIoeXception;

public class SudokuViewController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(SudokuViewController.class);

    private SudokuBoard board;
    public GridPane grid;
    private List<List<SudokuField>> fields;
    TextField[][] labels = new TextField[9][9];



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
        bindToCurrentFields();
        log.info("WARTOSCI: \n" + board);

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


    private void bindToCurrentFields() {
        class SudokuFieldStringConverter extends IntegerStringConverter {
            @Override
            public String toString(Integer value) {
                if (value == 0) {
                    return "";
                }
                return super.toString(value);
            }
        }

        StringConverter converter = new SudokuFieldStringConverter();

        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                var textField = labels[i][j];
                try {
                    JavaBeanIntegerPropertyBuilder builder =
                            JavaBeanIntegerPropertyBuilder.create();
                    JavaBeanIntegerProperty integerProperty =
                            builder.bean(board.getToBindMethod(i,j)).name("fieldValue").build();
                    textField.textProperty().bindBidirectional(integerProperty, converter);

                    textField.textProperty().addListener((observable, oldValue, newValue) -> {

                        if (!newValue.matches("^\\d$") || newValue.equals("")) {
                            textField.textProperty().set("");
                            return;
                        }

                    });

                } catch (NoSuchMethodException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    public void readfromfile(ActionEvent actionEvent) throws IOException {
        log.info("Odczyt z pliku");
        FileChooser filechoose = new FileChooser();
        File file = filechoose.showOpenDialog(new Stage());
        try {
            FileSudokuBoardDao fileSudokuBoardDao = new FileSudokuBoardDao(file);
            board = fileSudokuBoardDao.read();
        } catch (MyRntExcpt e) {
            e.printStackTrace();
        } catch (MyIoe e) {
            e.printStackTrace();
        }

            //        try (FileInputStream fis = new FileInputStream(file);
            //             ObjectInputStream ois = new ObjectInputStream(fis)) {
            //
            //            var board = (SudokuBoard) ois.readObject();
            //            fields = board.getBoard();

            bindToCurrentFields();

            log.info("Po odczycie " + board);


            TextField[][] labels = new TextField[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (fields.get(j).get(i).getFieldValue() != 0) {
                        labels[i][j] = new TextField(Integer.toString((
                                fields.get(j).get(i).getFieldValue())));
                    } else {
                        labels[i][j] = new TextField("");
                    }

                    labels[i][j].setAlignment(Pos.CENTER);
                    labels[i][j].setPrefHeight(100);
                    labels[i][j].setPrefWidth(100);
                    grid.add(labels[i][j], i, j);

                }
            }

        }


    public void writetofile(ActionEvent actionEvent) throws MyRntExcpt, IOException {

        log.info("Zapis do pliku " + board);
        FileChooser filechoose = new FileChooser();
        File file = filechoose.showSaveDialog(new Stage());

        try {
            FileSudokuBoardDao fileSudokuBoardDao = new FileSudokuBoardDao(file);
            fileSudokuBoardDao.write(board);
        } catch (MyRntExcpt | MyIoe ex) {
            System.out.println("WX");

        }
        //        try (FileOutputStream fos = new FileOutputStream(file);
        //             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
        //
        //            oos.writeObject(board);
        //
        //        } catch (IOException ex) {
        //            System.out.println("IOException");
        //        }
    }


}

