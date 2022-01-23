public class StarPrint {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            for(int j=0;j<i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");

        for(int i=0;i<5;i++){
            for(int j=0;j<5-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");

        for(int i=0;i<5;i++){
            for(int j=0;j<5-i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");

        for(int i=0;i<5;i++){
            for(int j=0;j<i+1;j++){
                System.out.print(" ");
            }
            for(int j=0;j<5-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("-------------------------------");

        for(int a=1;a<=5;a++){
            for(int b=a;b<5;b++){
                System.out.print(" ");
            }
            for(int c=1;c<=a;c++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("==============space 이용==============");
        String space=""; // space 값 변경을 할경우 메모리낭비 발생 : 계속 주소값이 바뀜
        for(int a=1;a<=5;a++){
            System.out.print(space );
            for( int c=a;c<=5;c++){
                System.out.print("*");
            }
            space=space+" ";
            System.out.println();
        }
    }
}
