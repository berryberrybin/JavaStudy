package ex0128_문수빈;

import java.util.Scanner;

public class BankApplication {
    private static Account[] accountArray = new Account[100];
    private static Scanner scanner = new Scanner(System.in);
    private static int accountArraySize = 0;

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("------------------------------------------");
            System.out.print("선택> ");

            int selectNo = scanner.nextInt();

            if (selectNo == 1) {
                createAccount();
            } else if (selectNo == 2) {
                accountList();
            } else if (selectNo == 3) {
                deposit();
            } else if (selectNo == 4) {
                withdraw();
            } else if (selectNo == 5) {
                run = false;
            }
        }
        System.out.println("프로그램 종료");
    }

    private static void createAccount() {
        System.out.println("-----------");
        System.out.println("계좌생성");
        System.out.println("-----------");
        System.out.print("계좌번호: ");
        String ano = scanner.next();
        System.out.print("계좌주: ");
        String owner = scanner.next();
        System.out.print("초기입금액: ");
        int balance = scanner.nextInt();

        Account account = new Account(ano, owner, balance);
        accountArray[accountArraySize++] = account;
        System.out.println("결과: 계좌가 생성되었습니다.");
    }

    private static void accountList() {
        System.out.println("---------");
        System.out.println("계좌목록");
        System.out.println("---------");
        for (int i = 0; i < accountArraySize; i++) {
            System.out.print(accountArray[i].getAno() + "\t");
            System.out.print(accountArray[i].getOwner() + "\t");
            System.out.print(accountArray[i].getBalance() + "\n");
        }
    }

    private static void deposit() {
        System.out.print("계좌번호: ");
        String ano = scanner.next();
        System.out.print("예금액: ");
        int balance = scanner.nextInt();
        Account account = findAccount(ano);
        if (account != null) {
            account.setBalance(account.getBalance() + balance);
            System.out.println("예금이 성공되었습니다.");
        } else {
            System.out.println("예금에 실패하였습니다.");
        }
        System.out.println();
    }

    private static void withdraw() {
        System.out.print("계좌번호: ");
        String ano = scanner.next();
        System.out.print("출금액: ");
        int balance = scanner.nextInt();
        Account account = findAccount(ano);
        if (account != null) {
            account.setBalance(account.getBalance() - balance);
            System.out.print("예금이 성공되었습니다.");
        } else {
            System.out.println("예금에 실패하였습니다.");
        }
    }

    private static Account findAccount(String ano) {
        for (int i = 0; i < accountArraySize; i++) {
            if (accountArray[i].getAno().equals(ano)) {
                return accountArray[i];
            }
        }
        return null;
    }
}
