package ex0127;

import java.util.Scanner;

public class Chapter5Ex9 {
    public static void main(String[] args) {
        boolean run = true;
        int studentNum = 0;
        int[] scores = null;
        Scanner scanner = new Scanner(System.in);

        while (run) {
            System.out.println("--------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석  |5. 종료");
            System.out.println("--------------------------------------------------");
            System.out.print("선택> ");
            int selectNo = scanner.nextInt();

            if (selectNo == 1) {
                System.out.print("학생수> ");
                int studentNumber = scanner.nextInt();
                scores = new int[3];
            } else if (selectNo == 2) {
                System.out.print("score[0]> ");
                scores[0] =scanner.nextInt();
                System.out.print("score[1]> ");
                scores[1] = scanner.nextInt();
                System.out.print("score[2]> ");
                scores[2] = scanner.nextInt();
            } else if (selectNo == 3) {
                for (int i = 0; i < scores.length; i++) {
                    System.out.println("scores[" + i + "]: " + scores[i]);
                }
            } else if (selectNo == 4) {
                int sum = 0;
                int max = 0;
                for (int i = 0; i < scores.length; i++) {
                    sum = sum + scores[i];
                    if (scores[i] > max) {
                        max = scores[i];
                    }
                }
                System.out.println("최고점수: " + max);
                System.out.println("평균점수: " + (sum / (double) scores.length));
            } else if (selectNo == 5) {
                run = false;
            }
        }
    }
}
