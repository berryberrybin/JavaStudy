package ex0126;

public class MultiArrayExam {
    // String [][] arr = new String [3][5]; // 3행 5열
    // String [][] arr = new String [3][]; //행이 3만 지정, 열은 미정

    String[][] arr = new String[][]{
            {"A", "B", "C"},
            {"월", "화", "수", "목", "금"},
            {"가", "나", "다", "라"}
    };

    public void stringArrayPrint() {
        System.out.println("arr = " + arr);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void intArrayExam() {
        int[][] intArr = new int[4][];
       /*
        System.out.println(intArr); // 주소값
        System.out.println(intArr[0]); // null
        System.out.println(intArr[0][0]); // nullPointerException
        */
        intArr[0] = new int[5];
        intArr[1] = new int[2];
        intArr[2] = new int[1];
        intArr[3] = new int[4];

        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr[i].length; j++) {
                System.out.print(intArr[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("-----개선된 for문-----");
        for(int[] row: intArr){
            for(int v: row){
                System.out.print(v+ "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MultiArrayExam ma = new MultiArrayExam();
        ma.stringArrayPrint();
        ma.intArrayExam();
    }
}
