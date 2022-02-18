package ex0218;

public class InterruptedExam02 {
    public static void main(String[] args) {
        System.out.println("---메인 시작합니다---");
        Thread th = new Thread(() -> {
            while (true) {
                System.out.println("--- Thread 동작 중입니다 --- ");
                if (Thread.interrupted()) {
                    break;
                }
            }
        });
        th.start();

        // 3초가 지나면 위의 thread를 종료하고 싶음
        try {
            th.sleep(3000); // 3 초
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 스레드 종료
        th.interrupt(); // 스레드의 Interruptdexception 발생시켜서 안전하게 종료하는 방법
        // 스레드를 종료하고 싶다.
        System.out.println("---메인 끝입니다---");
    }
}
