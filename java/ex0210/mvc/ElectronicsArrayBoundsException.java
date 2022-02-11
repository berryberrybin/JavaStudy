package ex0210.mvc;

//모델 번호가 중복일때 처리할 예외 클래스
public class ElectronicsArrayBoundsException extends Exception {
    public ElectronicsArrayBoundsException() {
    }

    public ElectronicsArrayBoundsException(String message) {
        super(message);
    }
}
