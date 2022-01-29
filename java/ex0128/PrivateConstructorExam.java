package ex0128;

class Test{
    private static Test t = new Test(); // 3_2 : 자신의 객체를 초기화함
    private Test(){} // 1_1 : 외부에서 객체 생성 막음

    // 2_1 :현재 객체를 리턴해주는 메소드 제공
    public static Test getInstance(){
        //Test t = new Test(); // 3_1 : 이 코드 삭제한 후 3_2 작성
        return t;
    }
}
public class PrivateConstructorExam {
    public static void main(String[] args) {
        // new Test(); // 1_2 :외부에서 객체 생성안됨
        /* 2_2  : t1, t2, t3 주소값이 다름
        Test t1 = Test.getInstance();
        Test t2 = Test.getInstance();
        Test t3 = Test.getInstance();

        System.out.println("t1 ="+t1);
        System.out.println("t2 ="+t2);
        System.out.println("t3 ="+t3);
        */

        Test t1 = Test.getInstance();
        Test t2 = Test.getInstance();
        Test t3 = Test.getInstance();

        System.out.println("t1 ="+t1); // 3_3 : 3_2에 의해 주소값이 모두 동일해짐
        System.out.println("t2 ="+t2);
        System.out.println("t3 ="+t3);

    }
}
