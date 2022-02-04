package ex0203;

public class BeepPrintExample2 {
    public static void main(String[] args) {
        Thread thread = new BeepThread();
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}
