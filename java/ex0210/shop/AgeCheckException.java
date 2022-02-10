package ex0210.shop;

public class AgeCheckException extends Exception {
    static int count;

    public AgeCheckException() {
    }

    public AgeCheckException(String message) {
        super(message);
        count++;
    }
}
