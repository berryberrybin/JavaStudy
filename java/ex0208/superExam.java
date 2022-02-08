package ex0208;

public class superExam {
    public static void main(String[] args) {


        class Parent {
            int a = 5;
            int b = 10;

            // 1번
            public void aa() {
                System.out.println("부모 aa");
            }

            //2 번
            public void bb() {
                System.out.println("부모 bb");
            }
        }

        class Child extends Parent {
            int a = 100;
            int c = 50;

            // 3번
            public void aa() {
                System.out.println("<aa 시작>");
                System.out.println(a); // 100
                System.out.println(this.a); // 100
                System.out.println(super.a); // 5
                System.out.println("---------------");
                System.out.println(b); // 10
                System.out.println(this.b); // 10
                System.out.println(super.b); // 10
                System.out.println("---------------");
                System.out.println(c); // 50
                System.out.println(this.c); // 50
                // System.out.println(super.c); // 사용불가
                System.out.println("<aa끝>");

                // System.out.println("******cc호출********");
                // cc(); // 4번 호출
                // this.cc(); // 4번 호출
                // super.cc(); // 호출불가
            }

            // 4번
            public void cc() {
                aa(); // 3번호출
                this.aa(); // 3번 호출
                super.aa(); // 1번 호출
                System.out.println("--------------");
                bb(); // 2번호출
                this.bb(); // 2번 호출
                super.bb(); // 2번 호출
            }
        }

        Child child = new Child();
        System.out.println("//////////aa/////////");
        child.aa();

        // System.out.println("////////cc()/////////");
        // child.cc();
    }
}
