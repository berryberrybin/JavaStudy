package ex0126;

class MultiArray {
    //정수형 2차원 배열 8*9
    int[][] arr = new int[8][9];

//메소드이름 :array99
    public void array99(){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] = (i+2)*(j+2);
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
    //for loop 를 사용하여
    //배열에 곱한 (구구단)결과저장
    //배열에 결과를 꺼내출력
}

public class MemoryApart {
    //main메소드에서

    public static void main(String[] args) {
        MultiArray ma = new MultiArray();
        ma.array99();
        //MultiArray객체의 array99메소드호출
    }

}
