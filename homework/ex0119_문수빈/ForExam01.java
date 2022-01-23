public class ForExam01 {
    public static void main(String[] args) {

        {
            System.out.println("1) 1~100까지 한줄로 출력");
            for (int i = 1; i <= 100; i++) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
        {
            System.out.println("2) 1~100까지 5의 배수만 출력");
            for (int i = 1; i <= 100; i++) {
                if (i % 5 == 0) {
                    System.out.print(i + "  ");
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
        {
            System.out.println("3) 1~100까지 합 출력");
            int sum = 0;
            for (int i = 0; i <= 100; i++) {
                sum = sum + i;
            }
            System.out.println(sum);
        }
        System.out.println("-----------------------------------");
        {
            System.out.println("4) A~Z까지 출력");
            for (char c = 'A'; c <= 'Z'; c++) {
                System.out.print(c + "  ");
            }
            System.out.println();
        }

       /*
        for(int i=0;i<26;i++){
            System.out.println( (char)( 'A'+i ));
        }

        for(i=65;i<=90;i++){
            System.out.println( (char)(i));
        }
       */

        System.out.println("-----------------------------------");
        {
            System.out.println("5) 1~100사이의 3의 배수의 합 출력");
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                if (i % 3 == 0) {
                    sum = sum + i;
                }
            }
            System.out.println(sum);
        }
        System.out.println("-----------------------------------");
        {
            System.out.println("6) 1~100까지 10행 10열로 출력");
            for (int i = 1; i <= 100; i++) {
                System.out.print(i + "  ");
                if (i % 10 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
        {
            System.out.println("7) 100~1까지 거꾸로 출력");
            for (int i = 100; i > 0; i--) {
                System.out.print(i + "  ");
            }
        }
    }
}
