package ex0209;

//이 소스를 컴파일이 되도록 수정/추가/주석처리 하세요.
interface InterfaceExam00 {
    abstract void interfaceExam00();
}


interface InterfaceExam01 extends InterfaceExam00 {
    final int i = 767;
    /*protected*/ int k = 999; // interface의 모든 변수는 public static final(상수)
    // int z ; 상수타입이므로 무조건 명시적초기화 해야 하므로 int z = 100;이렇게 사용해야 함

    void interfaceExam01(int i, int k);
}


interface InterfaceExam02 {
    int j = 747;
    /*private*/ int privateInt = 8;

    /*private*/ void interfaceExam02(int j); // interface 모든 메소드는 public abstract이다.

    // public default void interfaceExam03(int j){}
    // 1.8부터 default 생겨서 {} 빈 메소드 작성가능해짐
}


class SuperClassExam {
    String superString = "Super";

    String superMethod() {
        System.out.println("SuperClassExam.SuperMethod()가 호출되었습니다.");
        return "returnString";
    }
}

//class SubClassExam01 extends SuperClassExam, InterfaceExam01 {
// 다중상속 불가능해서 extends일 경우 ,(컴마) 사용 불가능, implements 해야 함
// implements 하면 interface에 있는 모든 method 재정의 해야 함
class SubClassExam01 extends SuperClassExam implements InterfaceExam01 {
    @Override
    public void interfaceExam01(int i, int k) {
        // public 꼭 앞에 붙여 주어야 함
        // 슈퍼 interface에서 public이 생략 되어 있는 거므로 더 강한 default 제한자 사용 불가)
    }

    @Override
    public void interfaceExam00() {
        // public 꼭 앞에 붙여 주어야 함
    }
}


class SubClassExam02 extends SuperClassExam
        implements InterfaceExam01, InterfaceExam02 {


    @Override
    public void interfaceExam00() {

    }

    @Override
    public void interfaceExam01(int i, int k) {

    }

    @Override
    public void interfaceExam02(int j) {

    }
}


//abstract class SubClassExam03 implements SuperClassExam, InterfaceExam01, InterfaceExam02 {
abstract class SubClassExam03 extends SuperClassExam implements InterfaceExam01, InterfaceExam02 {
}


class SubClassExam04 extends SubClassExam02 {
    //여기에 필요한 것들을 추가하여 문제를 해결하세요..
    public void interfaceExam00() {
    }

    public void interfaceExam01(int i, int k) {
    }

    public void interfaceExam02(int j) {
    }

    SubClassExam04() {
        System.out.println("subClassExam04() 객체 생성");
        System.out.println(" i = " + i);
        System.out.println(" j = " + j);
    }

    SubClassExam04(String s1, String s2) {
        System.out.println(s1 + " 타입 " + "subClassExam04(" + s2 + ") 객체 생성");

    }

    void printSuperString() {
        InterfaceExam01 ie01 /* = new InterfaceExam01()*/;
        // interface는 생성할 수 없음

        System.out.println(" superString = " + superString);
    }
}

//여기서부터는 하나도 고치지 마시고 그대로 쓰면 됩니다.
public class ImplementsInterfaceExam {
    public static void main(String args[]) {
        SubClassExam02 sub02sub04 = new SubClassExam04("SubClassExam02", "sub02sub04");
        SuperClassExam superSub04 = new SubClassExam04("SuperClassExam", "superSub04");
        InterfaceExam01 ifc01Sub04 = new SubClassExam04("InterfaceExam01", "ifc01Sub04");
        SubClassExam04 sub04 = new SubClassExam04();
        sub04.interfaceExam00();
        sub04.interfaceExam01(1, 7);
        sub04.superMethod();
    }
}

