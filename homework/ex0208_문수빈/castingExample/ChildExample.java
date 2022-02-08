package ex0208_문수빈.castingExample;

public class ChildExample {
    public static void main(String[] args) {
        Parent parent = new Child(); //자동타입변환
        parent.field1 = "data1";
        parent.method1();
        parent.method2();

        /*
        parent.method3(); // 불가능
        parent.field2 = "data2"; // 불가능
         */

        // Parent parent = new Child()을 통해 자식타입이 부모타입으로 자동변환된 후,
        // 다시 자식 타입으로 변환할때 강제타입변환 사용 가능
        Child child = (Child) parent;
        child.field2 = "yyy"; // 가능
        child.method3(); // 가능
    }
}
