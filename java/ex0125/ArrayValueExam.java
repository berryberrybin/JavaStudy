package ex0125.Array;

class ArrayValue {
    //정수형 10개 저장하는 배열선언(선언과 동시에 임의값 지정)
    int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int [] arr1 = new int[10]; // 배열안의 값을 모두 0으로 초기화
    int [] arr2;


    /*printArrayValue 메소드작성
        => 메소드 안에서 위에 선언된 배열방의 값을 출력한다.
     */
    public void printArrayValue() {
        System.out.println("arr = " + arr); // arr 주소값 출력됨
        System.out.println("arr2 = " + arr2); // null이 출력됨


        System.out.println("배열 길이 출력 : arr.length = " + arr.length);
        System.out.println("배열 값 1개 출력 : arr[2] = " + arr[2]);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]);
        }

        /* for(타입 변수 : 반복대상) {
              System.out.print (변수) ;
            }
            반복 대상의 0번지부터 마지막번지까지 반복하면서 데이터를 꺼냄
        */
        System.out.println();
        System.out.println("개선된 for 문");
        for(int arr1Value :arr1){
            System.out.print(arr1Value);
        }

        System.out.println();
    }
}

public class ArrayValueExam {
    // ArrayValue 에 있는 printArrayValue 메소드 호출
    public static void main(String args[]) {
        // ArrayValue a = new ArrayValue();
        // a.printArrayValue();

        new ArrayValue().printArrayValue();
    }
}
