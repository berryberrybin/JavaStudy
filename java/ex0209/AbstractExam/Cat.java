package ex0209.AbstractExam;

public class Cat extends Animal {
    private int legs;


    public Cat() {
    }

    public Cat(String name, String bodyColor, int legs) {
        super(name, bodyColor);
        this.legs = legs;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    @Override
    public void sound() {
        System.out.println("야옹~");
    }

    @Override
    public void eat() {
        System.out.println("생선을 먹는다");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" | " + legs);
        return sb.toString();
    }
}
