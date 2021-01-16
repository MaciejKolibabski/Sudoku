package pl.first.firstjava;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileSudokuBoardDao<T> implements Dao<T> {

    private final File file;

    public FileSudokuBoardDao(File file) {
        this.file = file;
    }


    @Override
    public T read() throws ClassNotFoundException, IOException {
        try (var fileIn = new FileInputStream(file);
             var objOut = new ObjectInputStream(fileIn)) {
            T object = (T) objOut.readObject();
            return object;
        }
    }

    @Override
    public void write(T obj) throws Exception {
        try (var fileOut = new FileOutputStream(file);
             var objOut = new ObjectOutputStream(fileOut)) {
            objOut.writeObject(obj);
        }
    }







    //    @Override
    //    public SudokuBoard read() {
    //        SudokuBoard obj = null;
    //        try (ObjectInputStream objectInputStream =
    //                     new ObjectInputStream(new FileInputStream(this.fileName))) {
    //            obj = (SudokuBoard) objectInputStream.readObject();
    //            return obj;
    //        } catch (ClassNotFoundException | IOException e) {
    //            throw new RuntimeException(e);
    //        }
    //
    //    }
    //
    //    @Override
    //    public void write(SudokuBoard obj) {
    //        try (ObjectOutputStream objectOutputStream =
    //                     new ObjectOutputStream(new FileOutputStream(this.fileName))) {
    //            objectOutputStream.writeObject(obj);
    //        } catch (IOException e) {
    //            throw new RuntimeException(e);
    //        }
    //    }



    @Override
    public void close() throws Exception {
    }

}