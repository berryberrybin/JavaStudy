package ex0212.solution;

public class Main {

    public void testRectangle(Rectangle rect) {
        rect.setWidth(10);
        rect.setHeight(5);
        System.out.println(rect.getWidth());
        System.out.println(rect.getHeight());
        System.out.println(rect.getArea());
    }

//    public void testSquare(Square square) {
//        square.setWidth(10); // width = height = 10
//        System.out.println(square.getWidth());
//        System.out.println(square.getHeight());
//        System.out.println(square.getArea());
//    }

    public static void main(String[] args) {
        new Main().testRectangle(new Rectangle(0, 0));
        //new Main().testSquare(new Square(0));

        System.out.println("------------------------------");
//        List<Quadrangle> quadrangles = new ArrayList<>();
//        quadrangles.add(new Rectangle(10, 2));
//        quadrangles.add(new Square(5));
//        quadrangles.add(new Rectangle(5, 5));
//        for (Quadrangle quadrangle : quadrangles) {
//            System.out.println(quadrangle.getArea());
//        }
    }
}
