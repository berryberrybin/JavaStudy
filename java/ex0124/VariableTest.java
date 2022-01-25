package ex0124;

class VariableTest {
    public static void main(String[] args) {
        Test t = new Test();
        t.aa();
        t.bb();
    }
}

class Test {
    public int a; // 전역변수
    private String name; // 전역변수

    public void aa() {
        int a = 10; // 지역변수
        String addr; // 지역변수

        System.out.println(a); // 10 출력됨
        System.out.println(this.a); // 0 출력됨 (this.은 전역변수 의미함 -자동초기화됨)
        System.out.println(name); // 전역변수 this. 없이도 사용 가능
        System.out.println(this.name); // 지역변수와 전역변수 이름이 같을 경우 this.을 통해 구분
        // System.out.println(addr);  (에러) addr은 지역변수이므로 초기화 해야 함
        // System.out.println(this.addr); (에러) 지역변수 앞에 this 사용불가
    }

    public void bb() {
        System.out.println(a); // 0 출력됨 => 전역변수 의미함
        System.out.println(this.a); // 0 출력됨
        System.out.println(name); // null
        System.out.println(this.name); // null
    }

}
