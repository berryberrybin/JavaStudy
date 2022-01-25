package ex0124;

class Exam {
    int a;
    static int b;

    public void aa() {
        System.out.println(a);
        System.out.println(this.a);
        System.out.println(b);
        System.out.println(this.b);
        String s = Integer.toString(20);
    }

    public static void cc() { // static 메소드 안에서는 static만 접근가능, this 사용 불가
        // System.out.println(a);
        // System.out.println(this.a);

        System.out.println(b);
        // System.out.println(this.b);
        System.out.println(Exam.b); // static은 변수명보다는 "클래스이름.변수명" 으로 사용시 더 명확하다.
    }

    public void bb() {
        aa();
        this.aa();
        dd();
        this.dd();
        Exam.dd();
    }

    public static void dd() {
        // aa();
        // this.aa();
        cc();
        // this.cc();
        Exam.cc();

    }

}

public class StaticExam {
    public void test() {

    }

    public static void main(String[] args) {
        StaticExam se = new StaticExam();
        se.test();
    }
}
