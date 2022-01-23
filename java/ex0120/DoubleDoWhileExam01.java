package ex0120;

public class DoubleDoWhileExam01 {
    public static void main(String[] args) {

        System.out.println("1 ~ 100을 출력하는데 10행 10열로 출력하기");
        int i = 0;
        do {
            int j = 1;
            do {
                System.out.print((i * 10) + j + "\t");
                j++;
            }
            while (j <= 10);
            System.out.println();
            i++;
        }
        while (i < 10);

        System.out.println();
        System.out.println("구구단출력하기 ");
        int a = 1;
        do {
            int b = 2;
            do {
                System.out.print(b + "*" + a + "=" + a * b + "\t");
                b++;
            }
            while (b <= 9);
            System.out.println();
            a++;
        }
        while (a <= 9);
    }

}
