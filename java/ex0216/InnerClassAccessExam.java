package ex0216;

// Inner클래스는 선언위치와 선언 방법 에 따라 3가지 형태가 존재한다.

class Test { //Outer클래스 역할
    int a = 50;
    static int b = 100;

    public void aa() {
    }

    public static void bb() {
    }

    /**
     * 1) 인스턴스 멤버 클래스
     * 클래스 앞에 access Modifier 4가지 모두 가능
     * non-static 선언 가능하지만, static 선언 안됨
     * 접근=호출은 non-static과 static 둘다 가능
     */
    class InstanceInner {
        int a = 10;

        // static int c = 5;  에러 발생
        // public static void test2() { }에러 발생
        public void test1() {
            System.out.println(a); // 10
            System.out.println(this.a); // 10
            System.out.println(Test.this.a); // 50
            System.out.println(b); //100
            aa();
            bb();
        }
    }

    /**
     * 2) 정적(static)멤버 클래스
     * 클래스 앞에 access modifier 4가지 모두 가능
     * non-static, static 선언 모두 가능
     * outer의 non-static 접근 불가, static만 접근 가능
     */
    static class StaticInner {
        int a = 10;
        static int c = 4;

        public void test2() {
            System.out.println(a); // 10
            System.out.println(this.a); // 10
            // System.out.println(Test.this.a); non-static 접근 불가
            System.out.println(b);//100
            // System.out.println(this.b); StaticInner 클래스 안에 b가 없어서 호출 불가
            //System.out.println(Test.this.b); this로 접근 불가
            System.out.println(Test.b); //클래스이름.변수 이름으로 접근 가능

            //aa(); non-static은 접근 불가
            bb(); // 접근 가능

        }

    }

    /**
     * 3) 로컬(메소드 내부에서 선언된) 클래스
     * 접근제한자, static은 클래스 앞에 올 수 없음
     */
    public void localInnerTest() {
        System.out.println("------local Inner Test()메소드입니다.--------");
        class LocalInner {
            int a = 7;

            public void test() {
                System.out.println("LocalInner 안에 test()메소드 입니다.");
            }
        }
        LocalInner local = new LocalInner();
        local.test();
    }
}


public class InnerClassAccessExam {
    public static void main(String[] args) {
        System.out.println("--------1)인스턴스 멤버 클래스----------");
        Test t = new Test();
        Test.InstanceInner testInstance = t.new InstanceInner();
        testInstance.test1();

        System.out.println("--------2) static 멤버 클래스----------");
        Test.StaticInner staticInnerInstance = new Test.StaticInner();
        staticInnerInstance.test2();

        System.out.println("--------3) 로컬(메소드 내부에서 선언된) 클래슴----------");
        t.localInnerTest();

    }
}
