package pl.first.firstjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.RuntimeException;


public class FileSudokuBoardDao implements Dao<SudokuBoard> {

    private final String fileName;

    public FileSudokuBoardDao(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public SudokuBoard read() {
        SudokuBoard obj = null;
        try (ObjectInputStream objectInputStream =
                     new ObjectInputStream(new FileInputStream(this.fileName))) {
            obj = (SudokuBoard) objectInputStream.readObject();
            return obj;
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void write(SudokuBoard obj) {
        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream(this.fileName))) {
            objectOutputStream.writeObject(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    @Override
    //    protected void finalize() throws Throwable {
    //        super.finalize();
    //    }

    @Override
    public void close() throws Exception {
    }

}