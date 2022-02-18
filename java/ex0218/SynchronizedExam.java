package ex0218;

public class SynchronizedExam {
    public static void main(String[] args) {
        System.out.println("---메인 시작---");

        Bank bank = new Bank();
        CustomerThread th1 = new CustomerThread(bank, "생산자", true);
        CustomerThread th2 = new CustomerThread(bank, "소비자", false);
        th1.start();
        th2.start();
        System.out.println("---메인 끝---");
    }
}

/**
 * wait()현재 동기화블럭에 있는 스레드를 중지상태
 * notify(), notifyAll() : wait()에 의해 중지상태에 있는 스레드를 깨운다
 * wait(), notifyAll(), notify()은 반드시 동기화블럭(synchronized)안에서만 사용한다.
 */

class Bank {
    int balance; // 잔액

    // state는 true일 경우 입금(생산자) /  flase 출금(소비자)
    public synchronized void balanceChange(String name, boolean state) { // 메소드 전체 동기화 하는 방법
        if (state) {
            if (balance == 0) {
                System.out.print(name + " ---> 현재 잔액 : " + balance);
                balance++;
                System.out.println(name + " ---> 증가후 금액 : " + balance);
            } else {
                try {
                    System.out.println(name + "님 중지상태입니다.");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            if (balance > 0) {
                System.out.print(name + " ---> 현재 잔액 : " + balance);
                balance--;
                System.out.println(name + " ---> 감소후 금액 : " + balance);
            } else {
                try {
                    System.out.println(name + "님 중지상태입니다.");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        notifyAll();
    }
}

//        if (state) {
//            synchronized(this) { // 특정 부분만 동기화 처리 하는 방법  (this는 공유객체)
//                System.out.print(name + " ---> 현재 잔액 : " + balance);
//                balance++;
//                System.out.println(name + " ---> 증가후 금액 : " + balance);
//            }
//        } else {
//            synchronized (this) {
//                System.out.print(name + " ---> 현재 잔액 : " + balance);
//                balance--;
//                System.out.println(name + " ---> 감소후 금액 : " + balance);
//            }
//        }
//    }
//}

// Bank라는 객체를 사용하게 될 고객(생산자, 소비자) Thread
class CustomerThread extends Thread {
    Bank bank;
    boolean state;

    CustomerThread(Bank bank, String name, Boolean state) {
        super(name); // 스레드 이름 세팅
        this.bank = bank;
        this.state = state;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            bank.balanceChange(super.getName(), state);
        }
        System.out.println(super.getName() + "----- END -----");
    }
}

//Bank bank = new Bank();
//new CustomerThread(bank, "소비자",false) // 소비자
//new CustomerThread(bank, "생산자", true) // 생산자