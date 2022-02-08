package ex0208;

class Parent {
    int a = 5;
    int b = 10;

    public void aa() {
        System.out.println("Parent의 aa() 호출됨");
    }

    public void bb() {
        System.out.println("Parent의 bb() 호출됨");
    }
}

class Child extends Parent {
    int a = 100;
    int c = 50;


    @Override
    public void aa() {
        super.aa();
    }

    public void cc() {
        System.out.println("Child의 cc() 호출됨");
    }

    public void dd() {
        System.out.println(a);
        System.out.println(this.a);
        System.out.println(super.a);
    }
}

public class SuperKewordExam {
    public static void main(String[] args) {
        new Child().dd();
    }
}
