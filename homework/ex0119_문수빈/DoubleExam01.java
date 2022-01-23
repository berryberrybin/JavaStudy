public class DoubleExam01 {
    public static void main(String[] args) {

        System.out.println("1~100까지 출력 - 10행 10열, 이중 for문 이용");
        for (int i = 0; i < 100; i = i + 10) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(j + i + "  ");
            }
            System.out.println();
        }

        /*
        for(int i=0; i<10;i++){
            for(int j=0;j<=10;j++){
                System.out.print( (i*10)+j );
            }
        }
         */

        System.out.println();
        System.out.println("구구단 출력");
        for(int i=1; i<10 ; i++){
            for(int j=2;j<10;j++){
                System.out.print(j +"*"+i+"="+i*j+"  ");
            }
            System.out.println();
        }

    }
}
