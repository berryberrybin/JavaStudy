package ex0207;

//MethodOverridingExam.java
//이 class는 수정하지 마세요.
class SuperClass {
    protected int intNumber;
    protected String memberString = "Sting in SuperClass";

    SuperClass() {
        System.out.println("생성자 SuperClass()가 호출되었습니다.");
    }

    public void methodZero() {
        System.out.println("SuperClass객체의 methodZero()메소드가 호출되었습니다.");
        System.out.println("intNumber=" + intNumber + "\t" + "memberString=" + memberString);
    }

    protected void methodOwn() {
        System.out.println("SuperClass객체의 methodOwn()메소드가 호출되었습니다.");
        System.out.println("intNumber=" + intNumber + "\t" + "memberString=" + memberString);
    }

    int methodTwo(int i) {
        intNumber = i;
        System.out.println("SuperClass객체의 methodTwo(int i)메소드가 호출되었습니다.");
        System.out.println("intNumber=" + intNumber + "\t" + "memberString=" + memberString);
        return intNumber;
    }

    protected String methodThree(int i, String s) {
        intNumber = i;
        memberString = s;
        System.out.println("SuperClass객체의 methodThree(int i, String s)메소드가 호출되었습니다.");
        System.out.println("intNumber=" + intNumber + "\t" + "memberString=" + memberString);
        return i + s;
    }

    public void methodFour() {
        memberString = "methodFour invokes methodOwn";
        methodOwn();
    }
}
//SubClass의 Error를 수정하고 Error의 이유를 주석으로 작성하세요.

/*overrriding의 기본조건
	리턴타입,메소드이름,인수 같아야한다
	modifier는 같거나 커야한다.
*/

class SubClass extends SuperClass { // SubClass is A SuperClass 관계임
    SubClass() {
        // super(); 부모의 기본생성자가 자동으로 추가되어 생략되어 있음 (이때 "생성자 SuperClass()가 호출되었습니다" 출력됨
        memberString = "SubClass의 생성자가 입력한 String";
        System.out.println("생성자 SubClass()가 호출되었습니다.");
    }

    //protected void methodZero() {
    public void methodZero() { // 제한자가 같거나 커야 함

        System.out.println("SubClass객체의 methodZero()메소드가 호출되었습니다.");
        System.out.println("intNumber=" + intNumber + "\t" + "memberString=" + memberString);
    }

    //private float methodOwn() {
    protected void methodOwn() { // 리턴 타입 동일해야 함
        System.out.println("SubClass객체의 methodOwn()메소드가 호출되었습니다.");
        System.out.println("intNumber=" + intNumber + "\t" + "memberString=" + memberString);
        // return 타입 제거
    }

    //private void methodTwo(int a) {
    int methodTwo(int a) {
        intNumber = a;
        System.out.println("SubClass객체의 methodTwo()메소드가 호출되었습니다.");
        System.out.println("intNumber=" + intNumber + "\t" + "memberString=" + memberString);
        return intNumber;
    }

    String methodThree(String s, int k) { // 오버로딩 한 것 (파라미터가 다르므로 에러가 없었음)
        intNumber = k;
        memberString = s;
        System.out.println("SubClass객체의 methodThree()메소드가 호출되었습니다.");
        System.out.println("intNumber=" + intNumber + "\t" + "memberString=" + memberString);
        return memberString;
    }

    //String methodThree(int k, String str) { // 위쪽 methodThree 동일한 메소드이지만 오버라이딩이라서 에러
    protected String methodThree(int k, String str) { // protected나 public가능함
        intNumber = k;
        memberString = str;
        System.out.println("SubClass객체의 methodThree()메소드가 호출되었습니다.");
        System.out.println("intNumber=" + intNumber + "\t" + "memberString=" + memberString);
        return memberString;
    }

    //public double methodFour() {
    public void methodFour() {
        System.out.println("SubClass의 public double methodFour()가 호출되었습니다.");
        memberString = "methodFour invokes methodOwn";
        methodOwn();
    }
}

//이 class도 수정하지 마세요.
class MethodOverridingExam {
    public static void main(String[] args) {
        SuperClass sp = new SuperClass(); // 멤버필드 초기화, 생성자 호출
        // 생성자가 SuperClass()가 호출되었습니다. 출력됨
        System.out.println("**************************************");
        SubClass sb = new SubClass();
        // 생성자가 SuperClass()가 호출되었습니다.
        // 생성자 SubClass()가 호출되었습니다.

        // 2줄이 출력됨 => why?  자식이 호출될때 부모의 생성자를 호출함
        // 자식 생성자 구현부 첫번째 줄에 super();가 생략되어 있는 거임
        System.out.println("**************************************");

        sp.methodZero();
        sp.methodOwn();
        sp.methodTwo(2);
        sp.methodThree(3, "MethodOverridingExam.java");
        sp.methodFour();
        System.out.println("**************************************");

        sb.methodZero();
        sb.methodOwn();
        sb.methodTwo(2222);
        sb.methodThree(3333, "또 MethodOverridingExam.java");
        sb.methodFour();
    }
}
