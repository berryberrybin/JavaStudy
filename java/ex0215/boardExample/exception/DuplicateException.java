package ex0215.boardExample.exception;

public class DuplicateException extends Throwable {
    public DuplicateException() {
    }

    public DuplicateException(String message) {
        super(message);
    }
}
