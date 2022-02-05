package ex0205;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("마지막 숫자 : ");
        int lastNumber = Integer.parseInt(scanner.nextLine());

        System.out.print("사용할 스레드 개수 : ");
        int n = Integer.parseInt(scanner.nextLine());

        List<SumThread> threadList = new ArrayList<>();

        int start = 1;
        int range = (lastNumber / n);
        int end = range;

        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                end = lastNumber;
            }
            SumThread thread = new SumThread(start, end);
            threadList.add(thread);
            thread.start();
            start = end + 1;
            end += range;
        }

        int result = 0;
        boolean run = true;
        while (run) {
            int count = 0;
            result = 0;
            for (int i = 0; i < threadList.size(); i++) {
                Thread.State state = threadList.get(i).getState();

                result += threadList.get(i).getResult();
                if (!state.equals(Thread.State.TERMINATED)) {
                    break;
                } else {
                    count++;
                }
            }
            if (count == n) {
                run = false;
            }
        }
        System.out.println("최종값 : " + result);
    }
}
