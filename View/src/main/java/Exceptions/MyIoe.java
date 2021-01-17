package Exceptions;

import java.io.IOException;


public class MyIoe extends IOException {

    public MyIoe() {
    }

    public MyIoe(Throwable cause) {
        super(cause);
    }

    public MyIoe(String message) {
        super(message);
    }

}
