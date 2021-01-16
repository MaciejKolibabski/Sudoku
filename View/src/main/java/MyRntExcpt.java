public class MyRntExcpt extends RuntimeException {
    public MyRntExcpt(Throwable cause) {
        super(cause);
    }

    public MyRntExcpt(String message) {
        super(message);
    }

    public MyRntExcpt() {
    }
}
