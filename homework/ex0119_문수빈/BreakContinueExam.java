public class BreakContinueExam {
    public static void main(String[] args) {
        for(int i=1;i<=5;i++){
            /*if(i==3){
                break;
            }*/
            for(int j=1;j<=5;j++){
                if(i==3){
                    break; // innner for문만 break 만나 밖으로 나가고 outter for문은 다시 돈다.
                }
                System.out.print(j+"\t");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("구구단 출력, 5단빼고 출력");
        for(int i=1; i<10 ; i++){
            for(int j=2;j<10;j++){
                if(j==5) continue;
                System.out.print(j +"*"+i+"="+i*j+"  ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("구구단 출력, 5단까지만 출력");
        for(int i=1; i<10 ; i++){
            for(int j=2;j<10;j++){
                if(j==5) break;
                System.out.print(j +"*"+i+"="+i*j+"  ");
            }
            System.out.println();
        }
    }
}
