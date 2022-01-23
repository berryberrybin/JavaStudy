/**
 * 본인이름 : 문수빈
 * 날짜 : 22.01.21
 * 주제 : 성적프로그램 ver5
 *       클래스 및 메소드 만들기 - 성적 구하는 기능을 담당하는 클래스
 */
public class ExamScore5 {
    private int calculateSum(int koreanScore, int englishScore, int mathScore) {
        int sum = koreanScore + englishScore + mathScore;
        return sum;
    }

    private double calculateAvg(int sum, int subjectNumber) {
        double avg = sum / (subjectNumber * 1.0);
        avg = ((int) (avg * 100)) / 100.00;
        return avg;
    }

    private char calculateGrade(double avg) {
        char grade;
        if (avg >= 90) {
            grade = 'A';
        } else if (avg >= 80) {
            grade = 'B';
        } else if (avg >= 70) {
            grade = 'C';
        } else if (avg >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        return grade;
    }

    public void printExamScore(String name, int koreanScore, int englishScore, int mathScore) {
        int sumOfStudentScores = calculateSum(koreanScore, englishScore, mathScore);
        double avgOfStudentScores = calculateAvg(sumOfStudentScores, 3);
        char gradeOfStudentScores = calculateGrade(avgOfStudentScores);

        System.out.println("---------------성적표-----------------------");
        System.out.println("           학생 이름 : " + name);
        System.out.println("------------------------------------------");
        System.out.println("국어점수 : " + koreanScore + "    영어점수 : " + englishScore + "    수학점수 : " + mathScore);
        System.out.println("------------------------------------------");
        System.out.println("  총점 : " + sumOfStudentScores);
        System.out.println("  평균 : " + avgOfStudentScores);
        System.out.println("  학점 : " + gradeOfStudentScores);
    }

}
