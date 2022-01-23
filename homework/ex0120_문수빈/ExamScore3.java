import java.util.Scanner;

/**
 * 본인이름 : 문수빈
 * 날짜 : 22.01.20
 * 주제 : 성적프로그램 ver3
 *       이름, 국어, 영어, 수학 점수를 사용자에게 입력받아 성적표로 출력
 */
public class ExamScore3 {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);

        String name;
        int koreanScore, englishScore, mathScore;
        int sumScore;
        double avgScore;
        char gradeScore;

        System.out.print("학생의 이름을 입력하세요 > ");
        name = scanner.nextLine();

        System.out.print(name + " 학생의 국어 점수를 입력하세요 >  ");
        koreanScore = scanner.nextInt();
        System.out.print(name + " 학생의 영어 점수를 입력하세요 >  ");
        englishScore = scanner.nextInt();
        System.out.print(name + " 학생의 수학 점수를 입력하세요 >  ");
        mathScore = scanner.nextInt();

        sumScore = (koreanScore+englishScore+mathScore);
        avgScore = sumScore / 3.0;


        if(avgScore>=90){
            gradeScore='A';
        } else if(avgScore>=80){ //  else if(avgScore<=89&&avgScore>=80) : avgScore 이미 윗단계에서 90이하를 걸러져 내려옴
            gradeScore='B';
        } else if(avgScore>=70){
            gradeScore='C';
        } else if(avgScore>=60){
            gradeScore='D';
        } else{
            gradeScore='F';
        }

        System.out.println("---------------성적표---------------------");
        System.out.println("학생 이름 : " + name);
        System.out.println("----------------------------------------");
        System.out.print("국어점수 : " + koreanScore);
        System.out.print("    영어점수 : " + englishScore);
        System.out.print("    수학점수 : " + mathScore + "\n");
        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println("총점 : " + sumScore);
        System.out.println("평균 : " + ((int)(avgScore*100))/100.00);
        System.out.println("학점 : " + gradeScore);

    }
}
