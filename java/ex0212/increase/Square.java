package ex0212.increase;

public class Square extends Rectangle {
    public Square(int 가로, int 세로) {
        super(가로, 세로);
        //if (가로 != 세로) {
        //    throw new IllegalArgumentException();
        //}
    }

    @Override
    public void set가로(int 가로) {
        this.가로 = 가로;
        this.세로 = 가로;
    }

    @Override
    public void set세로(int 세로) {
        this.가로 = 세로;
        this.세로 = 세로;
    }
}
