/**
 * 본인이름 : 문수빈
 * 날짜 : 22.01.26
 * 주제 : 동호레이아웃
 */

class TwoDmArray {
    //String을 저장하는 twoDmArray 배열선언
    String[][] twoDmArray = new String[10][];

    //메소드 make2DmArray
    //twoDmArray 배열에  값을 할당

    public void make2DmArray() {
        for (int i = 0; i < twoDmArray.length; i++) {
            twoDmArray[i] = new String[i + 1];
            for (int j = 0; j < twoDmArray[i].length; j++) {
                twoDmArray[i][j] = (i + 1) + "동" + (j + 1) + "호";
            }
        }
    }

    //메소드 print2DmArray
    //	twoDmArray 배열의 값을 주어진형식으로 출력
    public void print2DmArray() {
        for (int i = 0; i < twoDmArray.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("        ");
            }
            for (int j = i; j < twoDmArray.length; j++) {
                System.out.print(twoDmArray[j][i] + "   ");
            }
            System.out.println();
        }

    }
}

public class TwoDmArrayExam {
    public static void main(String[] args) {
        TwoDmArray tda = new TwoDmArray();
        tda.make2DmArray();
        tda.print2DmArray();
    }
    //main메소드에서
    //TwoDmArray객체생성
    //TwoDmArray객체의 make2DmArray메소드 호출
    //TwoDmArray객체의 print2DmArray메소드 호출
}

