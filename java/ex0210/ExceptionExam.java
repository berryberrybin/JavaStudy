package ex0210;

public class ExceptionExam {
    public static void main(String[] args) {
        System.out.println("-------메인시작-------");

        try {
            String data = args[0]; // ArrayIndexofBoundsException
            System.out.println("data = " + data);

            int no = Integer.parseInt(data);
            System.out.println("숫자로 변환 : " + no);

            int result = 100 / no;
            System.out.println("나눈 결과" + result);
        } catch (ArrayIndexOutOfBoundsException e) { // e는 변수 : 예외 관련된 정보를 갖고 있는 레퍼런스 변수
            // 예외가 발생했을때 해야 할 일 작성
            System.out.println("실행할 때 값을 전달하지 않았습니다.");
            System.out.println(("e = " + e)); // e.toString()호출 - 예외 클래스이름: 예외 메시지

            //2가지 에외처리가 하는 일이 동일할 때 "|" 이용
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("숫자만 입력해주세요");
            System.out.println("예외메시지 :" + e.getMessage());

        } catch (Exception e) {
            //오류의 정보가 가장 detail하게 나오고 오류정보를 추적할때 사용한다
            // (개발할때는 많이 사용하지만 배포할때는 모두 삭제 필수, 보안 문제)
            System.out.println("예외가 발생함");
            e.printStackTrace(); // 발생한 예외의 정보를 stack영역에 쌓아놓았다가 한번에 출력함

        } finally {
            // finally는 예외발생 여부 상관 없이 무조건 실행됨
            System.out.println("-------메인 끝-------");
        }
    }
}
