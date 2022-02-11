package ex0210.mvc;

//모델 번호가 중복일때 처리할 예외 클래스
public class DuplicateException extends Exception {
    public DuplicateException() {
    }

    public DuplicateException(String message) {
        super(message);
    }
}
