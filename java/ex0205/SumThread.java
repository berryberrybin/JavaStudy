package ex0205;

public class SumThread extends Thread {
    private int result = 0;
    private int start;
    private int end;

    public SumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        result = sum;
        System.out.println("resultA : " + result);
    }

    public int getResult() {
        return result;
    }

}
