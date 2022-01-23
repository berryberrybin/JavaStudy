import java.util.Scanner;

/**
 * 본인이름 : 문수빈
 * 날짜 : 22.01.21
 * 주제 : 계산기 만들기 V2
 *       - execute() : 메뉴 실행 메소드  (메뉴에 따라 기능 수행 포함)
 *          - choiceMenu() : 사용자에게 메뉴를 입력받는 메소드
 *          - inputValue() : 2개의 정수를 사용자에게 입력받는 메소드
 */


public class CalculatorV2 {
    private Scanner sc = new Scanner(System.in);

    private int a;
    private int b;
    private String symbol;

    private void execute() {
        while (true) {
            System.out.println("===============  메    뉴  ===============");
            System.out.println("1.더하기   2.빼기   3.곱하기   4.나누기   9.종료");

            int menu = choiceMenu();
            if (menu == 9) {
                break;
            } else if (menu == 1) {
                symbol = "+";
            } else if (menu == 2) {
                symbol = "-";
            } else if (menu == 3) {
                symbol = "*";
            } else if (menu == 4) {
                symbol = "/";
            }
            inputValue();
            Calculation.calculate(symbol, a, b);
        }
        System.out.println("------ 프로그램이 종료되었습니다 ------");

    }

    private int choiceMenu() {
        while (true) {
            System.out.print("메뉴 선택 > ");
            int menu = Integer.parseInt(sc.nextLine());
            if (menu >= 1 && menu <= 4) { // 유효한 메뉴
                return menu;
            } else if (menu == 9) { // 종료 메뉴
                return menu;
            } else {
                System.out.println("메뉴를 잘못 입력하였습니다.");
            }
        }
    }

    private void inputValue() {
        System.out.print("   값 1 : ");
        a = Integer.parseInt(sc.nextLine());

        System.out.print("   값 2 : ");
        b = Integer.parseInt(sc.nextLine());
    }

    public static void main(String[] args) {
        CalculatorV2 v2 = new CalculatorV2();
        v2.execute();
    }

}
