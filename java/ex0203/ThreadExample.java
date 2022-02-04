package ex0203;

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; ; i++) {
                System.out.println(i);
            }
        }
        );
        thread.start();
        new Thread(() -> {
            for (int i = 0; ; i++) {
                System.out.println("a" + i);
            }
        }
        ).start();
        while (true) {
            System.out.println("*");
        }
    }
}
