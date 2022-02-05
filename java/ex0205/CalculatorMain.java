package ex0205;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorMain {
    public int calculate(int lastNumber, int threadNumber) {
        List<SumThread> sumThreadList = makeThreadList(lastNumber, threadNumber);
        executeThreadList(sumThreadList);
        checkThreadEnd(sumThreadList, threadNumber);
        return sumThreadResult(sumThreadList);
    }

    private List<SumThread> makeThreadList(int lastNumber, int threadNumber) {
        List<SumThread> threadList = new ArrayList<>();
        int start = 1;
        int range = (lastNumber / threadNumber);
        int end = range;
        for (int i = 0; i < threadNumber; i++) {
            if (i == threadNumber - 1) {
                end = lastNumber;
            }
            SumThread thread = new SumThread(start, end);
            threadList.add(thread);
            start = end + 1;
            end += range;
        }
        return threadList;
    }

    private void executeThreadList(List<SumThread> sumThreadList) {
        for (int i = 0; i < sumThreadList.size(); i++) {
            sumThreadList.get(i).start();
        }
    }

    private void checkThreadEnd(List<SumThread> threadList, int threadNumber) {
        int count = 0;
        boolean run = true;
        while (run) {
            for (int i = 0; i < threadList.size(); i++) {
                Thread.State state = threadList.get(i).getState();
                if (!state.equals(Thread.State.TERMINATED)) {
                    break;
                } else {
                    count++;
                }
            }
            if (count == threadNumber) {
                run = false;
            }
        }
    }

    private int sumThreadResult(List<SumThread> threadList) {
        int result = 0;
        for (int i = 0; i < threadList.size(); i++) {
            result += threadList.get(i).getResult();
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
