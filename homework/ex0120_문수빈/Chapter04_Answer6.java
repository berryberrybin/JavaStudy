/**
 * 본인이름 : 문수빈
 * 날짜 : 22.01.20
 * 주제 : 삼각형 별 출력
 */

public class Chapter04_Answer6 {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            for(int j=0;j<i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
