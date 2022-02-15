package ex0215.boardExample.exception;

public class InexistentException extends Throwable {
    public InexistentException() {
    }

    public InexistentException(String message) {
        super(message);
    }
}
