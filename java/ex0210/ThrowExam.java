package ex0210;

class Test {
    public void ageCheck(int age) {
        if (age <= 0) {
            //RuntimeException은 비체크 예외종류로 컴파일은 됨
            // 예외처리를 선택적으로 할 수 있음
            RuntimeException re = new RuntimeException("나이는 음수 불가");
            throw re;
        } else {
            System.out.println(age + "살 입니다.");
        }
    }
}

public class ThrowExam {
    public static void main(String[] args) {
        System.out.println("---------메인 시작-------");
        Test t = new Test();
        t.ageCheck(-5);
        System.out.println("---------메인 끝-------");
    }
}
