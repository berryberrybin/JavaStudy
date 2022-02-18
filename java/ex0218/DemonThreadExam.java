package ex0218;

public class DemonThreadExam {
    public static void main(String[] args) {
        System.out.println("----메인 시작---");

        Runnable r = () -> {
            while (true) {
                System.out.println(" * DamonThread입니다");
                try {
                    Thread.sleep(300);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread th = new Thread(r);
        th.setDaemon(true);
        th.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("---메인 끝---");
    }
}
