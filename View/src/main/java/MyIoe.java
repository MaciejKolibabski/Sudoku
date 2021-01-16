import java.io.IOException;


public class MyIoe extends IOException {
    public MyIoe(Throwable cause) {
        super(cause);
    }

    public MyIoe(String message) {
        super(message);
    }

    public MyIoe() {
    }
}
