package ex0209.AbstractExam;

public abstract class Animal {
    private String name;
    private String bodyColor;

    public Animal() {
    }

    public Animal(String name, String bodyColor) {
        this.name = name;
        this.bodyColor = bodyColor;
    }

    public abstract void sound();

    public abstract void eat();

    public void run() {
        System.out.println("잘 뜁니다!!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " | ");
        sb.append(bodyColor);
        return sb.toString();
    }
}
