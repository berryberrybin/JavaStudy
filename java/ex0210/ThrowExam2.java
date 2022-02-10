package ex0210;

import java.io.IOException;

class Test2 {
    public void ageCheck(int age) throws IOException {
        if (age <= 0) {
            // IOException은 체크 예외종음
            // 예외처리하지 않으면 컴파일 오류나므로 꼭 예외처리 해줘야 함
            IOException ioe = new IOException("나이는 음수 불가");
            throw ioe;

        } else {
            System.out.println(age + "살 입니다.");
        }
    }
}

public class ThrowExam2 {
    public static void main(String[] args) {
        System.out.println("---------메인 시작-------");
        Test2 t2 = new Test2();
        try {
            t2.ageCheck(-5);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("---------메인 끝-------");
    }
}

