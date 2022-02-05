package ex0205;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorMain {
    public int calculate(int lastNumber, int threadNumber) {
        List<SumThread> sumThreadList = makeThreadList(lastNumber, threadNumber);
        executeThreadList(sumThreadList);
        waitThreadList(sumThreadList);
        return sumThreadListResult(sumThreadList);
    }

    private List<SumThread> makeThreadList(int lastNumber, int threadNumber) {
        List<SumThread> threadList = new ArrayList<>();
        int range = (lastNumber / threadNumber);
        for (int i = 0; i < threadNumber; i++) {
            SumThread thread;
            if (i == threadNumber - 1) {
                thread = new SumThread((range * i) + 1, lastNumber);
            } else {
                thread = new SumThread((range * i) + 1, (range * (i + 1)));
            }
            threadList.add(thread);
        }
        return threadList;
    }

    private void executeThreadList(List<SumThread> sumThreadList) {
        for (SumThread sumThread : sumThreadList) {
            sumThread.start();
        }
    }

    private void waitThreadList(List<SumThread> threadList) {
        while (!isDoneThreadList(threadList)) ;
    }

    private boolean isDoneThreadList(List<SumThread> threadList) {
        for (SumThread sumThread : threadList) {
            Thread.State state = sumThread.getState();
            if (!state.equals(Thread.State.TERMINATED)) {
                return false;
            }
        }
        return true;
    }

    private int sumThreadListResult(List<SumThread> threadList) {
        int result = 0;
        for (SumThread sumThread : threadList) {
            result += sumThread.getResult();
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("마지막 숫자 : ");
        int lastNumber = Integer.parseInt(scanner.nextLine());

        System.out.print("사용할 스레드 개수 : ");
        int threadNumber = Integer.parseInt(scanner.nextLine());

        CalculatorMain calculatorMain = new CalculatorMain();
        System.out.println("최종값 : " + calculatorMain.calculate(lastNumber, threadNumber));
    }
}
