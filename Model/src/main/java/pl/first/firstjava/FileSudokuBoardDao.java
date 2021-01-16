package pl.first.firstjava;

import pl.first.firstjava.wyjatki.MyIOEXception;
import pl.first.firstjava.wyjatki.MyRntEXC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileSudokuBoardDao implements Dao<SudokuBoard> {

    private final File fileName;

    public FileSudokuBoardDao(File fileName) {
        this.fileName = fileName;
    }


        @Override
        public SudokuBoard read() throws IOException {
            SudokuBoard obj = null;
            try (ObjectInputStream objectInputStream =
                         new ObjectInputStream(new FileInputStream(this.fileName))) {
                obj = (SudokuBoard) objectInputStream.readObject();
                return obj;
            } catch (ClassNotFoundException | MyIOEXception e) {
                throw new MyRntEXC(e);
            }

        }



        @Override
        public void write(SudokuBoard obj) throws IOException {
            try (ObjectOutputStream outputStream =
                         new ObjectOutputStream(new FileOutputStream(this.fileName))) {
                outputStream.writeObject(obj);
            } catch (MyIOEXception e) {
                throw new MyRntEXC(e);
            }
        }



    @Override
    public void close() throws Exception {
    }

}