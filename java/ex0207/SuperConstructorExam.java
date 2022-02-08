package ex0207;

class Parent {
    Parent() {
        System.out.println("Parent() 기본생성자 - 1");
    }

    Parent(int i) {
        System.out.println("Parent(int i) 생성자 - 2");
    }

    Parent(String s) {
        System.out.println("Parent(String s) 생성자 - 3");
    }
}

class Child extends Parent {
    Child() {
        System.out.println("Child() 기본생성자 - 4");
    }

    Child(int i) {
        System.out.println("Child(int i) 생성자 - 5");
    }

    Child(boolean b) {
        System.out.println("Child(boolean b) 생성자 - 6");
    }

}

public class SuperConstructorExam {
    public static void main(String[] args) {

        new Child(); // 1, 4 호출
        System.out.println();
        new Child(10); // 1, 5 호출
        System.out.println();
        new Child(true); // 1, 6 호출
        System.out.println();

        // 1, 2, 3이 없다면 - 부모가 생성자를 한개도 작성하지 않았다면, 기본생성자는 자동으로 생성됨
        new Child();
        new Child(10);
        // 여기까지는 자식에 super();가 있으나 없으나 상관 없음

        // 1은 없고, 2와 3이 있다면 모두 에러남 - 생성자를 1개라도 생성할 경우 기본생성자가 자동으로 생성안됨
        // this와 super을 통해서 아래와 같이 코드 수정시 에러 고칠 수 있음
        /*
        Child() {
        this(5);
        System.out.println("Child() 기본생성자 - 1");
    }

    Child(int i) {
        super(i);
        System.out.println("Child(int i) 생성자 - 2");
    }

    Child(boolean b) {
        super("안녕");
        System.out.println("Child(boolean b) 생성자 - 3");
    }
         */
    }
}
