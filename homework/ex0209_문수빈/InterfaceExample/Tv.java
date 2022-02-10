package ex0209_문수빈.InterfaceExample;

public class Tv extends Elec implements ElecFunction {
    private int chnnel;

    public Tv() {
    }

    public Tv(int chnnel) {
        this.chnnel = chnnel;
    }

    public Tv(String code, int cost, int chnnel) {
        super(code, cost);
        this.chnnel = chnnel;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void display() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("TV를 " + chnnel + "을 본다");
        return sb.toString();
    }
}
