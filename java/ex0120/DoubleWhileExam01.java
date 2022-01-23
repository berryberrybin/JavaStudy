package ex0120;

public class DoubleWhileExam01 {
    public static void main(String[] args) {

        System.out.println("1 ~ 100을 출력하는데 10행 10열로 출력하기");
        int i = 0;
        while (i < 10) {
            int j = 1;
            while (j <= 10) {
                System.out.print((i * 10) + j + "\t");
                j++;
            }
            System.out.println();
            i++;
        }

        System.out.println("구구단출력하기 ");
        int a = 1;
        while (a <= 9) {
            int b = 2;
            while (b <= 9) {
                System.out.print(b + "*" + a + "=" + a * b + "\t");
                b++;
            }
            System.out.println();
            a++;
        }
    }
    //1. 1 ~ 100을 출력하는데 10행 10열로 출력하기 (for문안에 for문 이용하기 )
	   /*
	      1  2 3 ....10
		  11 12 13 ... 20
		  21.....      30
		  ..

		  91 ..........100
	   */

    //2.  구구단출력하기 (9행 8열)
	     /*
		     2*1=2  3*1 =3   4*1=4 ....... 9*1=9
			 2*2=4  3*2 =6   4*2=8 ....... 9*2=18
			 2*3=6  3*3 =9   4*3=12 ....... 9*3=27
			 ...

			 2*9=18  3*9 =27   4*9=36 ....... 9*9=81

		 */
}

