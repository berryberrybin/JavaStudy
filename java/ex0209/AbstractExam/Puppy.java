package ex0209.AbstractExam;

public class Puppy extends Animal {

    public Puppy() {
    }

    public Puppy(String name, String bodyColor) {
        super(name, bodyColor);
    }

    @Override
    public void sound() {
        System.out.println("멍멍");
    }

    @Override
    public void eat() {
        System.out.println("사료를 잘 먹는다");
    }
}
