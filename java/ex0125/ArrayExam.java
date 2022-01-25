package ex0125.Array;


public class ArrayExam {
    //각 int,double,char,boolean ,String type 별로 총 5개씩 저장하는  배열을 생성하세요

    /* int[] intArray;
    int[] intArray;
    double[] doubleArray ;
    char[] charArray;
    boolean[] booleanArray;
    String[] stringArray; // 모두 null 값이 들어가있음
    */

    // 배열이 각각 생성됨
    int[] intArray = new int[5];
    // intArray 는 intArray 배열 주소값을 갖고 있으며, intArray 배열 0~4번지까지  0  들어가있음
    double[] doubleArray = new double[5]; // 0~4번지까지  0.0  들어가있음
    char[] charArray = new char[5]; // 0~4번지까지  \u0000  들어가있음
    boolean[] booleanArray = new boolean[5]; //0~4번지까지  false  들어가있음
    String[] stringArray = new String[5]; // 0~4번지까지  null  들어가있음


    //메소드 : printArrayValue01
    //위의 배열들에 자동으로 초기화 된값을 출력하세요
    public void printArrayValue01() {
        System.out.print("int 배열: ");
        for (int i : intArray) {
            System.out.print(i + "   ");
        }
        System.out.println();

        System.out.print("double 배열: ");
        for (double d : doubleArray) {
            System.out.print(d + "   ");
        }
        System.out.println();

        System.out.print("char 배열: ");
        for (char c : charArray) {
            System.out.print(c + "   ");
        }
        System.out.println();


        System.out.print("boolean 배열: ");
        for (boolean b : booleanArray) {
            System.out.print(b + "   ");
        }
        System.out.println();


        System.out.print("string 배열: ");
        for (String s : stringArray) {
            System.out.print(s + "   ");
        }
        System.out.println();

    }

    //메소드 : printArrayValue02
    //위의 5개의 배열에서 각각 적당한 값으로 data를 할당하세요.

    public void printArrayValue02() {
        // intArray = {2,4,6,8,10} : 오류 발생
        // int [] intArray = {2,4,6,8,10) ; : 지역배열을 새롭게 생성
        // intArray = new int[]{2, 4, 6, 8, 10}; : 새로운 배열을 생성해서 전역변수 새롭게 저장 (주소값 변경됨)

        for (int i = 0; i < 5; i++) {
            intArray[i] = i * 10;
            doubleArray[i] = i * 0.5;
            charArray[i] = (char) ('A' + i);
            if (i % 2 == 0) booleanArray[i] = true;
            stringArray[i] = "S" + i;

        }
    }

    //메소드 : printArrayValue03
    //새롭게 할당된값을 출력하세요
    public void printArrayValue03() {
        System.out.println("-----새롭게 할당된값 출력-------");
        printArrayValue01();
    }

    //메인메소드에서
    //ArrayExam의 메소드들을 순서대로 호출하세요.
    public static void main(String[] args) {
        ArrayExam ar = new ArrayExam();
        ar.printArrayValue01();
        ar.printArrayValue02();
        ar.printArrayValue03();
    }
}
