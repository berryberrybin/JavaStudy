package ex0211;

public class VariableArgsExample {
    public void aa(int... i) {
        System.out.print("출력: ");
        for (int a : i) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }

    public void bb(Object... o) {
        System.out.print("출력: ");
        for (Object a : o) {
            System.out.print(a + ", ");
        }
        System.out.println();

    }

    public void cc(String name, int... i) {
        System.out.println();
    }

    public static void main(String[] args) {
        VariableArgsExample va = new VariableArgsExample();
        va.aa();
        va.aa(4, 5, 6);
        va.bb(2);
        va.bb("abc", true, 5, '가');
        va.cc("kim", 90, 80, 65);

    }
}
