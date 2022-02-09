package ex0209.AbstractExam;

public class AnimalMain {
    public static void main(String[] args) {
        Animal animal = null;
        animal = new Cat("고양이", "흰색", 4);
        test(animal);
        System.out.println("----------------------");
        animal = new Pig("돼지", "핑크");
        test(animal);
        System.out.println("------------------------");
        animal = new Puppy("강아지", "흰색");
        test(animal);
    }

    public static void test(Animal animal) {
        animal.sound();
        animal.eat();
        animal.run();
        System.out.print(">>>>");
        System.out.println(animal); // animal의 toString이 호출됨

        //Cat에 있는 leg를 찍고 싶을때;
        //animal.getLeg();  접근 불가 -> 캐스팅 필요
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            System.out.println("다리수 : " + cat.getLegs() + "개");
        }
    }
}
