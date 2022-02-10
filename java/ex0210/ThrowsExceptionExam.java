package ex0210;

public class ThrowsExceptionExam {
    public void aa(int i) {
        System.out.println("aa메소드 호출");
        try {
            this.bb(i);
        } catch (ArithmeticException e) {
            System.out.println("예외 발생했다");
        }
        System.out.println("aa메소드 완료");
    }

    public void bb(int i) throws ArithmeticException {
        System.out.println("bb메소드 호출");
        try {
            int result = 100 / i;
            System.out.println("나눈결과 :" + result);
        } finally {
            System.out.println("bb메소드 호출 완료됨");
        }
    }

    public static void main(String[] args) {
        System.out.println("-------------메인 시작합니다----------");
        ThrowsExceptionExam te = new ThrowsExceptionExam();
        //te.aa(2);
        try {
            te.aa(0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        System.out.println("------메인 끝 ---------");
    }
}
