/**
 * 본인이름 : 문수빈
 * 날짜 : 22.01.20
 * 주제 : while문과 Math.random()메소드 이용
 *      2개의 주사위 던졌을때 나오는 눈을 (눈1, 눈2)형태로 출력
 *      눈의 합이 5가 아니면 계속 주사위 던지고, 눈의 합이 5이면 실행 멈춤
 */

public class Chapter04_Answer4 {
    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 0;
        while (num1 + num2 != 5) {
            num1 = (int) (Math.random() * 6) + 1;
            num2 = (int) (Math.random() * 6) + 1;
            System.out.println("(" + num1 + "," + num2 + ")");
        }

    }
}
