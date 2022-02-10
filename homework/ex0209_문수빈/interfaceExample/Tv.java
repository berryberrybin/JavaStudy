package ex0209_문수빈.interfaceExample;

public class Tv extends Elec implements ElecFunction {
    private int channel;

    public Tv() {
    }

    public Tv(int channel) {
        this.channel = channel;
    }

    public Tv(String code, int cost, int channel) {
        super(code, cost);
        this.channel = channel;
    }

    @Override
    public void start() {
        String className = getClass().getSimpleName();
        System.out.println(getCode() + "의 " + className + "를 " + channel + "을 본다"); // super.getCode()
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
        sb.append("TV를 " + channel + "을 본다");
        return sb.toString();
    }
}
