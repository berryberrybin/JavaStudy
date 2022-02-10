package ex0209_문수빈.InterfaceExample;

public class Audio extends Elec implements ElecFunction {
    private int volume;

    public Audio() {
    }

    public Audio(int volume) {
        this.volume = volume;
    }

    public Audio(String code, int cost, int volume) {
        super(code, cost);
        this.volume = volume;
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
        sb.append("Audio를 " + volume + "으로 듣는다.");
        return sb.toString();
    }
}
