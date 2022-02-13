package ex0212.increase;


public class SquareArea {
    // 가로를 늘리는 기능 추가
    public static void increase가로(Rectangle rect) {
        rect.set가로(rect.get가로() + 1);
    }

    public static void main(String[] args) {
        Rectangle test1 = new Rectangle(10, 2);
        Rectangle test2 = new Rectangle(5, 5);
        Rectangle test3 = new Square(5, 5);

        increase가로(test1); // 가로 10 -> 11
        increase가로(test2); // 가로 5 -> 6, 세로 5 -> 6
        increase가로(test3); // 가로 5 -> 6, 세로 5 -> 6

        System.out.println(test1.get넓이()); // 11 * 2 = 22
        System.out.println(test2.get넓이()); // 6 * 6 = 36
        System.out.println(test3.get넓이()); // 6 * 6 = 36
    }
}


