import java.util.Scanner;

/**
 * 본인이름 : 문수빈
 * 날짜 : 22.01.21
 * 주제 : 계산기 만들기 V1
 *       - inputValue() : 2개의 정수와 사칙연산 기호를 사용자에게 입력받는 메소드
 *       - checkSymbol() : 사칙연산 기호 (+, -, *, /) 4가지 중 한가지가 알맞게 들어왔는지 체크 메소드
 */

public class CalculatorV1 {
    private Scanner sc = new Scanner(System.in);

    private int a;
    private int b;
    private String symbol;

    private void inputValue() {
        System.out.print("값 1 : ");
        a = Integer.parseInt(sc.nextLine());

        boolean isValidSymbol;
        do {
            System.out.print("사칙연산 기호 : ");
            symbol = sc.nextLine();
            isValidSymbol = checkSymbol(symbol);
        } while (!isValidSymbol);

        System.out.print("값 2 : ");
        b = Integer.parseInt(sc.nextLine());

    }

    private boolean checkSymbol(String symbol) {
        switch (symbol) {
            case "+":
            case "-":
            case "/":
            case "*":
                return true;
            default:
                System.out.println("  연산기호가 잘못되었습니다.  ");
                return false;
        }
    }


    public static void main(String[] args) {
        CalculatorV1 v1 = new CalculatorV1();

        v1.inputValue();
        System.out.println();
        Calculation.calculate(v1.symbol, v1.a, v1.b);
        System.out.println("---------- 계산 완료 -----------");
    }

}
