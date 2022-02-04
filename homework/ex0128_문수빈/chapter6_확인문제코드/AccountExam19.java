package ex0128_문수빈;

public class AccountExam19 {
    private int balance;
    private static int MIN_BALANCE = 0;
    private static int MAX_BALNCE = 1000000;


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance > MIN_BALANCE && balance < MAX_BALNCE) {
            this.balance = balance;
        }
    }
}
