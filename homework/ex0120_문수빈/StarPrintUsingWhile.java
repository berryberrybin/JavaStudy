/**
 * 본인이름 : 문수빈
 * 날짜 : 22.01.20
 * 주제 : 별찍기 - while문 과  do-while 이용
 */
public class StarPrintUsingWhile {
    public static void main(String[] args) {
        {
            int i = 0;
            while (i < 5) {
                int j = 0;
                while (j < i + 1) {
                    System.out.print("*");
                    j++;
                }
                System.out.println();
                i++;
            }
        }

        System.out.println("---------------------------------");

        {
            int i = 0;
            do {
                int j = 0;
                do {
                    System.out.print("*");
                    j++;
                } while (j < 5 - i);
                System.out.println();

                i++;
            } while (i < 5);
        }

        System.out.println("---------------------------------");

        {
            int i = 0;
            while (i < 5) {
                int j = 1;
                while (j < 5 - i) {
                    System.out.print(" ");
                    j++;
                }
                int k = 0;
                while (k < i + 1) {
                    System.out.print("*");
                    k++;
                }
                System.out.println();
                i++;
            }
        }

        System.out.println("---------------------------------");

        {
            int i = 0;
            do {
                int j = 0;
                do {
                    System.out.print(" ");
                    j++;
                } while (j < i + 1);
                int k = 0;
                do {
                    System.out.print("*");
                    k++;
                } while (k < 5 - i);
                System.out.println();
                i++;
            } while (i < 5);
        }

        System.out.println("-------------------------------");
    }
}
