package ex0218;

public class InterruptExam {
    public static void main(String[] args) {
        System.out.println("---메인 시작합니다---");

        //람다식 쓰기 이전
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).start();

        Thread th = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("--- Thread 동작 중입니다 --- ");
                    Thread.sleep(1); //0.001초 대기
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
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

