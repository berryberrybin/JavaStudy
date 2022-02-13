package ex0212.solution;

public class Square implements Quadrangle {
    private int length;

    public Square(int length) {
        this.length = length;
    }

    @Override
    public int getWidth() {
        return length;
    }

    @Override
    public void setWidth(int width) {
        this.length = width;
    }

    @Override
    public int getHeight() {
        return length;
    }

    public void setHeight(int height) {
        this.length = height;
    }

    @Override
    public int getArea() {
        return length * length;
    }
}
