package ex0212.increase;

public class Rectangle {
    protected int 가로;
    protected int 세로;

    public Rectangle(int 가로, int 세로) {
        this.가로 = 가로;
        this.세로 = 세로;
    }

    public int get가로() {
        return 가로;
    }

    public int get세로() {
        return 세로;
    }

    public void set가로(int 가로) {
        this.가로 = 가로;
    }

    public void set세로(int 세로) {
        this.세로 = 세로;
    }

    public int get넓이() {
        return 가로 * 세로;
    }
}
