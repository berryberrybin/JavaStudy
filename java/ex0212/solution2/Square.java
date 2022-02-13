package ex0212.solution2;

public class Square {
    private Rectangle rect;

    public Square() {
        rect = new Rectangle();
    }

    public Square(int length) {
        rect = new Rectangle(length, length);
    }

    public int getWidth() {
        return rect.getWidth();
    }

    public void setWidth(int width) {
        rect.setWidth(width);
        rect.setHeight(width);
    }

    public int getHeight() {
        return rect.getHeight();
    }

    public void setHeight(int height) {
        rect.setWidth(height);
        rect.setHeight(height);
    }

    public int getArea() {
        return rect.getArea();
    }
}
