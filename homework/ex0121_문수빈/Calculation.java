/**
 * 본인이름 : 문수빈
 * 날짜 : 22.01.21
 * 주제 : 계산기 만들기 V1
 *       사칙연산하는 메소드
 *          - plus()  : 더하기 메소드
 *          - minus() : 빼기 메소드
 *          - multiplication() : 곱하기 메소드
 *          - division() : 나누기 메소드
 *       - calculate()
 *              : 2개의 정수와 사칙연산기호 1개를 인자로 받음
 *                사칙연산 기호에 맞게 사칙연산 메소드 호출 및 출력
 */

public class Calculation {
    private static int plus(int a, int b) {
        return a + b;
    }

    private static int minus(int a, int b) {
        return a - b;
    }

    private static int multiplication(int a, int b) {
        return a * b;
    }

    private static double division(int a, int b) {
        return a / (b * 1.0);
    }

    public static void calculate(String symbol, int a, int b) {

        System.out.print("[ 결과 ] " + a + " " + symbol + " " + b + " = ");

        if (symbol.equals("+")) {
            System.out.println(plus(a, b));
        } else if (symbol.equals("-")) {
            System.out.println(minus(a, b));
        } else if (symbol.equals("*")) {
            System.out.println(multiplication(a, b));
        } else if (symbol.equals("/")) {
            System.out.println(division(a, b));
        } else {
            System.out.println("에러 발생");
        }
    }
}
