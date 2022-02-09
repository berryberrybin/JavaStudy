package ex0208_문수빈;

//Error 를 수정하고 이유를 주석으로 처리하세요.
final class FinalClassExam { // 상속불가, 생성가능
    final int i = -999999; // 값 변경 불가 - 값을 반드시 초기화 해야 하며, 명시적 초기화(직접 값 넣기) 또는 생성자 이용해서 초기화 가능
    final static int j = 100; // 생성자를 이용해서 초기화 불가능
}


abstract class AbstractClassExam { // 상속가능, 생성불가
    abstract String abstractMethodExam(int i, String s); // 기능이없는 상태, 재정의해서 사용해야 함

    final int finalMethodExam(int i, int j) {
        return i + j;
    } // 재정의 불가
}


// 상속관계에 있을때 superclass가 abstract를 갖고 있으면, 서브클래스에서 abstract메소드를 재정의해야 한다.
class Sample01 extends AbstractClassExam {
    String abstractMethodExam(int i, String s) {
        System.out.println("return " + s + i);
        return s + i;
    }

    /* 메소드 앞에 final이 오면 override(재정의) 불가능
    int finalMethodExam(int i, int j) {
        return i * j;
    }
   */
}

// 클래스 앞에 final이 오면 상속이 불가능
class Sample02 /*extends FinalClassExam*/ {
}


// abstract 메소드 갖고 있으면 클래스는 abstract를 붙여야 한다.
abstract class Sample03 extends AbstractClassExam {
    String abstractMethodExam(int i, String s) {
        return s + i;
    }

    abstract String abstractMethodExam(int i, int j);

    void sampleMethod03() {
        System.out.println("void sampleMethod03() 호출 됨");
    }
}

class AbstractFinalClassTest {
    public static void main(String args[]) {
        // AbstractClassExam ace = new AbstractClassExam(); abstract클래스는 생성불가, new 사용불가
        // FinalClassExam fce = new FinalClassExam(100000); final은 값 변경 불가능
        Sample01 s01 = new Sample01();
        AbstractClassExam aceS01 = new Sample01();
        aceS01.abstractMethodExam(700, "_999");
    }
}
