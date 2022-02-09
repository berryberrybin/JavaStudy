package ex0212.problem;

public class Main {

    public void testRectangle(Rectangle rect) {
        rect.setWidth(10);
        rect.setHeight(5);
        System.out.println(rect.getWidth() == 10);
        System.out.println(rect.getHeight() == 5);
        System.out.println(rect.getArea() == 50);
    }

    public static void main(String[] args) {
        new Main().testRectangle(new Rectangle());
        new Main().testRectangle(new Square()); // LSP 위반 -매개변수가 Rectangle이니까 하위클래스인 Square도 매개변수로 넣을 수 있다
//        Rectangle rect = new Square();
//        rect.setWidth(10);
//        rect.setHeight(5);
//        System.out.println(rect.getWidth() == 10);
//        System.out.println(rect.getHeight() == 5);
//        System.out.println(rect.getArea() == 50);

//        Rectangle square = new Square();
//        square.setWidth(10);
//        square.setHeight(5);
//        System.out.println(square.getArea()); // LSP 위반
    }
}
