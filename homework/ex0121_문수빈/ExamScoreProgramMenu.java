import java.util.Scanner;

/**
 * 본인이름 : 문수빈
 * 날짜 : 22.01.21
 * 주제 : 성적프로그램 ver5
 *       클래스 및 메소드 만들기 - 화면에 출력 및 입력받는 기능을 하는 클래스
 */

public class ExamScoreProgramMenu {
    private Scanner scanner = new Scanner(System.in);

    public void runExamScoreMenu() {
        boolean run = true;
        while (run) {
            printMenu();
            int menuNum = Integer.parseInt(scanner.nextLine());

            if (menuNum == 1) {
                inputStudentInformation();
                System.out.println();
                System.out.println();
                System.out.println("** 메뉴로 돌아갑니다 **");
            } else if (menuNum == 2) {
                run = false;
            } else {
                System.out.println("** 잘못 입력하였습니다. **");
            }
        }
        System.out.println("** 프로그램이 종료되었습니다. **");
    }

    private void printMenu() {
        System.out.println("------------메뉴------------");
        System.out.println("   1. 성적표     2. 종료     ");
        System.out.println("---------------------------");
        System.out.print("메뉴 선택 >  ");
    }

    private void inputStudentInformation() {
        System.out.print("학생의 이름을 입력하세요 > ");
        String name = scanner.nextLine();

        System.out.print(name + " 학생의 국어 점수를 입력하세요 >  ");
        int koreanScore = Integer.parseInt(scanner.nextLine());
        System.out.print(name + " 학생의 영어 점수를 입력하세요 >  ");
        int englishScore = Integer.parseInt(scanner.nextLine());
        System.out.print(name + " 학생의 수학 점수를 입력하세요 >  ");
        int mathScore = Integer.parseInt(scanner.nextLine());

        System.out.println();
        ExamScore5 ts5 = new ExamScore5();
        ts5.printExamScore(name, koreanScore, englishScore, mathScore);
    }


    public static void main(String[] args) {
        ExamScoreProgramMenu t = new ExamScoreProgramMenu();
        t.runExamScoreMenu();
    }
}
