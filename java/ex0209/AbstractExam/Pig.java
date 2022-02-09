package ex0209.AbstractExam;

public class Pig extends Animal {

    public Pig() {
    }

    public Pig(String name, String bodyColor) {
        super(name, bodyColor);
    }

    @Override
    public void sound() {
        System.out.println("꿀꿀");
    }

    @Override
    public void eat() {
        System.out.println("다 잘먹는다");
    }

    @Override
    public void run() {
        System.out.println("잘 뛰지 못한다");
    }
}
