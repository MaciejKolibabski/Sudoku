package pl.first.firstjava;

import java.io.IOException;


public interface Dao<T> extends AutoCloseable {
    T read() throws ClassNotFoundException, IOException;

    void write(T obj) throws Exception;

}
