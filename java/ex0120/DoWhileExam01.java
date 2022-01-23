package ex0120;

public class DoWhileExam01 {
    public static void main(String[] args) {
        System.out.println("1. 1 ~ 100까지 한줄로 출력하기");
        int i = 1;
        do {
            System.out.print(i + "\t");
            i++;
        } while (i <= 100);
        System.out.println("\n");

        System.out.println("1 ~100까지 출력하되 5의 배수만 출력하기");
        i = 1;
        do{
            if (i % 5 == 0) {
                System.out.print(i + "\t");
            }
            i++;
        }
        while (i <= 100);
        System.out.println("\n");


        System.out.println("1 ~100까지의 합을 출력하기");
        int sum = 0;
        i = 1;
        do{
            sum = sum + i;
            i++;
        }
        while (i <= 100);
        System.out.println(sum);
        System.out.println();

        System.out.println("A ~ Z까지 출력");
        char c = 'A';
        do{
            System.out.print(c + "\t");
            c++;
        }
        while (c <= 'Z');
        System.out.println("\n");

        System.out.println("1~ 100사이의 3의 배수의 합 출력하기");
        i = 1;
        sum = 0;
        do{
            if (i % 3 == 0) {
                sum = sum + i;
            }
            i++;
        }
        while (i <= 100);
        System.out.println(sum);

        System.out.println();
        System.out.println("1 ~ 100 출력을 10행 10열로 출력하기");
        i = 1;
        do{
            System.out.print(i + "\t");
            if (i % 10 == 0) {
                System.out.println();
            }
            i++;
        }
        while (i <= 100);
        System.out.println();

        System.out.println("100 ~ 1까지 거꾸로 출력하기 ( 100 99 98,.... 1 )");
        i = 100;
        do{
            System.out.print(i + "\t");
            i--;
        }
        while (i > 0);
    }
}

