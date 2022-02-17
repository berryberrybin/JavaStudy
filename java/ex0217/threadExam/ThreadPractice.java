package ex0217.threadExam;

public class ThreadPractice {
    public static void main(String[] args) {

        System.out.println("------메인 시작합니다-------");
        NumberThread th1 = new NumberThread("첫번째 thread");
        NumberThread th2 = new NumberThread("두번째 thread");

        AlphaThread at = new AlphaThread();
        Thread th3 = new Thread(at, "세번째 thread");

        //run()으로 호출하면 순차적으로 출력됨 (첫번째->두번째->세번째 쓰레드)
        //th1.run();
        //th2.run();
        //th3.run();// run()을 사용하여 실행하여 "세번째 thread"라고 이름이 나오지 않고, main으로 이름 남옴

        th1.start();
        th2.start();
        th3.start();

        try {
            th1.join(); // th1 스레드 종료될때까지 대기 (지금은 메인스레드가 기다리게 함)
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("총합 : " + th1.sum);
        // th1이 끝나기 전에 main이 먼저 끝나버려서 총합이 원하는 5050이 나오지 않음 => 그래서 th1.join()이 함요함
        System.out.println("------메인 종료합니다-------");
    }
}


/**
 * 1~100까지 출력하는 Thread
 */

class NumberThread extends Thread {
    int sum;

    NumberThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(super.getName() + " --> " + i); // 출력하고 있는 Thread 이름 출력
            sum += i;
            // sleep()은 일정시간 끝나면 다시 준비상태로 간다.
            try {
                Thread.sleep(1000); // 1000일때 1초, 100일때 0.1초
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        System.out.println("--- " + super.getName() + " End ---");
    }
}

/**
 * A(대문자)~z(소문자)까지 출력하는 Thread
 */

class AlphaThread implements Runnable {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        for (char ch = 'A'; ch <= 'z'; ch++) {
            System.out.println(thread.getName() + " --> " + ch); // 출력하고 있는 Thread 이름 출력
            Thread.yield(); // 양보 (바로 준비상태)
        }
        System.out.println("--- " + thread.getName() + " End ---");
    }
}