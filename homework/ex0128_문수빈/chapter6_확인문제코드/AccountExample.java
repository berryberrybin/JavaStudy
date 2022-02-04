package ex0128_문수빈;

public class AccountExample {
    public static void main(String[] args) {
        AccountExam19 account = new AccountExam19();
        account.setBalance(10000);
        System.out.println(account.getBalance());

        account.setBalance(-100);
        System.out.println(account.getBalance());

        account.setBalance(2000000);
        System.out.println(account.getBalance());

        account.setBalance(300000);
        System.out.println(account.getBalance());

    }
}
