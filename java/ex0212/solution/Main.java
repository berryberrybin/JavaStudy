package ex0212.solution;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public void testRectangle(Rectangle rect) {
        rect.setWidth(10);
        rect.setHeight(5);
        System.out.println(rect.getWidth() == 10);
        System.out.println(rect.getHeight() == 5);
        System.out.println(rect.getArea() == 50);
    }

    public void testSquare(Square square) {
        square.setWidth(10); // width = height = 10
        System.out.println(square.getWidth() == 10);
        System.out.println(square.getHeight() == 10);
        System.out.println(square.getArea() == 100);
        square.setHeight(5); // width = height = 5
        System.out.println(square.getWidth() == 5);
        System.out.println(square.getHeight() == 5);
        System.out.println(square.getArea() == 25);
    }

    public static void main(String[] args) {
        new Main().testRectangle(new Rectangle());
        new Main().testSquare(new Square());

        List<Quadrangle> quadrangles = new ArrayList<>();
        quadrangles.add(new Rectangle());
        quadrangles.add(new Square());
        quadrangles.add(new Rectangle());
        for (Quadrangle quadrangle : quadrangles) {
            System.out.println(quadrangle.getArea());
        }
    }
}
