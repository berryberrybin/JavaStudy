import java.util.Scanner;

/**
 * 본인이름 : 문수빈
 * 날짜 : 22.01.20
 * 주제 : while문과 Scanner를 이용하여 키보드로 부터 입력된 데이터로 예금, 출금, 조회, 종료기능을 제공하는 코드 작성
 */

public class Chapter04_Answer7 {
    public static void main(String[] args) {
        boolean run = true;
        int balance = 0;
        Scanner scanner = new Scanner(System.in);


        while (run) {
            System.out.println("----------------------------------");
            System.out.println(" 1.예금  / 2.출금  /  3.잔고  /  4.종료 ");
            System.out.println("----------------------------------");
            System.out.print("선택> ");
            int choiceNumber = scanner.nextInt();

            switch (choiceNumber) {
                case 1:
                    System.out.print("예금액> ");
                    int depositAmount = scanner.nextInt();
                    balance = balance + depositAmount;
                    break;
                case 2:
                    System.out.print("출금액> ");
                    int withdrawalAmount = scanner.nextInt();
                    balance = balance - withdrawalAmount;
                    break;
                case 3:
                    System.out.print("잔고> ");
                    System.out.println(balance);
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    System.out.println("잘못 입력하였습니다.");
            }
        }
        System.out.println("프로그램 종료");
    }
}
