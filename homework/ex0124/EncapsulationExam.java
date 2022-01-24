import java.util.Scanner;

public class EncapsulationExam {

    private int weight = 50;
    private String currentPassword = "1234";

    private void getWeight(String password) {
        if (isWrongPassword(password)) {
            System.out.println("현재몸무게 : " + weight + " kg");
        }
    }

    private void setWeight(int changedWeight, String password) {
        if (isWrongPassword(password)) {
            weight = changedWeight;
            System.out.println("몸무게가 " + weight + " kg 으로 변경되었습니다.");
        } else {
            System.out.println("비밀번호가 틀렸습니다.");
        }
    }

    private void getPassword(String password, String changedPassword) {
        if (isWrongPassword(password)) {
            currentPassword = changedPassword;
            System.out.println("비밀번호가 변경되었습니다.");
        }
    }

    private boolean isWrongPassword(String password) {
        if (password.equals(currentPassword)) {
            return true;
        } else {
            System.out.println("비밀번호 불일치");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EncapsulationExam e = new EncapsulationExam();

        while (true) {
            System.out.println("------------------  메     뉴 ------------------");
            System.out.println("1.몸무게 검색   2.몸무게 변경   3.비밀번호 변경   4.종료");
            System.out.print("메뉴 선택 > ");
            int menuNumber = Integer.parseInt(sc.nextLine());

            if (menuNumber == 4) {
                System.exit(1);
            } else if (menuNumber == 1) {
                System.out.print("비밀번호를 입력하세요 > ");
                String userInputPassword = sc.nextLine();
                e.getWeight(userInputPassword);
            } else if (menuNumber == 2) {
                System.out.print("비밀번호를 입력하세요 > ");
                String userInputPassword = sc.nextLine();
                if (e.isWrongPassword(userInputPassword)) {
                    System.out.print("변경된 몸무게를 입력하세요 > ");
                    int userInputWeight = Integer.parseInt(sc.nextLine());
                    e.setWeight(userInputWeight, userInputPassword);
                }
            } else if (menuNumber == 3) {
                System.out.print("비밀번호를 입력하세요 > ");
                String userInputPassword = sc.nextLine();
                if (e.isWrongPassword(userInputPassword)) {
                    System.out.print("변경할 비밀번호를 입력하세요 > ");
                    String changedPassword = sc.nextLine();
                    e.getPassword(userInputPassword, changedPassword);
                }
            } else {
                System.out.println("메뉴를 잘못 입력하였습니다.");
            }
        }
    }
}
