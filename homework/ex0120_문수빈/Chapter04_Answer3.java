/**
 * 본인이름 : 문수빈
 * 날짜 : 22.01.20
 * 주제 : for문 이용, 1~100까지 정수중 3의 배수 총합
 */
public class Chapter04_Answer3 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 3 == 0) {
                sum = sum + i;
            }

        }
        System.out.println("3의 배수의 합: " + sum);
    }
}
