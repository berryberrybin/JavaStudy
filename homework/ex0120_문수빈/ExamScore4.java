import java.util.Scanner;

/**
 * 본인이름 : 문수빈
 * 날짜 : 22.01.20
 * 주제 : 성적프로그램 ver4
 * 메뉴 생성 : 1. 성적표  2.종료
 */
public class ExamScore4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name;
        int koreanScore, englishScore, mathScore;
        int sumScore;
        double avgScore;
        char gradeScore;
        boolean run = true;

        while (run) {
            System.out.println("------------메뉴------------");
            System.out.println("   1. 성적표     2. 종료     ");
            System.out.println("---------------------------");
            System.out.print("메뉴 선택 >  ");
            int menuNum = Integer.parseInt(scanner.nextLine());
            if (menuNum == 1) {
                System.out.print("학생의 이름을 입력하세요 > ");
                name = scanner.nextLine();

                System.out.print(name + " 학생의 국어 점수를 입력하세요 >  ");
                koreanScore = Integer.parseInt(scanner.nextLine());
                System.out.print(name + " 학생의 영어 점수를 입력하세요 >  ");
                englishScore = Integer.parseInt(scanner.nextLine());
                System.out.print(name + " 학생의 수학 점수를 입력하세요 >  ");
                mathScore = Integer.parseInt(scanner.nextLine());

                sumScore = (koreanScore + englishScore + mathScore);
                avgScore = sumScore / 3.0;


                if (avgScore >= 90) {
                    gradeScore = 'A';
                } else if (avgScore >= 80) {
                    gradeScore = 'B';
                } else if (avgScore >= 70) {
                    gradeScore = 'C';
                } else if (avgScore >= 60) {
                    gradeScore = 'D';
                } else {
                    gradeScore = 'F';
                }

                System.out.println("---------------성적표-----------------------");
                System.out.println("           학생 이름 : " + name);
                System.out.println("------------------------------------------");
                System.out.print("국어점수 : " + koreanScore);
                System.out.print("    영어점수 : " + englishScore);
                System.out.print("    수학점수 : " + mathScore + "\n");
                System.out.println("------------------------------------------");
                System.out.println("  총점 : " + sumScore);
                System.out.println("  평균 : " + ((int) (avgScore * 100)) / 100.00);
                System.out.println("  학점 : " + gradeScore);

                System.out.println("** 메뉴로 돌아갑니다 **");

            } else if (menuNum == 2) {
                run = false;
            } else {
                System.out.println("잘못 입력하였습니다.");
            }

        }
        System.out.println("** 프로그램이 종료되었습니다. **");


    }


}
