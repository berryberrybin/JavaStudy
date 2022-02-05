package ex0205;

public class CalculatorMain {
    public static void main(String[] args) {
        SumThread sumThreadA = new SumThread(1, 50);
        sumThreadA.start();

        SumThread sumThreadB = new SumThread(51, 100);
        sumThreadB.start();

        boolean run = true;
        while (run) {
            Thread.State stateA = sumThreadA.getState();
            Thread.State stateB = sumThreadB.getState();

            if (stateA.equals(Thread.State.TERMINATED) && stateB.equals(Thread.State.TERMINATED)) {
                run = false;
            }
        }
        int result = sumThreadA.getResult() + sumThreadB.getResult();
        System.out.println(result);

    }
}
